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
        void inDate(istream &is){
            cout << "day : " ; is >> day; cout <<endl;
            cout << "month" ; is >> month; cout <<endl;
            cout << "year" ; is >> year; cout <<endl;
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

        void inAddress(istream &is){
            cout << "houseNo : " ; is >> houseNo; cout <<endl;
            cout << "street" ; is >> street; cout <<endl;
            cout << "city" ; is >> city; cout <<endl;
            cout << "state" ; is >> state; cout <<endl;
            cout << "zip" ; is >> zip; cout <<endl;
        }
};

class Person{
    private:
        string fname;
        string lname;
        Date date;
        Address address;
        string* status;
    public:
        Person(){
            cout << "person Cont" << endl;
            fname = "p_basic";
            lname = "p_basicl";
            status = new string("");
        }
        Person(string fn, string ln, string &s){
            cout << "person Cont fn ln" << endl;
            fname = fn;
            lname = ln;
            status = new string(s);
        }
        Person(string fn, string ln, int d, int m, int y, int hNum, string st, string c, string s, string zip, string &sta){
            cout << "person Cont fn ln d a" << endl;
            fname = fn;
            lname = ln;
            date.setDate(d,m,y);
            address.setAddress(hNum,st,c,s,zip);
            status = new string(sta);
        }
        Person(string fn, string ln, Date &d, Address &a, string &sta){
            cout << "person Cont fn ln d a" << endl;
            fname = fn;
            lname = ln;
            date = d;
            address = a;
            status = new string(sta);
        }
        ~Person(){
            delete status;
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

        void setStatus(string &sta){ *status = sta;}

        string getFname(){ return fname;}
        string getLname(){ return lname;}
        Date getDate(){ return date;}
        Address getAddress(){ return address;}
        string getStatus(){ return *status;}

        void show(){
            cout << "class Person" << endl;
            cout << "First Name : " << getFname() << endl;
            cout << "Last Name : " << getLname() << endl;
            cout << "status : " << *status << endl;
            getDate().show();
            getAddress().show();
            cout << endl;
        }

        Person(const Person &p){
            fname = p.fname;
            lname = p.lname;
            date = p.date;
            address = p.address;
            status = new string(*p.status);
        }

        Person& operator=(Person &p){
            if(this == &p){return *this;}
            fname = p.fname;
            lname = p.lname;
            date = p.date;
            address = p.address;
            *status = *p.status;
            return *this;
        }

        void showPerson(ostream &os){
            os << "fname : " << fname << " lname : " << lname << endl;
            os << "status : " << *status << endl;
            address.show();
            date.show(); 
        }

        void setPerson(istream &is){
            cout << "fname : "; is >> fname;
            cout << " lname : "; is >> lname;
            address.inAddress(is);
            date.inDate(is);

            cout << " status : "; is >> *status;
        }


};

ostream& operator<<(ostream& os,Person &t){
    t.showPerson(os);
    return os;
}

istream& operator>>(istream& is, Person &t){
    t.setPerson(is);
    return is;
}

class Student:virtual public Person{
    string studentID;
    string major;
    int *year;
    public:
        Student(){
            cout << "student Cont" << endl;
            studentID = "s_basic_id";
            major = "s_basic_major";
            year = new int(2569);
        }
        Student(string fn, string ln, int d, int m, int y, int hNum, string st, string c, string s, string zip, string sid, string maj, string sta, int &yea)
        :Person(fn, ln, d, m, y, hNum, st, c, s, zip, sta){
            cout << "student Cont fn ln d m y ..." << endl;
            studentID = sid;
            major = maj;
            year = new int(yea);
        }
        Student(string sid, string maj, int &yea){
            studentID = sid;
            major = maj;
            year = new int(yea);
        }
        ~Student(){
            delete year;
            cout << "student bye" << endl;
        }

        void setStudentId(string sid){ studentID = sid;}
        string getStudentId(){ return studentID;}

        void setMajor(string maj){ major = maj;}
        string getMajor(){ return major;}

