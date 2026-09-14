#include<iostream>
using namespace std;

class Date{
    private:
        int day;
        int month;
        int year;
    public:
        Date(){
            day = 1;
            month = 1;
            year = 2000;
        }
        Date(int d, int m, int y){
            day = d;
            month = m;
            year = y;
        }
        ~Date(){
            cout << "Date bye bye" << endl;
        }
        void setDate(Date &d){
            day = d.day;
            month = d.month;
            year = d.year;
        }
        void setDate(int d, int m, int y){
            day = d;
            month = m;
            year = y;
        }
        int getDay(){ return day;}
        int getMonth(){ return month;}
        int getYear(){ return year;}
        void show(){
            cout << day << "/" << month << "/" << year << endl;
        }
};

class Address{
    private:
        int houseNo;
        string street;
        string city;
        string state;
        string zip;
    public:
        Address(){
            houseNo = 0;
            street = "";
            city = "";
            state = "";
            zip = "";
        }
        Address(int hNum, string st, string c, string s, string z){
            houseNo = hNum;
            street = st;
            city = c;
            state = s;
            zip = z;
        }
        ~Address(){
            cout << "Address bye bye" << endl;
        }

        void setAddress(Address &a){
            houseNo = a.getHouseNo();
            street = a.getStreet();
            city = a.getCity();
            state = a.getState();
            zip = a.getZip();
        }
        void setAddress(int hNum, string st, string c, string s, string z){
            houseNo = hNum;
            street = st;
            city = c;
            state = s;
            zip = z;
        }
        int getHouseNo(){ return houseNo;}
        string getStreet(){ return street;}
        string getCity(){ return city;}
        string getState(){ return state;}
        string getZip(){ return zip;}
        void show(){
            cout << houseNo << " " << street << ", " << city << ", " << state << " " << zip << endl;
        }
};

class Person{
    private:
        string fname;
        string lname;
        Date date;
        Address address;
    public:
        Person(){
            cout << "person Cont" << endl;
            fname = "p_basic";
            lname = "p_basicl";
        }
        Person(string fn, string ln){
            cout << "person Cont fn ln" << endl;
            fname = fn;
            lname = ln;
        }
        Person(string fn, string ln, int d, int m, int y, int hNum, string st, string c, string s, string zip){
            cout << "person Cont fn ln d a" << endl;
            fname = fn;
            lname = ln;
            date.setDate(d,m,y);
            address.setAddress(hNum,st,c,s,zip);
        }
        Person(string fn, string ln, Date &d, Address &a){
            cout << "person Cont fn ln d a" << endl;
            fname = fn;
            lname = ln;
            date = d;
            address = a;
        }
        ~Person(){
            cout << "person bye" << endl;
        }

        void setFname(string fn){ fname = fn;}
        void setLname(string ln){ lname = ln;}

        void setDate(Date &d){ date = d;}
        void setDate(int d, int m, int y){ 
            date = Date(d,m,y);
        }

        void setAddress(Address a){ address = a;}
        void setAddress(int hNum, string st, string c, string s, string z){ 
            address = Address(hNum,st,c,s,z);
        }

        string getFname(){ return fname;}
        string getLname(){ return lname;}
        Date* getDate(){ return &date;}
        Address* getAddress(){ return &address;}

        void show(){
            cout << "class Person" << endl;
            cout << "First Name : " << getFname() << endl;
            cout << "Last Name : " << getLname() << endl;
            getDate()->show();
            getAddress()->show();
            cout << endl;
        }
};

class Student:virtual public Person{
    string studentID;
    string major;
    public:
        Student(){
            cout << "student Cont" << endl;
            studentID = "s_basic_id";
            major = "s_basic_major";
        }
        Student(string fn, string ln, int d, int m, int y, int hNum, string st, string c, string s, string zip, string sid, string maj)
        :Person(fn, ln, d, m, y, hNum, st, c, s, zip){
            cout << "student Cont fn ln d m y ..." << endl;
            studentID = sid;
            major = maj;
        }
        Student(string sid, string maj){
            cout << "student Cont sid maj " << endl;
            studentID = sid;
            major = maj;
        }
        ~Student(){
            cout << "student bye" << endl;
        }

        void setStudentId(string sid){ studentID = sid;}
        string getStudentId(){ return studentID;}

        void setMajor(string maj){ major = maj;}
        string getMajor(){ return major;}

        void show(){
            // Person::show();

            cout << "Student ID : " << studentID << endl;
            cout << "Major : " << major << endl << endl;
        }
};

class Teacher:virtual public Person{
    string teacherID;
    string subject;
    public:
        Teacher(){
            cout << "teacher Cont" << endl;
            teacherID = "t_basic_id";
            subject = "t_basic_subject";
        }
        Teacher(string fn, string ln, int d, int m, int y, int hNum, string st, string c, string s, string zip, string tid, string sub)
        :Person(fn, ln, d, m, y, hNum, st, c, s, zip){
            cout << "teacher Cont fn ln d m y ..." << endl;
            teacherID = tid;
            subject = sub;
        }
        Teacher(string tid, string sub){
            cout << "teacher Cont tid sub " << endl;
            teacherID = tid;
            subject = sub;
        }
        ~Teacher(){
            cout << "teacher bye" << endl;
        }

        void setTeacherId(string tid){ teacherID = tid;}
        void setSubject(string sub){ subject = sub;}

        string getTeacherId(){ return teacherID;}
        string getSubject(){ return subject;}

        void show(){
            // Person::show();

            cout << "Teacher ID : " << teacherID << endl;
            cout << "Subject : " << subject << endl << endl;
        }
};


class TeachingAssistant:public Student, public Teacher{
    private:
        string taID;
    public:
        TeachingAssistant(){
            cout << "TA Cont" << endl << endl;
        }
        TeachingAssistant(string fn, string ln, int d, int m, int y, int hNum, string st, string c, string s, string zip,
                          string sid, string maj, 
                          string tid, string sub, 
                          string taId)
                          :Person(fn, ln, d, m, y, hNum, st, c, s, zip)
                          ,Student(sid, maj)
                          ,Teacher(tid, sub){
            setTaId(taId);
        }
        ~TeachingAssistant(){
            cout << "TA bye" << endl;
        }

        void setTaId(string taid){ taID = taid;}
        string getTaId(){ return taID;}

        void showTa(){
            
            cout << "---- Person part ----" << endl;
            Person::show();
            cout << "---- Student part ----" << endl;
            Student::show();
            cout << "---- Teacher part ----" << endl;
            Teacher::show();

            cout << "class TeachingAssistant" << endl;
            cout << "TA ID : " << taID << endl << endl;
        }
};

int main(){
    TeachingAssistant ta;

    TeachingAssistant ta1("fname_1", "lanme_1", 10, 10, 2010, 111, "street_1", "ramkam", "huamark", "12345",
                          "Sid_11", "Computer Science",
                          "Tid_22", "Computers Science Teacher",
                          "TaId_33");
    ta1.showTa();

    ta1.setFname("fname_2");
    ta1.setLname("lanme_2");
    ta1.setDate(20,12,2020);
    ta1.setAddress(222, "street_t_2", "huamark", "bangkok", "22222");
    ta1.setStudentId("Sid_22");
    ta1.setMajor("Computer freshy");
    ta1.setTeacherId("Tid_33");
    ta1.setSubject("Computers Science Teacher beginner");
    ta1.setTaId("TaId_44");
    ta1.showTa();

    cout << "TaId : " << ta1.getTaId() << endl << endl;

    return 0;
}