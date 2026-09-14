import os
import json
from typing import List

from google.oauth2.credentials import Credentials
from google_auth_oauthlib.flow import InstalledAppFlow
from google.auth.transport.requests import Request
from googleapiclient.discovery import build

# Scopes: read-only for Classroom + Drive
SCOPES = [
    "https://www.googleapis.com/auth/classroom.courses.readonly",
    "https://www.googleapis.com/auth/classroom.coursework.me.readonly",
    "https://www.googleapis.com/auth/drive.readonly",
]

CONFIG_FILE = "config.txt"
CREDENTIALS_FILE = "credentials.json"  # คุณต้องดาวน์โหลดไฟล์นี้มาใส่เอง
TOKEN_FILE = "token.json"
DOWNLOAD_DIR = "downloads_api"


def parse_config():
    email = None
    subject_keyword = None
    file_types: List[str] = []

    if not os.path.exists(CONFIG_FILE):
        print(f"ไม่พบไฟล์ {CONFIG_FILE} ใช้ค่าตั้งต้นว่าง")
        return email, subject_keyword, file_types

    with open(CONFIG_FILE, "r", encoding="utf-8") as f:
        for line in f:
            line = line.strip()
            if not line or ":" not in line:
                continue
            key, value = [x.strip() for x in line.split(":", 1)]
            key_lower = key.lower()
            if key_lower == "email":
                email = value
            elif key_lower == "subject":
                subject_keyword = value
            elif key_lower == "filetype":
                # ตัวอย่างใน config: zip ,pdf
                parts = [p.strip().lstrip(".") for p in value.split(",") if p.strip()]
                file_types = ["." + p for p in parts]

    return email, subject_keyword, file_types


def get_credentials():
    if not os.path.exists(CREDENTIALS_FILE):
        raise FileNotFoundError(
            f"ไม่พบ {CREDENTIALS_FILE}. กรุณาดาวน์โหลดจาก Google Cloud Console แล้ววางในโฟลเดอร์นี้."
        )

    creds = None
    if os.path.exists(TOKEN_FILE):
        creds = Credentials.from_authorized_user_file(TOKEN_FILE, SCOPES)
    # ถ้า token หมดอายุหรือยังไม่มีเลย ให้ทำ flow ใหม่
    if not creds or not creds.valid:
        if creds and creds.expired and creds.refresh_token:
            creds.refresh(Request())
        else:
            flow = InstalledAppFlow.from_client_secrets_file(
                CREDENTIALS_FILE, SCOPES
            )
            creds = flow.run_local_server(port=0)
        # บันทึก token
        with open(TOKEN_FILE, "w", encoding="utf-8") as token:
            token.write(creds.to_json())
    return creds


def find_course(classroom_service, subject_keyword: str):
    """หาคอร์สที่ชื่อมี subject_keyword อยู่ (แบบง่ายๆ ใช้ courses().list)"""
    results = classroom_service.courses().list().execute()
    courses = results.get("courses", [])
    if not courses:
        print("ไม่พบคอร์สใดๆ ใน Classroom")
        return None

    subject_keyword_lower = subject_keyword.lower() if subject_keyword else None

    for course in courses:
        name = course.get("name", "")
        if subject_keyword_lower and subject_keyword_lower in name.lower():
            print(f"พบคอร์ส: {name} (id={course['id']})")
            return course

    print("ไม่พบคอร์สที่ชื่อมีคำว่า:", subject_keyword)
    return None


def get_attachments_from_course(classroom_service, course_id: str):
    """ดึงไฟล์แนบทั้งหมดจากงานของผู้เรียน (courseWork.me.list)"""
    attachments = []

    # ดึงงานทั้งหมดที่ assign ให้ผู้เรียนคนนี้
    coursework_list = []
    page_token = None
    while True:
        resp = classroom_service.courses().courseWork().list(
            courseId=course_id, pageToken=page_token
        ).execute()
        items = resp.get("courseWork", [])
        coursework_list.extend(items)
        page_token = resp.get("nextPageToken")
        if not page_token:
            break

    print(f"พบงานทั้งหมดในคอร์สนี้: {len(coursework_list)} ชิ้น")

    for cw in coursework_list:
        materials = cw.get("materials", [])
        for m in materials:
            drive_file = m.get("driveFile")
            if drive_file and "driveFile" in drive_file:
                file_info = drive_file["driveFile"].get("id"), drive_file["driveFile"].get("title")
            else:
                file_info = None
            if file_info:
                attachments.append(file_info)

    return attachments


def download_files_from_drive(drive_service, attachments, file_types):
    os.makedirs(DOWNLOAD_DIR, exist_ok=True)

    for file_id, title in attachments:
        # ถ้ามีการกำหนด file_types ให้กรองตามนามสกุล
        if file_types:
            matched = False
            for ext in file_types:
                if title and title.lower().endswith(ext.lower()):
                    matched = True
                    break
            if not matched:
                print(f"ข้ามไฟล์ (ไม่ตรงกับ fileType): {title}")
                continue

        request = drive_service.files().get_media(fileId=file_id)
        file_path = os.path.join(DOWNLOAD_DIR, title or file_id)
        print(f"กำลังดาวน์โหลด: {title} -> {file_path}")

        from googleapiclient.http import MediaIoBaseDownload
        import io

        fh = io.FileIO(file_path, "wb")
        downloader = MediaIoBaseDownload(fh, request)
        done = False
        while not done:
            status, done = downloader.next_chunk()
            if status:
                print(f"  ดาวน์โหลดแล้ว {int(status.progress() * 100)}%", end="\r")
        print()


def main():
    email, subject_keyword, file_types = parse_config()
    print("email:", email)
    print("subject keyword:", subject_keyword)
    print("ต้องการไฟล์นามสกุล:", file_types)

    creds = get_credentials()

    classroom_service = build("classroom", "v1", credentials=creds)
    drive_service = build("drive", "v3", credentials=creds)

    if not subject_keyword:
        print("ไม่ได้กำหนด subject ใน config.txt")
        return

    course = find_course(classroom_service, subject_keyword)
    if not course:
        return

    attachments = get_attachments_from_course(classroom_service, course["id"])
    print(f"พบไฟล์แนบทั้งหมด: {len(attachments)} ไฟล์")

    download_files_from_drive(drive_service, attachments, file_types)
    print(f"เสร็จสิ้น: ไฟล์ถูกดาวน์โหลดไว้ในโฟลเดอร์ {DOWNLOAD_DIR}")


if __name__ == "__main__":
    main()
