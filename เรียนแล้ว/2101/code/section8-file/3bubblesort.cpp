//buble sort is a simple sorting algorithm that repeatedly steps through the list,
//compares adjacent elements and swaps them if they are in the wrong order.
//The pass through the list is repeated until the list is sorted.
#include <iostream>
#include <fstream>

using namespace std;

#define infile "result.txt"

struct Student{
    string id;
    string name;
    float exam;
    float score;
    float total;
    char grade;
};

int readFile(struct Student (&stu)[]){
    ifstream ids1;
    ids1.open(infile);
    
    if(ids1.fail()){
        cerr << "error to open file : " << infile << endl;
        return 0;
    }
    
    string sid;
    string sname;
    float sexam;
    float sscore;
    float stotal;
    char sgrade;
    int i=0;
    ids1 >> sid >> sname >> sexam >> sscore >> stotal >> sgrade;
    
    while(!ids1.eof()){
        stu[i].id = sid;
        stu[i].name = sname;
        stu[i].exam = sexam;
        stu[i].score = sscore;
        stu[i].total = stotal;
        stu[i].grade = sgrade;
        i++;
        ids1 >> sid >> sname >> sexam >> sscore >> stotal >> sgrade;    
    }
    
    return 1;
}

void display(struct Student (&stu)[]){
    for(int i =0;i<5;i++){
        cout << stu[i].id << " " << stu[i].name<< " " << stu[i].exam << " " << stu[i].score<< " " << stu[i].total<< " " << stu[i].grade <<endl;
    }
    cout << endl;
}

void sort(struct Student (&stu)[]){
    
    for (int i = 0; i < 5 - 1; ++i) {
        for (int j = 0; j < 5 - i - 1; ++j) {
            if (stu[j].total < stu[j + 1].total) {  
                struct Student temp = stu[j];
                stu[j] = stu[j + 1];
                stu[j + 1] = temp;
            }
        }
    }
}

int main(){
    Student stu[5];
    
    int error = readFile(stu);
    if(error == 0){
        return EXIT_FAILURE;
    }
    
    display(stu);
    
    sort(stu);
    
    display(stu);
    
 return 0;   
}