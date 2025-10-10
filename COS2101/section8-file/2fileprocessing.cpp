#include<iostream>
#include<fstream>

using namespace std;
#define resultFile "Result.txt"

string calgrade(double total){
    if(total >= 80){
        return "A";
    }else if(total >= 70){
        return "B";
    }else if(total >= 60){
        return "C";
    }else if(total >= 50){
        return "D";
    }else{
        return "F";
    }
}
void display1(){
    ofstream ods; //output data stream
    string id; //รหัสพนักงาน
    string name; //ชื่อพนักงาน
    double exam;
    double score;
    double total;
    string grade;
    
    ods.open(resultFile); //การติดต่อหรือเชื่อมต่ออ็อบเจ็กต์
    if(ods.fail()) //การตรวจสอบการเชื่อมต่อระหว่างอ็อบเจ็กต์
    {
        cerr<<"Can't open "<< resultFile <<endl;
        // return EXIT_FAILURE;
        return;
    }
    ods<< "  ID  " << "name  " << "exam  " << "score  " << "total  " << "grade  " << endl;
    ods<< "---------------------------------------------------------------------" << endl;
    for(int i=0;i<5;i++){
        cout<<"id= "; cin>>id; //รหัสพนักงาน
        cout<<"name= "; cin>>name; //รหัสพนักงานคนแ
        cout<<"exam="; cin>>exam;
        cout<<"score="; cin>>score;
        total = exam + score;
        grade = calgrade(total);
        //นำข้อมูลพนักงานบันทึกในไล์ที่กำหนด
        ods << "  " << id << "    " << name << "    " << exam << "    " << score << "        " << total << "      " << grade << endl;
    }
    ods<< "---------------------------------------------------------------------" << endl;
    ods.close(); //ยกเลิกการติดต่อ
}

int main(){
    display1();
    
}