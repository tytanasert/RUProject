#include <fstream>
#include<iostream>
#include<string>
#include<iomanip>
using namespace std;
#define infile "goods.txt"
#define outfile "group1.txt"
int main(){
ifstream ids; //input data stream
ofstream ods;
struct Good //โครงสร้างข้อมูลสินค้า
{ string id; //รหัสสินค้า
 string name; // ชื่อสินค้า
 int unit; // จำนวน
 float cost; //ราคา
 };
 Good go[5];
 ids.open(infile);
 ods.open(outfile);
 if(ids.fail()) //การตรวจสอบการเชื่อมต่อระหว่างอ็อบเจ็กต์
 {
     cerr<<"Can't open "<<infile<<endl;
     return EXIT_FAILURE;
 }
 string sid;
 string sname;
 int sunit;  
 float scost;

 while(!ids.eof()){
     ids>>sid>>sname>>sunit>>scost;
    if (sunit < 100){
        ods<<sid<<" "<<sname<<" "<<sunit<<" "<<scost<<endl;
    }
 }
 ids.close();
 ods.close();
 return 0;    
}   