        void setYear(int &yea){ *year = yea;}
        int* getYear(){ return year;}

        void show(){
            Person::show();

            cout << "Student ID : " << studentID << endl;
            cout << "Major : " << major << endl;
            cout << "year : " << *year << endl << endl;
        }

        Student(Student &p):Person(p){
            studentID = p.studentID;
            major = p.major;
            year = new int(*p.year);
        }

        Student& operator=(Student &p){
            if(this == &p){return *this;}
            Person::operator=(p);

            studentID = p.studentID;
            major = p.major;

            *year = *p.year;
            return *this;
        }

        void showStudent(ostream &os){
            Person::show();
            os << "studentID : " << studentID << " major : " << major << endl;
            os << "year : " << *year << endl;            
        }

        void setStudent(istream &is){
            Person::setPerson(is);
            cout << "studentID : "; is >> studentID;
            cout << endl;
            cout << " major : "; is >> major;
            cout << endl;
            cout << "year : "; is >> *year;
        }
};

ostream& operator<<(ostream& os,Student &t){
    t.showStudent(os);
    return os;
}

istream& operator>>(istream& is, Student &t){
    t.setStudent(is);
    return is;
}

class Teacher:virtual public Person{
    string teacherID;
    string subject;
    char* position;
    public:
        Teacher(){
            cout << "teacher Cont" << endl;
            teacherID = "t_basic_id";
            subject = "t_basic_subject";
            position = new char[20];
            strcpy(position,"dr");
        }
        Teacher(string fn, string ln, int d, int m, int y, int hNum, string st, string c, string s, string zip, string tid, string sub, const char pos[], string &sta)
        :Person(fn, ln, d, m, y, hNum, st, c, s, zip, sta){
            cout << "teacher Cont fn ln d m y ..." << endl;
            teacherID = tid;
            subject = sub;
            position = new char[strlen(pos)+1];
            strcpy(position,pos);
        }
        Teacher(string tid, string sub,char* pos){
            cout << "teacher Cont fn ln d m y ..." << endl;
            teacherID = tid;
            subject = sub;
            position = new char[strlen(pos)+1];
            strcpy(position,pos);
        }
        ~Teacher(){
            delete position;
            cout << "teacher bye" << endl;
        }

        void setTeacherId(string tid){ teacherID = tid;}
        void setSubject(string sub){ subject = sub;}
        void setPosition(char* pos){ 
            delete position;
            position = new char[strlen(pos)+1];
            strcpy(position,pos);
        }

        string getTeacherId(){ return teacherID;}
        string getSubject(){ return subject;}
        char* getPosition(){ return position;}

        void show(){
            Person::show();

            cout << "Teacher ID : " << teacherID << endl;
            cout << "Subject : " << subject << endl;
            cout << "Position : " << *position << endl << endl;
        }

        Teacher(Teacher &t):Person(t){
            teacherID = t.teacherID;
            subject = t.subject;
            position = new char[strlen(t.position)+1];
            strcpy(position,t.position);
        }

        Teacher& operator=(Teacher &t){
            if(this == &t){return *this;}
            Person::operator=(t);

            teacherID = t.teacherID;
            subject = t.subject;
            delete position;
            position = new char[strlen(t.position)+1];
            strcpy(position,t.position);

            return *this;
        }

        void showTeacher(ostream &os){
            Person::showPerson(os);
            os << "Teacher Id : " << teacherID << endl;
            os << "subject  : " << subject << endl;
            os << "position : " << position << endl<< endl;
        }

