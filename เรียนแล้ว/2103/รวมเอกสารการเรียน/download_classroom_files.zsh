#!/usr/bin/env zsh

# สคริปต์นี้จะอ่านลิงก์จากไฟล์ links.txt แล้วดาวน์โหลดไฟล์ทั้งหมด
# รองรับการดาวน์โหลดไฟล์จาก Google Drive (ผ่าน gdown) หรือไฟล์ทั่วไป (ผ่าน curl)

set -e

# โฟลเดอร์ปลายทาง (ถ้าอยากเปลี่ยนให้แก้ตัวแปรนี้)
DOWNLOAD_DIR="downloads"
LINKS_FILE="links.txt"

# อ่านชนิดไฟล์ที่ต้องการจาก config.txt (เช่น: zip ,pdf)
FILE_TYPES=()
if [[ -f "config.txt" ]]; then
  # ดึงเฉพาะส่วนหลัง "fileType : " แล้วลบช่องว่าง
  types_raw=$(grep -i "fileType" config.txt | sed 's/.*fileType *: *//I')
  # แยกด้วยคอมมา และตัดช่องว่างออก
  IFS=',' read -A tmp <<< "$types_raw"
  for t in "${tmp[@]}"; do
    t_clean=${t// /}
    [[ -n "$t_clean" ]] && FILE_TYPES+=".$t_clean"
  done
fi

mkdir -p "$DOWNLOAD_DIR"

if [[ ! -f "$LINKS_FILE" ]]; then
  echo "ไม่พบไฟล์ $LINKS_FILE กรุณาสร้างไฟล์และใส่ลิงก์ทีละบรรทัด"
  exit 1
fi

# ฟังก์ชันเช็คว่าไฟล์ตรงกับชนิดที่ต้องการไหม
matches_filetype() {
  local filename="$1"
  # ถ้าไม่ได้กำหนด FILE_TYPES ไว้เลย ให้ผ่านทุกไฟล์
  if [[ ${#FILE_TYPES[@]} -eq 0 ]]; then
    return 0
  fi
  for ext in "${FILE_TYPES[@]}"; do
    if [[ "$filename" == *"$ext" ]]; then
      return 0
    fi
  done
  return 1
}

# ฟังก์ชันเดาว่าลิงก์เป็น Google Drive หรือไม่
is_gdrive_url() {
  local url="$1"
  if [[ "$url" == *"drive.google.com"* ]]; then
    return 0
  else
    return 1
  fi
}

# เริ่มอ่านลิงก์ทีละบรรทัด
while IFS= read -r url || [[ -n "$url" ]]; do
  # ข้ามบรรทัดว่างหรือบรรทัดที่ขึ้นต้นด้วย #
  [[ -z "$url" ]] && continue
  [[ "$url" == \#* ]] && continue

  echo "\nกำลังประมวลผล: $url"

  if is_gdrive_url "$url"; then
    # ใช้ gdown
    echo "  ตรวจพบว่าเป็นลิงก์ Google Drive -> ใช้ gdown"
    # ถ้าต้องการตั้งชื่อไฟล์เองให้ใช้ -O; ที่นี่ให้ gdown ตั้งชื่อเองในโฟลเดอร์
    gdown "$url" -O "$DOWNLOAD_DIR" || echo "  ดาวน์โหลดไม่สำเร็จ: $url"
  else
    # ลิงก์ปกติ ใช้ curl
    filename=$(basename "$url" | cut -d'?' -f1)

    # ถ้าไม่มีชื่อไฟล์ให้สร้างสุ่มๆ
    if [[ -z "$filename" || "$filename" == "/" ]]; then
      filename="file_$(date +%s%N)"
    fi

    if ! matches_filetype "$filename"; then
      echo "  ข้ามไฟล์ (ไม่ตรงกับ fileType ที่กำหนด): $filename"
      continue
    fi

    echo "  ดาวน์โหลดด้วย curl: $filename"
    curl -L "$url" -o "$DOWNLOAD_DIR/$filename" || echo "  ดาวน์โหลดไม่สำเร็จ: $url"
  fi

 done < "$LINKS_FILE"

echo "\nเสร็จสิ้น: ไฟล์ทั้งหมดถูกเก็บในโฟลเดอร์ '$DOWNLOAD_DIR'"
