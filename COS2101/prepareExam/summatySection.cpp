#include <iostream>
//ใช้สำหรับการรับ-ส่งข้อมูลผ่านมาตรฐาน เช่น std::cout (แสดงผลบนหน้าจอ) และ std::cin (รับค่าจากคีย์บอร์ด)

#include <string>
//ใช้สำหรับคลาส std::string ซึ่งเป็นสตริงแบบ C++ ที่ใช้งานง่ายและปลอดภัยกว่าแบบ C

#include <cstring>
//ใช้สำหรับฟังก์ชันจัดการกับสตริงแบบ C เช่น strcpy, strlen, strcmp เป็นต้น

#include <fstream>
//ใช้สำหรับการอ่าน/เขียนไฟล์ใน C++ เช่น std::ifstream (อ่านไฟล์), std::ofstream (เขียนไฟล์)

#include <ctype.h>
//ใช้สำหรับฟังก์ชันตรวจสอบและแปลงอักขระ เช่น toupper, tolower, isdigit, isalpha เป็นต้น

#include <iomanip>
//ใช้สำหรับการจัดรูปแบบการแสดงผล เช่น กำหนดจำนวนทศนิยม (std::setprecision), การจัดตำแหน่ง (std::setw)

#include <stdio.h>
//เป็นไลบรารีมาตรฐานของ C สำหรับการรับ-ส่งข้อมูล เช่น printf, scanf, fopen, fclose
//(ใน C++ มักใช้ iostream แทน แต่บางกรณีอาจยังใช้ร่วมกัน)

using namespace std;

#define outfile1 "out1.txt" 

//คำสั่ง
//strcmp เพื่อเปรียบเทียบสตริงแบบ char[] สองตัว :  คืน 0 ถ้าเหมือนกัน
//strcpy เพื่อคัดลอกสตริงแบบ char[] :  คืนค่าตำแหน่งที่ถูกคัดลอก
//strlen เพื่อหาความยาวของสตริงแบบ char[] :  คืนค่าจำนวนอักขระ
//isalpha(c) เพื่อตรวจสอบว่า c เป็นตัวอักษรหรือไม่
//isdigit(c) เพื่อตรวจสอบว่า c เป็นตัวเลขหรือไม่
//isupper(c) เพื่อตรวจสอบว่า c เป็นตัวอักษรพิมพ์ใหญ่หรือไม่


struct Account {
    char  id[10];
    char  name[20+30];
    char  address[200];
    float deposit;
};

//การใช้ * นำหน้า parameter คือการประกาศให้ parameter นั้นเป็น pointer เพื่อรับค่าที่อยู่ของข้อมูล (address) แทนการรับค่าจริง (value) ซึ่งช่วยให้ฟังก์ชันสามารถเข้าถึงหรือแก้ไขข้อมูลต้นฉบับได้
int befound(Account acc[], int n, char *id){
    int temp;
    temp = *id;	 
    return -1;
}


void inputAccount(Account &a) {
    cout << "Enter id: ";
    cin >> a.id;
    cout << "Enter name: ";
    cin >> a.name;
    cout << "Enter address: ";
    cin >> a.address;
    cout << "Enter deposit: ";
    cin >> a.deposit;
}

void file1(){

    ofstream ods; //output data stream
    string id; //รหัสพนักงาน
    double score;
    ods.open(outfile1); //การติดต่อหรือเชื่อมต่ออ็อบเจ็กต์
    if(ods.fail()) //การตรวจสอบการเชื่อมต่อระหว่างอ็อบเจ็กต์
    {
    cerr<<"Can't open "<< outfile1 <<endl;
    // return EXIT_FAILURE;
    return;
    }
    cout<<"id= "; cin>>id; //รหัสพนักงานคนแรก
    while(id != "000") //เงือนไขการท าซ ้า
    {
    cout<<"score="; cin>>score;
    //น าข้อมูลพนักงานบันทึกในไฟล์ที่ก าหนด
    ods<< "id:  " << id << " score: " << score << endl;
    cout<<"id= "; cin>>id;//รหัสพนักงานคนต่อไป
    }
    ods.close(); //ยกเลิกการติดต่อ
    
}

int main()
{

    int n = 10;
    int i = 0;
    char  id[10];
    int choice;
    float deposit,withdraw,rate;
    bool bfound ;
    struct Account acc[100];
    int *px;
    px = &n;
    int **ppx;
    ppx = &px;
    struct Account *pacc;
    pacc = &acc[0];

    cout << "id = ";
    cin >> id[0];

    while(true)
    {
        break;
    }

    for(i=0 ; i < n ; i++) {
        if( strcmp( id, acc[i].id) == 0) {
            bfound=true;
            cout << "id duplicate" << endl;
            break;
        }
    }

    switch(choice)
    {
        case 1:
            break;
        case 2:
            break;
        case 3:
            break;      
    }

    befound(acc, n, id);
    inputAccount(acc[n]);

    return 0;
}
