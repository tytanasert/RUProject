#include<fstream> //คลาสแฟ้มข้อมูล
#include<iostream>
#include<string>
using namespace std;
#define infile "input.txt" 
#define outfile "output.txt"  
int main() {
  ofstream ods1;
  ofstream ods2; //output data stream
  ifstream ids1;

string id; //รหัสพนักงาน
string name;
double salary; //salary
double tax; //tax
double net; // net

ods1.open(infile); //การติดต่อหรือเชื่อมต่ออ็อบเจ็กต์
ods2.open(outfile); //การติดต่อหรือเชื่อมต่ออ็อบ
if(ods1.fail()) //การตรวจสอบการเชื่อมต่อระหว่างอ็อบเจ็กต์
{
cerr<<"Can't open "<<infile<<endl;
return EXIT_FAILURE;
}
if(ods2.fail()) //การตรวจสอบการเชื่อมต่อระหว่างอ็อบเจ็กต์
{
cerr<<"Can't open "<<outfile<<endl;
return EXIT_FAILURE;
}
cout<<"id= "; cin>>id; //รหัสพนักงานคนแรก
while(id != "000") //เงือนไขการท าซ ้า
{
  cout <<"name=" ; cin >> name; 
  cout<<"salary="; cin>> salary;       // A = 80 - 100  B=79-70  C = 69 - 60  D = 59 - 50 F = 49-0  
  //น าข้อมูลพนักงานบันทึกในไฟล์ที่ก 
  ods1<<id<<  " " << name << " "<< salary << endl;
  
  cout<<"id= "; cin>> id;//
}
ods1.close(); //ยกเลิกการติดต่อ
ods2.close(); //ยกเลิกการติดต

ids1.open(infile);
ods2.open(outfile);
if(ids1.fail()) //การตรวจสอบการเชื่อมต่อระหว่างอ็อบเจ็กต์
{
cerr<<"Can't open "<<infile<<endl;
return EXIT_FAILURE;
}
ids1>>id>>name>>salary;
while (!ids1.eof()){
    tax = salary * 0.1;
    net = salary - tax;
    ods2<<id<< " " << name << " " <<salary<< " " <<tax<< " " << net << endl;
    ids1>>id>>name>>salary;
}
ids1.close();
ods2.close();
return 0;
}