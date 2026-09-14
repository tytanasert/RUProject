# HW3 — Wheat Seeds Dataset : Basic Statistics & Visualization

## ไฟล์ส่ง
| ไฟล์ | คำอธิบาย |
|---|---|
| `Wheat_Seeds_Presentation.pptx` | สไลด์นำเสนอ 15 หน้า (ที่มา/ความสำคัญ + ค่าสถิติเบื้องต้น + กราฟ) |
| `wheatseed_eda.ipynb` | Jupyter notebook ทำ EDA เต็ม ๆ + โค้ดสร้างกราฟทุกใบ |
| `charts/` | รูปกราฟ 10 ใบ (PNG) ที่ notebook สร้างและถูกฝังในสไลด์ |
| `wheat-seeds.csv` | ชุดข้อมูลต้นฉบับ (210 แถว, ไม่มี header) |

## โครงสร้างสไลด์ (15 หน้า)
1. หน้าปก + roadmap 3 ส่วน
2. ที่มาของชุดข้อมูล (UCI, Institute of Agrophysics, วิธีวัดด้วย soft X-ray)
3. ความสำคัญ / ทำไมถูกใช้บ่อย
4. โครงสร้างข้อมูล (210 × 8, คลาสสมดุล 70:70:70, 0 missing)
5. ความหมายของ 7 ตัวแปร + สูตร Compactness
6. ค่าสถิติเบื้องต้น — `describe()` (mean/std/min/Q1/median/Q3/max)
7. Range / Mode / Skewness / Kurtosis + การตรวจ outlier ด้วยกฎ IQR
8. ค่าเฉลี่ยแยกตามสายพันธุ์ (ตาราง + กราฟแท่ง)
9. กราฟ: การกระจายจำนวนเมล็ด + histogram รวม
10. กราฟ: histogram แยกตามสายพันธุ์
11. กราฟ: boxplot + violin แยกตามสายพันธุ์
12. กราฟ: correlation heatmap
13. กราฟ: pairplot
14. กราฟ: scatter คู่เด่น + parallel coordinates
15. สรุปข้อค้นพบ (Key Findings)

## รันซ้ำ notebook
```bash
pip install pandas numpy matplotlib seaborn scipy nbconvert
jupyter nbconvert --to notebook --execute --inplace wheatseed_eda.ipynb
```
กราฟจะถูกเขียนทับลงในโฟลเดอร์ `charts/`

## หมายเหตุเรื่องฟอนต์
สไลด์ตั้งฟอนต์เป็น **Sarabun** (ฟอนต์ราชการ/วิชาการไทย + รองรับ Latin)
ถ้าเครื่องที่เปิดไม่มี Sarabun ให้เปลี่ยน theme font ใน PowerPoint เป็น Tahoma / TH Sarabun New ได้
(ระหว่างทำงานได้ก๊อป `Sarabun.ttc`, `Thonburi.ttc` ไปไว้ที่ `~/Library/Fonts/` เพื่อให้ LibreOffice เรนเดอร์ตัวอย่างได้ — ถอดออกได้ถ้าไม่ต้องการ)

## แหล่งข้อมูล
Charytanowicz, M. et al. — *Seeds Data Set*, UCI Machine Learning Repository
<https://archive.ics.uci.edu/dataset/236/seeds>
