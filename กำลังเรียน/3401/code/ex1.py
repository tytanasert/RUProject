import cv2
import numpy as np
import matplotlib.pyplot as plt 

# #part1
# print(cv2.IMREAD_COLOR, cv2.IMREAD_GRAYSCALE)
# try:
#     fp = "./images/lena_color_256.tif"
#     img = cv2.imread(fp,0)
#     if img is None:
#         raise FileNotFoundError(f"ไม่พบไฟล์: {fp}")
    
#     cv2.imshow('xxxx', img)
#     cv2.waitKey(0)
#     cv2.destroyAllWindows()
    
#     # print(type(img), img.shape)
# except FileNotFoundError as e:
#     print(f"ไม่พบไฟล์ : {fp}")

#part2
# fp = "./images/lena_color_256.tif"
# img = cv2.imread(fp)
# #เปลี่ยนให้เป็นสี เทา img = cv2.imread(fp,0)

# b,g,r = cv2.split(img) 
# #ถ้าไม่ใช้ split ให้ใช้แบบนี้ก็ได้ b = img[:,:,0] ;g = img[:,:,1] ; r = img[:,:,2] 
# rgb = cv2.merge([r,g,b])
# # print(rgb.shape)

# plt.figure(figsize=(2,2))
# plt.imshow(rgb)
# #ถ้าเป็นสีเทามาต้องใช้คำสั่งนี้เพื่อให้รู้ว่าเป็นสีเทามาแล้ว plt.imshow(img,cmap='gray') 
# plt.axis('off')
# plt.title("color image usingmatplotlib")
# plt.show()
# # plt.savefig('./images/lena_color_256_matplotlib.png')

#part3
r = img[:,:,2].astype(np.float32)
g = img[:,:,1].astype(np.float32)
b = img[:,:,0].astype(np.float32)
gray = 0.299*r + 0.587*g + 0.114*b
gray = np.clip(gray, 0, 255).astype(np.uint8) #คือการจำกัดค่าของพิกเซลให้อยู่ในช่วง 0-255 และแปลงเป็น uint8