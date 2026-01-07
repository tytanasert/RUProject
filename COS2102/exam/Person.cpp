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

class Student:public Person{
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
        ~Student(){
            cout << "student bye" << endl;
        }

        void setStudentId(string sid){ studentID = sid;}
        string getStudentId(){ return studentID;}

        void setMajor(string maj){ major = maj;}
        string getMajor(){ return major;}

        void show(){
            Person::show();

            cout << "Student ID : " << studentID << endl;
            cout << "Major : " << major << endl << endl;
        }
};

class Teacher:public Person{
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
        ~Teacher(){
            cout << "teacher bye" << endl;
        }

        void setTeacherId(string tid){ teacherID = tid;}
        void setSubject(string sub){ subject = sub;}

        string getTeacherId(){ return teacherID;}
        string getSubject(){ return subject;}

        void show(){
            Person::show();

            cout << "Teacher ID : " << teacherID << endl;
            cout << "Subject : " << subject << endl << endl;
        }
};

int main(){
    Person p;
    p.show();

    Student s;
    s.show();

    Teacher t;
    t.show();

    cout << "------------ p1 ------------" << endl;
    Person p1("p_fname", "p_lname", 11, 10, 1990, 110, "p_street", "p_city", "p_state", "11111");
    p1.show();

    cout << "------------ s1 ------------" << endl;
    Student s1("s_fname", "s_lname", 20, 2, 2000, 220, "s_street", "s_city", "s_state", "22222", "s001", "Computer Science");
    s1.show();

    cout << "------------ t1 ------------" << endl;
    Teacher t1("t_fname.", "t_lname", 13, 3, 2003, 330, "t_road", "t_city", "t_state", "33333", "t001", "Mathematics");
    t1.show();

    return 0;
}