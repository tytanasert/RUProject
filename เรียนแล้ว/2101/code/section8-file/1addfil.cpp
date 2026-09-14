#include<fstream>
#include<iostream>
#include<string>
using namespace std;
#define outfile "out.txt" //สร้างแฟ้มข้อมูลชื่อ out.txt
#define outfile1 "out1.txt" 
#define outfile2 "out2.txt" 

//ฟังก์ชันบันทึกข้อมูลพนักงานลงแฟ้ม
void file1(){

    ofstream ods; //output data stream
    string id; //รหัสพนักงาน
    double score;
    ods.open(outfile); //การติดต่อหรือเชื่อมต่ออ็อบเจ็กต์
    if(ods.fail()) //การตรวจสอบการเชื่อมต่อระหว่างอ็อบเจ็กต์
    {
    cerr<<"Can't open "<< outfile <<endl;
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

//ฟังก์ชันบันทึกข้อมูลพนักงานลงแฟ้ม 2 แฟ้ม
void open2File(){

    ofstream ods1;
    ofstream ods2;
    string id; //รหัสพนักงาน
    string name; //ชื่อพนักงาน
    // double salary; //เงินเดือน
    double score;
    ods1.open(outfile1);
    ods2.open(outfile2);
    if(ods1.fail() || ods2.fail())
    {
    cerr<<"Can't open "<< outfile1 << " or " << outfile2 <<endl;
    return;
    }
    cout<<"id= "; cin>>id;
    while(id != "000")
    {
    cout<<"name= "; cin>>name;
    // cout<<"salary="; cin>>…………………;
    cout<<"score="; cin>>score;
    ods1<< "id:  " << id << " score: " << score << endl;
    ods2<< "id:  " << id << " name: " << name << endl;
    cout<<"id= "; cin>>id;
    }
    ods1.close();
    ods2.close();

}

//ฟังก์ชั่นรับค่าคะแนนแล้วคำนวณเกรด โดยไฟล์แรกเก็บข้อมูลดิบ อีกไฟล์เก็บข้อมูลผลลัพธ์
void calGrade(){

    ofstream ods1;
    ofstream ods2;
    string id; //รหัสนศ
    string name; //ชื่อนศ
    double score; //คะแนน
    string grade; //เกรด
    ods1.open(outfile1);
    ods2.open(outfile2);
    if(ods1.fail() || ods2.fail())
    {
        cerr<<"Can't open "<< outfile1 << " or " << outfile2 <<endl;
        return;
    }
    
    cout<<"id= "; cin>>id;
    while(id != "000")
    {
    cout<<"name= "; cin>>name;
    do{
            cout<<"score(0-100) ="; cin>>score;
        }while(score < 0 || score > 100);
        
        if(score>=80) grade="A";
        else if(score>=70) grade="B";
        else if(score>=60) grade="C";
        else if(score>=50) grade="D";
        else grade="F";
        ods1<< "id:  " << id << " name: " << name << " score: " << score << endl;
        ods2<< "id:  " << id << " grade: " << grade << endl;
        cout<<"id= "; cin>>id;
    }

    ods1.close();
    ods2.close();

}


int main()
{
    return 0;
}

/*
สรุปคำสั่งสำคัญ
#include<fstream> //ใช้ในการติดต่อกับแฟ้มข้อมูล
#define outfile "out.txt" //สร้างแฟ้มข้อมูลชื่อ out.txt
ofstream ods; //สร้างอ็อบเจ็กต์เพื่อเขียนข้อมูลลงแฟ้ม
ods.open(outfile); //การติดต่อหรือเชื่อมต่ออ็อบเจ็กต์
ods.fail() //การตรวจสอบการเชื่อมต่อระหว่างอ็อบเจ็กต์
ods<< "id:  " << id << " score: " << score << endl; //บันทึกข้อมูลลงแฟ้ม
ods.close(); //ยกเลิกการติดต่อ
*/
