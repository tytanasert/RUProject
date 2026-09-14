# Midterm — Mumbai University KT Students : สถิติเชิงพรรณนา & ความสัมพันธ์

> ผู้จัดทำ: **นายธนเสริฐ ตั้งตรงสกุลดี** · รหัสนักศึกษา **6805007181** · วิชา COS3302 Data Science (สอบกลางภาค)
> สไลด์ปรับดีไซน์เป็นสไตล์ "lab-notebook" โทนอุ่น (อ้างอิงจาก `hw3/Decoding_Wheat_Seed_Geometry.pptx`)
> — พื้นครีม, กรอบมน, หัวข้อ + kicker + เส้นสีประจำส่วน, สไลด์ big-number, ตารางสีเข้ม, กราฟ + คำอธิบายด้านข้าง
> กราฟใน notebook เปลี่ยนธีมให้เข้ากัน (พื้นครีม + จานสี slate / terracotta / sage)

## ไฟล์ส่ง
| ไฟล์ | คำอธิบาย |
|---|---|
| `mumbai_kt_eda.ipynb` | Jupyter notebook ทำ EDA เต็ม (โครงตาม `hw3/wheatseed_eda.ipynb`) — โหลดข้อมูล, คุณภาพข้อมูล, สถิติเชิงพรรณนา, ความสัมพันธ์ 3 คู่ประเภท + โค้ดสร้างกราฟทุกใบ |
| `Mumbai_KT_EDA_Presentation.pptx` | สไลด์นำเสนอ 19 หน้า (ฟอนต์ Sarabun · โทนอุ่น slate/terracotta/sage/gold) |
| `Mumbai_KT_EDA_Presentation.pdf` | สไลด์เวอร์ชัน PDF |
| `charts/` | รูปกราฟ 12 ใบ (PNG) ที่ notebook สร้างและถูกฝังในสไลด์ |
| `Mumbai_University_KT_Students_Dataset.csv` | ชุดข้อมูลต้นฉบับ (10,000 แถว × 21 คอลัมน์, มี header) |
| `build_notebook.py` / `build_pptx.py` | สคริปต์ประกอบ notebook และสไลด์ (รันซ้ำได้) |

## โครงสไลด์ (24 หน้า)
1. หน้าปก + roadmap 3 ส่วน
2–3. ที่มา + ความสำคัญของชุดข้อมูล (KT = "Keep Terms" = ติดค้างวิชา)
4. โครงสร้างข้อมูล (21 คอลัมน์แบ่ง 6 กลุ่ม)
5–6. คุณภาพข้อมูล: ค่าหาย ~2% ใน 4 คอลัมน์ตัวเลข, ไม่มี dup, **redundancy** ของ `Has_KT` / `Cleared_in_First_Attempt` / `Number_of_KTs>0`
7. `describe()` ตัวแปรตัวเลข 8 ตัว
8. สถิติขยาย: range / mode / IQR / skew / kurtosis
9. ตารางความถี่ตัวแปรจัดกลุ่ม
10–12. กราฟ univariate: histogram, bar categorical, target distribution
13. **ความสัมพันธ์ ตัวเลข × ตัวเลข** — Pearson & Spearman heatmap
14–15. ปัจจัยตัวเลขที่ขับเคลื่อนจำนวน KT (correlation bar + regression)
16–17. **ตัวเลข × กลุ่ม** — violin by `Has_KT` + ANOVA, mean KT by category
18–19. **กลุ่ม × กลุ่ม** — Cramér's V heatmap, `Stress_Level` × `Has_KT`
20. Pairplot ปัจจัยหลัก แยกสีตาม `Has_KT`
21. Interaction: `Stress_Level` × ช่วงการเข้าเรียน
22–23. สรุปข้อค้นพบ (Key Findings)
24. ปิด

## รันซ้ำ notebook
```bash
pip install pandas numpy matplotlib seaborn scipy nbformat nbconvert python-pptx
python build_notebook.py
jupyter nbconvert --to notebook --execute --inplace mumbai_kt_eda.ipynb
```
กราฟจะถูกเขียนทับลงในโฟลเดอร์ `charts/`

## สร้างสไลด์ใหม่ (.pptx → .pdf)
```bash
python build_pptx.py
soffice --headless --convert-to pdf Mumbai_KT_EDA_Presentation.pptx
```
> หมายเหตุฟอนต์: สไลด์ตั้งฟอนต์ **Sarabun** ถ้าเครื่องไม่มี ให้เปลี่ยน theme font เป็น TH Sarabun New / Tahoma
> การ export PDF ด้วย LibreOffice headless บนเครื่องนี้ต้องชี้ `FONTCONFIG_FILE` ไปยัง fonts.conf ที่ระบุ `~/Library/Fonts`
> มิฉะนั้นอักษรไทยจะหาย (ใช้ไบนารีจาก `/Applications/LibreOffice.app/Contents/MacOS/soffice`)

## ข้อค้นพบหลัก (สรุป)
1. ข้อมูลสะอาด: 10,000 × 21 ไม่มีแถว/ID ซ้ำ; ค่าหายเฉพาะ 4 คอลัมน์ตัวเลข ~2% กระจายแบบสุ่ม (คล้าย MCAR)
2. `Has_KT`, `Cleared_in_First_Attempt`, `(Number_of_KTs > 0)` = ข้อมูลชุดเดียวกัน → เลือกใช้ตัวเดียวเป็นเป้าหมาย
3. เป้าหมายไม่สมดุล: 74% ของนักศึกษาติด KT ≥ 1 วิชา (เฉลี่ย 1.54, สูงสุด 7)
4. ปัจจัยตัวเลขที่ลด KT: `Previous_Semester_SGPA` (r≈−0.35), `Study_Hours_per_Day` (−0.30), `Attendance_Percentage` (−0.30)
5. ปัจจัยที่เพิ่ม KT: `Social_Media_Hours_per_Day` (r≈+0.18), `Commute_Time_mins` (+0.11); การนอน/อายุ แทบไม่มีผล
6. ปัจจัยกลุ่มที่แยกความเสี่ยงได้ชัดสุดคือ `Stress_Level` (เฉลี่ย 0.6 → 3.5 วิชา) รองลงมา `Commute_Mode`, `Peer_Learning`, `Mentorship_Available`
7. ไม่มีผล: เพศ, สาขา, ชั้นปี, ฐานะการเงิน, กิจกรรมนอกหลักสูตร
8. ตัวแปรอินพุตตัวเลขสหสัมพันธ์กันเองต่ำ → ไม่มี multicollinearity
