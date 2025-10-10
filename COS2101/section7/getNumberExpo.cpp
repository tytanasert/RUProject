
#include <iostream>
using namespace std;
//รับข้อมูลจนำกรทั้ง id==-1
struct Number { // สร้างโครงสร้างข้อมูลนักศึกษา
    int coef; // รหัสนักศึกษา
    int power; // คะแนนสอบ
    Number* next; // พอยเตอร์ชี้ไข้อมูลนักศึกษาคนถัด
};

void addData( struct Number * &head , int coef,int power )
{
    struct Number *x = NULL;
    struct Number *p = NULL;
    struct Number *q = head;
    
    while(q!=NULL) {
        p = q;
        q = q->next;
    }
    
    x = new struct Number;
    x->coef = coef;
    x->power = power;
    x->next = NULL;
    if(head==NULL) {
        head = x;
    }
    else {
        p->next = x;
    }
    
}

void getData(struct Number * &head)
{
    int coef;
    int power;
    
    do{
        cout << "\ncoef = ";
        cin >> coef;
        cout << "power = " ; 
        cin >> power;
        addData( head , coef,power );
    }while(power > 0);
}

void displayData(struct Number *head)
{
    
    while(head!=NULL) {
        //cout << "\ncoef = "  << p->coef  << ", power " << p->power;
        cout << head->coef << "x^" << head->power << " ";
        head = head->next;
    }
}


int main()
{
    struct Number *head= NULL;
    getData(head);
    displayData(head);
    
    return 0;
}