        void setTeacher(istream &is){
            Person::setPerson(is);
            cout << "Teacher Id : " << endl;    is >> teacherID;
            cout << "subject : " << endl; is >> subject;
            delete position;
            position = new char[20];
            cout << "position : " << endl; is >> position;
        }
};

ostream& operator<<(ostream& os,Teacher &t){
    t.showTeacher(os);
    return os;
}

istream& operator>>(istream& is, Teacher &t){
    t.setTeacher(is);
    return is;
}

class TeachingAssistant:public Student, public Teacher{
    private:
        string taID;
        double* salary;
    public:
        TeachingAssistant(){
            cout << "TA Cont" << endl << endl;
            salary = new double(1000);
        }
        TeachingAssistant(string fn, string ln, int d, int m, int y, int hNum, string st, string c, string s, string zip, string sta,
                          string sid, string maj, int yea,
                          string tid, string sub, char* pos,
                          string taId, double &sal)
                          :Person(fn, ln, d, m, y, hNum, st, c, s, zip, sta)
                          ,Student(fn, ln, d, m, y, hNum, st, c, s, zip, sid, maj, sta, yea)
                          ,Teacher(tid, sub, pos){
            setTaId(taId);
            salary = new double(sal);
        }
        ~TeachingAssistant(){
            delete salary;
            cout << "TA bye" << endl;
        }

        void setTaId(string taid){ taID = taid;}
        string getTaId(){ return taID;}

        void setSalary(double &sal){ *salary = sal;};
        double getSalary(){return *salary;}

        void showTa(){
            
            cout << "---- Person part ----" << endl;
            Person::show();
            cout << "---- Student part ----" << endl;
            Student::show();
            cout << "---- Teacher part ----" << endl;
            Teacher::show();

            cout << "class TeachingAssistant" << endl;
            cout << "TA ID : " << taID << endl << endl;
            cout << "Salary : " << salary << endl;
        }

        TeachingAssistant(TeachingAssistant &ta):Person(ta),Student(ta),Teacher(ta){
            taID = ta.taID;
            salary = new double(*ta.salary);
        }

        TeachingAssistant& operator=(TeachingAssistant &ta){
            if(this == &ta){return *this;}

            Student::operator=(ta);
            // Teacher::operator=(ta);


            taID = ta.taID;
            *salary = *ta.salary;

            return *this;
        }

        void showTeachingAssistant(ostream &os){
            Person::showPerson(os);
            Student::showStudent(os);
            Teacher::showTeacher(os);

            os << "Ta Id : " << taID << endl;
            os << "salary : " << salary << endl<< endl;
        }

        void setTeachingAssistant(istream &is){
            Person::setPerson(is);
            Student::setStudent(is);
            Teacher::setTeacher(is);
            cout << "Ta Id : " << endl;    is >> taID;
            delete salary;
            salary = new double();
            cout << "salary : " << endl; is >> *salary;
        }

};

ostream& operator<<(ostream& os,TeachingAssistant &ta){
    ta.showTeachingAssistant(os);
    return os;
}

istream& operator>>(istream& is, TeachingAssistant &ta){
    ta.setTeachingAssistant(is);
    return is;
}


int main(){

    Person p1;
    cin >> p1;
    cout << p1;
    Person p2(p1);
    p1 = p2;

    Student s1;
    cin >> s1;
    cout << s1;
    Student s2(s1);
    s1 = s2;

    Teacher t1;
    cin >> t1;
    cout << t1;
    Teacher t2(t1);
    t1 = t2;

    TeachingAssistant ta;
    cin >> ta;
    cout << ta;
    TeachingAssistant ta2(ta);
    ta = ta2;
    

    // Person p;
    // p.show();

    // Student s;
    // s.show();

    // Teacher t;
    // t.show();

    // cout << "------------ p1 ------------" << endl;
    // Person p1("p_fname", "p_lname", 11, 10, 1990, 110, "p_street", "p_city", "p_state", "11111");
    // p1.show();

    // cout << "------------ s1 ------------" << endl;
    // Student s1("s_fname", "s_lname", 20, 2, 2000, 220, "s_street", "s_city", "s_state", "22222", "s001", "Computer Science");
    // s1.show();

    // cout << "------------ t1 ------------" << endl;
    // Teacher t1("t_fname.", "t_lname", 13, 3, 2003, 330, "t_road", "t_city", "t_state", "33333", "t001", "Mathematics");
    // t1.show();

    return 0;
}