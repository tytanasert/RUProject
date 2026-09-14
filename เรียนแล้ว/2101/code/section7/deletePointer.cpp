#include <iostream>
using namespace std;

struct Student { 
    int id; 
    int score;
    Student* next;
};

void main(){
    struct Student *first = NULL;

    // สร้าง linked list ตัวอย่าง
    first = new Student{1, 90};
    first->next = new Student{2, 85};
    first->next->next = new Student{3, 80};

    // ลบทุก node ใน linked list ด้วย loop
    Student* current = first;
    while (current != NULL) {
        Student* temp = current;
        cout << "id : " << temp->id << " score :" << temp->score << endl;
        current = current->next;
        delete temp;
    }
    first = NULL;

}