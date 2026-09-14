
#include <iostream>
using namespace std;
//รับข้อมูลจนำกรทั้ง id==-1
struct Student { // สร้างโครงสร้างข้อมูลนักศึกษา
    int id; // รหัสนักศึกษา
    int score; // คะแนนสอบ
    Student* next; // พอยเตอร์ชี้ไข้อมูลนักศึกษาคนถัด
};

void addData( struct Student * &head , int id,int score )
{
    struct Student *x = NULL;
    struct Student *p = NULL;
    struct Student *q = head;
    
    while(q!=NULL) {
        p = q;
        q = q->next;
    }
    
    x = new struct Student;
    x->id = id;
    x->score = score;
    x->next = NULL;
    if(head==NULL) {
        head = x;
    }
    else {
        p->next = x;
    }
    
}

void getData(struct Student * &head)
{
    int id;
    int score;
    cout << "\nid = ";
    cin >> id;
    while(id!=-1) {
        
        cout << "score = " ; 
        cin >> score;
        
        addData( head , id,score );
        
        cout << "id = ";
        cin >> id;
    }
}

void displayData(struct Student *head)
{
    struct Student *p = head;
    while(p!=NULL) {
        cout << "\nid = "  << p->id  << ", score " << p->score;
        p = p->next;
    }
}


int main()
{
    struct Student *head=NULL;
    getData(head);
    displayData(head);
    
    return 0;
}