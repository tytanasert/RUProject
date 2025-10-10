#include <fstream>
#include<iostream>
#include<string>
#include<iomanip>
using namespace std;
#define infile "goods.txt"
#define outfile "group2.txt"

struct Good //โครงสร้างข้อมูลสินค้า
{ string id; //รหัสสินค้า
 string name; // ชื่อสินค้า
 int unit; // จำนวน
 float cost; //ราคา
 };
 
 void sort(struct Good (&go)[], int count){
    for (int i = 0; i < count - 1; ++i) {
        for (int j = 0; j < count - i - 1; ++j) {
            if (go[j].cost < go[j + 1].cost) {  
                struct Good temp = go[j];
                go[j] = go[j + 1];
                go[j + 1] = temp;
            }
        }
    }
}

int main(){
ifstream ids; //input data stream
ofstream ods;

 struct Good go[7];
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
 int i=0;
 int count = 0;

do{
     ids>>sid>>sname>>sunit>>scost;
     go[i].id = sid;
     go[i].name = sname;
     go[i].unit = sunit;
     go[i].cost = scost;
     i++;
     count++;
 }while(!ids.eof());
 
  sort(go,count);
 
 for(int i=0; i < count ;i++){
     ods << go[i].id << "  " << go[i].name << "  " << go[i].unit << "  " << go[i].cost << endl;
 }
 
 ids.close();
 ods.close();
 return 0;    
}   
