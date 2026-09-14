# 📚 สรุปเนื้อหา COS2102 - Object-Oriented Programming (OOP) ด้วย C++

> สรุปจากสไลด์ประกอบการเรียน เน้นทำความเข้าใจและนำไปใช้ได้จริง พร้อมตัวอย่างโค้ด

---

## 📖 สารบัญ

1. [บทที่ 1 - Introduction to OOP](#บทที่-1---introduction-to-oop)
2. [บทที่ 2 - Class and Object](#บทที่-2---class-and-object)
3. [บทที่ 3 - Constructor and Destructor](#บทที่-3---constructor-and-destructor)
4. [บทที่ 4 - Composition (Has-A Relationship)](#บทที่-4---composition-has-a-relationship)
5. [บทที่ 5 - Operator Overloading](#บทที่-5---operator-overloading)
6. [บทที่ 6 - Inheritance (Is-A Relationship)](#บทที่-6---inheritance-is-a-relationship)
7. [บทที่ 7 - Polymorphism](#บทที่-7---polymorphism)
8. [บทที่ 8 - Abstract Class and Pure Virtual Function](#บทที่-8---abstract-class-and-pure-virtual-function)
9. [บทที่ 9 - Multiple Inheritance and Virtual Inheritance](#บทที่-9---multiple-inheritance-and-virtual-inheritance)
10. [บทที่ 10 - Template](#บทที่-10---template)
11. [บทที่ 11 - Copy Constructor and Deep Copy](#บทที่-11---copy-constructor-and-deep-copy)
12. [บทที่ 12 - Stream I/O and Operator << >>](#บทที่-12---stream-io-and-operator--)

---

## บทที่ 1 - Introduction to OOP

### ความหมาย
OOP (Object-Oriented Programming) คือแนวคิดการเขียนโปรแกรมที่มองทุกอย่างเป็น **วัตถุ (Object)** โดยแต่ละวัตถุจะมี **คุณสมบัติ (Attributes)** และ **พฤติกรรม (Methods)**

### หลักการสำคัญ 4 ประการ (Pillars of OOP)

| หลักการ | ความหมาย | ตัวอย่าง |
|---------|----------|---------|
| **Encapsulation** | การซ่อนข้อมูลภายในและเปิดเผยเฉพาะที่จำเป็น | ใช้ private/public |
| **Inheritance** | การสืบทอดคุณสมบัติจาก class แม่ | Student สืบทอดจาก Person |
| **Polymorphism** | การที่ method เดียวกันทำงานต่างกันขึ้นอยู่กับ object | virtual function |
| **Abstraction** | การซ่อนรายละเอียดและแสดงเฉพาะสิ่งที่จำเป็น | abstract class |

### ความแตกต่างระหว่าง OOP กับ Procedural Programming

```
Procedural: เน้นที่ "ทำอะไร" (function-based)
OOP:        เน้นที่ "ใครทำ" (object-based)
```

---

## บทที่ 2 - Class and Object

### ความหมาย
- **Class** = พิมพ์เขียว (Blueprint) ที่กำหนดว่า object จะมีอะไรบ้าง
- **Object** = ตัวจริงที่สร้างมาจาก class (Instance)

### Access Specifiers (ระดับการเข้าถึง)

| ระดับ | ภายใน Class | Class ลูก | ภายนอก |
|-------|:-----------:|:---------:|:------:|
| `private` | ✅ | ❌ | ❌ |
| `protected` | ✅ | ✅ | ❌ |
| `public` | ✅ | ✅ | ✅ |

### ตัวอย่างโค้ด

```cpp
#include <iostream>
using namespace std;

class Student {
private:          // ข้อมูลส่วนตัว - เข้าถึงจากภายนอกไม่ได้
    string name;
    int age;

public:           // ส่วนที่เปิดให้ภายนอกเข้าถึงได้
    // Setter - กำหนดค่า
    void setName(string n) { name = n; }
    void setAge(int a) { age = a; }

    // Getter - ดึงค่า
    string getName() { return name; }
    int getAge() { return age; }

    // Method
    void show() {
        cout << "Name: " << name << ", Age: " << age << endl;
    }
};

int main() {
    Student s;              // สร้าง object ชื่อ s จาก class Student
    s.setName("Somchai");   // กำหนดค่าผ่าน setter
    s.setAge(20);
    s.show();               // แสดงข้อมูล
    // s.name = "xxx";      // ❌ ERROR! name เป็น private
    return 0;
}
```

**Output:**
```
Name: Somchai, Age: 20
```

---

## บทที่ 3 - Constructor and Destructor

### ความหมาย
- **Constructor** = ฟังก์ชันพิเศษที่ถูกเรียกอัตโนมัติเมื่อสร้าง object (ชื่อเดียวกับ class)
- **Destructor** = ฟังก์ชันพิเศษที่ถูกเรียกอัตโนมัติเมื่อ object ถูกทำลาย (ชื่อเดียวกับ class แต่มี `~` นำหน้า)

### ประเภทของ Constructor

```
1. Default Constructor    → ไม่รับ parameter
2. Parameterized Constructor → รับ parameter
3. Copy Constructor       → สร้าง object ใหม่จาก object เดิม
```

### ตัวอย่างโค้ด

```cpp
#include <iostream>
using namespace std;

class Date {
private:
    int day, month, year;

public:
    // 1. Default Constructor
    Date() {
        day = 1;
        month = 1;
        year = 2000;
        cout << "Default Constructor ถูกเรียก" << endl;
    }

    // 2. Parameterized Constructor
    Date(int d, int m, int y) {
        day = d;
        month = m;
        year = y;
        cout << "Parameterized Constructor ถูกเรียก" << endl;
    }

    // 3. Copy Constructor
    Date(const Date &d) {
        day = d.day;
        month = d.month;
        year = d.year;
        cout << "Copy Constructor ถูกเรียก" << endl;
    }

    // Destructor
    ~Date() {
        cout << "Destructor ถูกเรียก: " << day << "/" << month << "/" << year << endl;
    }

    void show() {
        cout << day << "/" << month << "/" << year << endl;
    }
};

int main() {
    Date d1;              // เรียก Default Constructor
    Date d2(15, 3, 2025); // เรียก Parameterized Constructor
    Date d3(d2);          // เรียก Copy Constructor
    Date d4 = d2;         // เรียก Copy Constructor เช่นกัน!

    d1.show(); // 1/1/2000
    d2.show(); // 15/3/2025
    d3.show(); // 15/3/2025

    return 0;
    // Destructor จะถูกเรียกตามลำดับย้อนกลับ: d4 → d3 → d2 → d1
}
```

### ⚠️ สิ่งที่ต้องจำ
- Constructor **ไม่มี return type** (แม้แต่ void)
- Constructor สามารถ **overload** ได้ (มีหลายตัว)
- Destructor มีได้แค่ **1 ตัว** ต่อ class
- object ถูกทำลาย **ตามลำดับย้อนกลับ** (LIFO) กับที่สร้าง

---

## บทที่ 4 - Composition (Has-A Relationship)

### ความหมาย
Composition คือการที่ class หนึ่งมี object ของอีก class หนึ่งเป็น **member variable** เช่น "Person **มี** Date" และ "Person **มี** Address"

### ความแตกต่างกับ Inheritance
```
Composition (Has-A): Person มี Date      → Date เป็น member ของ Person
Inheritance (Is-A):  Student เป็น Person → Student สืบทอดจาก Person
```

### ตัวอย่างโค้ด

```cpp
#include <iostream>
using namespace std;

class Date {
private:
    int day, month, year;
public:
    Date() : day(1), month(1), year(2000) {}
    Date(int d, int m, int y) : day(d), month(m), year(y) {}

    void show() {
        cout << day << "/" << month << "/" << year;
    }
};

class Address {
private:
    int houseNo;
    string street, city;
public:
    Address() : houseNo(0), street(""), city("") {}
    Address(int h, string s, string c) : houseNo(h), street(s), city(c) {}

    void show() {
        cout << houseNo << " " << street << ", " << city;
    }
};

// Person "Has-A" Date และ "Has-A" Address
class Person {
private:
    string name;
    Date birthDate;       // Composition! Person มี Date
    Address address;      // Composition! Person มี Address

public:
    Person() : name("Unknown") {}

    Person(string n, int d, int m, int y, int hNum, string st, string c)
        : name(n), birthDate(d, m, y), address(hNum, st, c) {}

    void show() {
        cout << "Name: " << name << endl;
        cout << "Birth Date: "; birthDate.show(); cout << endl;
        cout << "Address: "; address.show(); cout << endl;
    }
};

int main() {
    Person p("Somchai", 15, 3, 1990, 123, "Rama IV", "Bangkok");
    p.show();
    return 0;
}
```

**Output:**
```
Name: Somchai
Birth Date: 15/3/1990
Address: 123 Rama IV, Bangkok
```

### ⚠️ ลำดับการสร้าง/ทำลาย
```
สร้าง: member objects ก่อน → แล้วค่อย container class
ทำลาย: container class ก่อน → แล้วค่อย member objects (ย้อนกลับ)
```

---

## บทที่ 5 - Operator Overloading

### ความหมาย
การกำหนดพฤติกรรมของ **operator** (+, -, =, <<, >>, ==, ฯลฯ) ให้ทำงานกับ **class ที่เราสร้างเอง**

### Operator ที่สำคัญในข้อสอบ

| Operator | ใช้ทำอะไร | ตำแหน่งที่เขียน |
|----------|----------|----------------|
| `=` | Assignment | member function |
| `<<` | แสดงผล (cout) | friend / global function |
| `>>` | รับข้อมูล (cin) | friend / global function |
| `+`, `-` | บวก ลบ | member หรือ global |
| `==`, `!=` | เปรียบเทียบ | member หรือ global |

### ตัวอย่าง: Overload operator= (Assignment Operator)

```cpp
class Person {
private:
    string name;
    string* status;  // dynamic memory

public:
    Person() : name(""), status(new string("")) {}
    Person(string n, string s) : name(n), status(new string(s)) {}

    ~Person() { delete status; }

    // Assignment Operator Overloading
    Person& operator=(const Person& p) {
        if (this == &p) return *this;  // ตรวจสอบ self-assignment
        name = p.name;
        *status = *p.status;          // deep copy ค่าใน pointer
        return *this;
    }
};
```

### ตัวอย่าง: Overload operator<< และ operator>>

```cpp
class Person {
private:
    string name;
    int age;
public:
    // ต้องมี helper function ให้ friend function เรียกใช้
    void showPerson(ostream& os) {
        os << "Name: " << name << " Age: " << age << endl;
    }
    void setPerson(istream& is) {
        cout << "Name: "; is >> name;
        cout << "Age: ";  is >> age;
    }
};

// operator<< เป็น global function
ostream& operator<<(ostream& os, Person& p) {
    p.showPerson(os);
    return os;
}

// operator>> เป็น global function
istream& operator>>(istream& is, Person& p) {
    p.setPerson(is);
    return is;
}

int main() {
    Person p;
    cin >> p;    // ใช้ operator>> ที่ overload ไว้
    cout << p;   // ใช้ operator<< ที่ overload ไว้
}
```

### ⚠️ สิ่งที่ต้องจำ
- `operator<<` และ `operator>>` **ต้องเป็น global function** (ไม่ใช่ member function) เพราะ operand ตัวแรกคือ `ostream`/`istream`
- ต้อง **return reference** กลับไป (`ostream&`, `istream&`) เพื่อให้ chain ได้ เช่น `cout << a << b`
- `operator=` ต้องตรวจ **self-assignment** (`if (this == &p) return *this;`)

---

## บทที่ 6 - Inheritance (Is-A Relationship)

### ความหมาย
Inheritance คือการที่ class ลูก (Derived Class) **สืบทอด** คุณสมบัติและพฤติกรรมจาก class แม่ (Base Class)

### ประเภทของ Inheritance

```
1. Single Inheritance:      A → B
2. Multilevel Inheritance:  A → B → C
3. Multiple Inheritance:    A, B → C (C สืบทอดจากทั้ง A และ B)
4. Hierarchical:            A → B, A → C
```

### Access Specifier ในการสืบทอด

| สืบทอดแบบ | public ของแม่ | protected ของแม่ | private ของแม่ |
|-----------|:---:|:---:|:---:|
| `public` | public | protected | ❌ไม่สืบทอด |
| `protected` | protected | protected | ❌ไม่สืบทอด |
| `private` | private | private | ❌ไม่สืบทอด |

### ตัวอย่างโค้ด: Single Inheritance

```cpp
#include <iostream>
using namespace std;

class Person {
protected:          // ให้ class ลูกเข้าถึงได้
    string name;
    int age;
public:
    Person() : name("Unknown"), age(0) {}
    Person(string n, int a) : name(n), age(a) {}

    void show() {
        cout << "Name: " << name << ", Age: " << age << endl;
    }
};

// Student "Is-A" Person (Student เป็น Person ชนิดหนึ่ง)
class Student : public Person {
private:
    string studentID;
    string major;
public:
    Student() : Person(), studentID(""), major("") {}

    Student(string n, int a, string sid, string m)
        : Person(n, a), studentID(sid), major(m) {}
    //  ^^^^^^^^^^^^^^^^ เรียก constructor ของ class แม่

    void show() {
        Person::show();  // เรียก show() ของ class แม่
        cout << "ID: " << studentID << ", Major: " << major << endl;
    }
};

int main() {
    Student s("Somchai", 20, "6501234", "CS");
    s.show();
    return 0;
}
```

**Output:**
```
Name: Somchai, Age: 20
ID: 6501234, Major: CS
```

### ⚠️ ลำดับ Constructor/Destructor ในการสืบทอด
```
สร้าง: Base Constructor → Derived Constructor
ทำลาย: Derived Destructor → Base Destructor (ย้อนกลับ)
```

---

## บทที่ 7 - Polymorphism

### ความหมาย
Polymorphism (หลายรูปแบบ) คือการที่ **method เดียวกัน** สามารถ **ทำงานต่างกัน** ได้ขึ้นอยู่กับ object ที่เรียกใช้

### 2 ประเภทของ Polymorphism

```
1. Compile-time (Static):   Function Overloading, Operator Overloading
2. Runtime (Dynamic):       Virtual Function + Pointer/Reference ของ Base class
```

### ตัวอย่าง: Function Overloading (Compile-time)

```cpp
class Calculator {
public:
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
    int add(int a, int b, int c) { return a + b + c; }
    // ชื่อฟังก์ชันเดียวกัน แต่รับ parameter ต่างกัน
};
```

### ตัวอย่าง: Virtual Function (Runtime Polymorphism) ⭐ สำคัญมาก

```cpp
#include <iostream>
using namespace std;

class Shape {
public:
    virtual double area() {    // ใส่ virtual !! 
        return 0;
    }
    virtual ~Shape() {}        // virtual destructor
};

class Rectangle : public Shape {
    int w, h;
public:
    Rectangle(int w, int h) : w(w), h(h) {}
    double area() override {   // override method ของ class แม่
        return w * h;
    }
};

class Circle : public Shape {
    int r;
public:
    Circle(int r) : r(r) {}
    double area() override {
        return 3.14 * r * r;
    }
};

int main() {
    // ใช้ pointer ของ Base class ชี้ไปที่ Derived class
    Shape* shapes[3];
    shapes[0] = new Rectangle(5, 10);
    shapes[1] = new Circle(7);
    shapes[2] = new Rectangle(3, 4);

    for (int i = 0; i < 3; i++) {
        // เรียก area() เดียวกัน แต่ทำงานต่างกันตาม object จริง!
        cout << "Area: " << shapes[i]->area() << endl;
    }

    for (int i = 0; i < 3; i++) delete shapes[i];
    return 0;
}
```

**Output:**
```
Area: 50
Area: 153.86
Area: 12
```

### ⚠️ สิ่งที่ต้องจำ
- ต้องใส่ `virtual` ที่ base class → ไม่งั้นจะเรียก method ของ base class เสมอ
- Polymorphism ทำงานผ่าน **pointer** หรือ **reference** เท่านั้น
- ควรทำ Destructor เป็น `virtual` เสมอ เมื่อมี virtual function

---

## บทที่ 8 - Abstract Class and Pure Virtual Function

### ความหมาย
- **Pure Virtual Function** = virtual function ที่ **ไม่มี body** ใช้ `= 0`
- **Abstract Class** = class ที่มี **pure virtual function อย่างน้อย 1 ตัว** → **สร้าง object ไม่ได้**

### ตัวอย่างโค้ด (จากไฟล์ 11Shape.cpp)

```cpp
#include <iostream>
using namespace std;

// Abstract Class - สร้าง object ไม่ได้!
class Shape {
public:
    virtual double area() = 0;   // Pure Virtual Function
    virtual ~Shape() {}
};

// ยังเป็น Abstract อยู่ เพราะยัง = 0
class TwoDimensional : public Shape {
public:
    double area() = 0;  // ยังไม่ implement
};

// ยังเป็น Abstract อยู่
class ThreeDimensional : public Shape {
public:
    double area() = 0;
    virtual double volume() = 0;  // เพิ่ม pure virtual function
};

// Concrete Class - implement ครบทุก pure virtual function แล้ว
class Rectangle : public TwoDimensional {
    int length1, length2;
public:
    void setLength(int l1, int l2) {
        length1 = l1;
        length2 = l2;
    }
    double area() {                  // implement area()
        return length1 * length2;
    }
    virtual ~Rectangle() {
        cout << "Rectangle bye bye" << endl;
    }
};

class Circle : public TwoDimensional {
    int radius;
public:
    void setRadius(int r) { radius = r; }
    double area() {
        return 3.14 * radius * radius;
    }
    virtual ~Circle() {
        cout << "Circle bye bye" << endl;
    }
};

class Cylinder : public ThreeDimensional {
    int radius, height;
public:
    void setRadius(int r) { radius = r; }
    void setHeight(int h) { height = h; }
    double area() {   // implement area()
        return (2 * 3.14 * radius * height) + (2 * 3.14 * radius * radius);
    }
    double volume() { // implement volume()
        return 3.14 * radius * radius * height;
    }
    virtual ~Cylinder() {
        cout << "Cylinder bye bye" << endl;
    }
};

int main() {
    // Shape s;           // ❌ ERROR! Abstract class สร้าง object ไม่ได้
    // TwoDimensional t;  // ❌ ERROR! ยังเป็น abstract อยู่

    Rectangle r;          // ✅ OK! Concrete class
    r.setLength(5, 10);
    cout << "Area: " << r.area() << endl;  // 50

    Cylinder cy;          // ✅ OK!
    cy.setRadius(5);
    cy.setHeight(10);
    cout << "Volume: " << cy.volume() << endl;  // 785

    return 0;
}
```

### ⚠️ สิ่งที่ต้องจำ
- Abstract class ใช้เป็น **"สัญญา"** ว่า class ลูกต้อง implement อะไรบ้าง
- ถ้า class ลูก **ไม่ implement** pure virtual function ทุกตัว → class ลูกก็จะเป็น abstract ด้วย
- Abstract class **ใช้เป็น pointer/reference ได้** เช่น `Shape* s = new Rectangle();`

---

## บทที่ 9 - Multiple Inheritance and Virtual Inheritance

### ความหมาย
- **Multiple Inheritance** = class สืบทอดจาก **หลาย class** พร้อมกัน
- **Diamond Problem** = ปัญหาที่เกิดเมื่อ class สืบทอดจาก 2 class ที่มี base class เดียวกัน → ทำให้มีข้อมูลซ้ำ 2 ชุด
- **Virtual Inheritance** = วิธีแก้ Diamond Problem

### Diamond Problem

```
        Person          ← base class
       /      \
   Student   Teacher    ← ทั้งคู่สืบทอดจาก Person
       \      /
  TeachingAssistant     ← สืบทอดจากทั้ง Student และ Teacher
```

ถ้าไม่ใช้ virtual inheritance → TeachingAssistant จะมีข้อมูล Person **2 ชุด!**

### ตัวอย่างโค้ด (จากไฟล์ Exam8.cpp)

```cpp
// ✅ ใช้ virtual public เพื่อแก้ Diamond Problem
class Student : virtual public Person {
    string studentID;
    string major;
    int* year;  // dynamic memory
public:
    Student() {
        studentID = "s_basic_id";
        major = "s_basic_major";
        year = new int(2569);
    }
    ~Student() {
        delete year;  // ต้อง delete เสมอ!
    }
    // ...
};

class Teacher : virtual public Person {
    string teacherID;
    string subject;
    char* position;  // dynamic memory (char array)
public:
    Teacher() {
        teacherID = "t_basic_id";
        subject = "t_basic_subject";
        position = new char[20];
        strcpy(position, "dr");
    }
    ~Teacher() {
        delete[] position;  // ใช้ delete[] สำหรับ array!
    }
    // ...
};

// Multiple Inheritance + Virtual Inheritance
class TeachingAssistant : public Student, public Teacher {
    string taID;
    double* salary;
public:
    TeachingAssistant()
        : Person(),     // ต้องเรียก Person constructor ตรงๆ!
          Student(),
          Teacher() {
        salary = new double(1000);
    }

    // Full parameterized constructor
    TeachingAssistant(string fn, string ln, /*...params...*/)
        : Person(fn, ln, /*...*/)    // ← สำคัญ! ต้องเรียก Person ตรงจาก TA
        , Student(/*...*/)
        , Teacher(/*...*/) {
        // ...
    }

    ~TeachingAssistant() {
        delete salary;
    }
};
```

### ⚠️ กฎสำคัญของ Virtual Inheritance
1. class ที่สืบทอดต้องใช้ `virtual public` → `class Student : virtual public Person`
2. class ล่างสุด (TeachingAssistant) **ต้องเรียก constructor ของ base class ที่ถูก share (Person) โดยตรง**
3. ลำดับการสร้าง: **Virtual base class ก่อนเสมอ** → Person → Student → Teacher → TA

---

## บทที่ 10 - Template

### ความหมาย
Template คือการเขียนโค้ดที่ **ทำงานได้กับหลาย type** โดยไม่ต้องเขียนซ้ำ

### Function Template

```cpp
// แทนที่จะเขียน area() แยกสำหรับแต่ละ type
// เขียน template function เดียว ใช้ได้กับทุก type!
template <typename T>
double area(T& t) {
    return t.area();
}

template <typename T>
double volume(T& t) {
    return t.volume();
}

int main() {
    Rectangle r;
    r.setLength(5, 10);
    cout << area(r) << endl;     // ใช้ template กับ Rectangle

    Circle c;
    c.setRadius(5);
    cout << area(c) << endl;     // ใช้ template เดียวกันกับ Circle

    Cylinder cy;
    cy.setRadius(5);
    cy.setHeight(10);
    cout << area(cy) << endl;    // ใช้ template เดียวกันกับ Cylinder
    cout << volume(cy) << endl;  // ใช้ volume template
}
```

### Class Template

```cpp
template <typename T>
class Box {
    T value;
public:
    Box(T v) : value(v) {}
    T getValue() { return value; }
    void show() { cout << "Value: " << value << endl; }
};

int main() {
    Box<int> b1(42);          // Box ที่เก็บ int
    Box<string> b2("Hello");  // Box ที่เก็บ string
    Box<double> b3(3.14);     // Box ที่เก็บ double

    b1.show();  // Value: 42
    b2.show();  // Value: Hello
    b3.show();  // Value: 3.14
}
```

---

## บทที่ 11 - Copy Constructor and Deep Copy

### ความหมาย
- **Shallow Copy** (ค่าเริ่มต้น) = คัดลอก **ค่า pointer** → 2 object ชี้ไปที่ memory เดียวกัน 💀
- **Deep Copy** = คัดลอก **ข้อมูลจริง** → แต่ละ object มี memory ของตัวเอง ✅

### ปัญหาของ Shallow Copy

```cpp
class Problem {
    int* data;
public:
    Problem(int val) { data = new int(val); }
    ~Problem() { delete data; }  // ทำลาย data

    // ❌ ไม่เขียน copy constructor → ใช้ default (shallow copy)
};

int main() {
    Problem a(10);
    Problem b = a;  // Shallow copy! b.data ชี้ที่เดียวกับ a.data

    // เมื่อ b ถูกทำลาย → delete data
    // เมื่อ a ถูกทำลาย → delete data อีกครั้ง → 💥 CRASH! (double free)
}
```

### วิธีแก้: Deep Copy

```cpp
class Person {
    string name;
    string* status;  // dynamic memory

public:
    Person(string n, string s) : name(n), status(new string(s)) {}

    // ✅ Deep Copy Constructor
    Person(const Person& p) {
        name = p.name;
        status = new string(*p.status);  // สร้าง memory ใหม่ + คัดลอกค่า
    }

    // ✅ Deep Copy Assignment Operator
    Person& operator=(const Person& p) {
        if (this == &p) return *this;  // ป้องกัน self-assignment
        name = p.name;
        *status = *p.status;           // คัดลอกค่า ไม่ใช่ pointer
        return *this;
    }

    ~Person() {
        delete status;  // ปลอดภัย เพราะแต่ละ object มี memory ของตัวเอง
    }
};
```

### Rule of Three ⭐
> ถ้า class มี dynamic memory (new/delete) → **ต้องเขียนเอง** ทั้ง 3 อย่าง:
> 1. **Destructor**
> 2. **Copy Constructor**
> 3. **Assignment Operator (operator=)**

### Deep Copy ใน Inheritance (จาก Exam8.cpp)

```cpp
class Student : virtual public Person {
    string studentID;
    string major;
    int* year;      // dynamic memory!

public:
    // Copy Constructor - เรียก copy constructor ของ Person ด้วย!
    Student(const Student& p) : Person(p) {
        studentID = p.studentID;
        major = p.major;
        year = new int(*p.year);  // Deep copy!
    }

    // Assignment Operator
    Student& operator=(Student& p) {
        if (this == &p) return *this;
        Person::operator=(p);     // เรียก operator= ของ class แม่
        studentID = p.studentID;
        major = p.major;
        *year = *p.year;          // Deep copy ค่า
        return *this;
    }

    ~Student() {
        delete year;
    }
};
```

### Deep Copy สำหรับ char* (Teacher class)

```cpp
class Teacher : virtual public Person {
    char* position;  // dynamic char array

public:
    // Copy Constructor
    Teacher(const Teacher& t) : Person(t) {
        position = new char[strlen(t.position) + 1];  // จอง memory ใหม่
        strcpy(position, t.position);                  // คัดลอกข้อมูล
    }

    // Assignment Operator
    Teacher& operator=(const Teacher& t) {
        if (this == &t) return *this;
        Person::operator=(t);
        delete[] position;                             // ลบของเดิม
        position = new char[strlen(t.position) + 1];   // จอง memory ใหม่
        strcpy(position, t.position);                  // คัดลอกข้อมูล
        return *this;
    }

    ~Teacher() {
        delete[] position;
    }
};
```

---

## บทที่ 12 - Stream I/O and Operator << >>

### ความหมาย
การ overload operator `<<` (insertion) และ `>>` (extraction) เพื่อให้ใช้ `cout` และ `cin` กับ class ที่เราสร้างเองได้

### รูปแบบมาตรฐาน

```cpp
class Person {
    string name;
    int age;
public:
    // Helper function สำหรับ output
    void showPerson(ostream& os) {
        os << "Name: " << name << ", Age: " << age;
    }

    // Helper function สำหรับ input
    void setPerson(istream& is) {
        cout << "Enter name: "; is >> name;
        cout << "Enter age: ";  is >> age;
    }
};

// ต้องเป็น global function (ไม่ใช่ member ของ class)
ostream& operator<<(ostream& os, Person& p) {
    p.showPerson(os);
    return os;      // return os เพื่อให้ chain ได้
}

istream& operator>>(istream& is, Person& p) {
    p.setPerson(is);
    return is;      // return is เพื่อให้ chain ได้
}
```

### การ Chain ใช้งาน
```cpp
int main() {
    Person p1, p2;
    cin >> p1 >> p2;         // chain input
    cout << p1 << endl << p2; // chain output
}
```

### ในกรณี Inheritance

```cpp
class Student : public Person {
    string id;
public:
    void showStudent(ostream& os) {
        Person::showPerson(os);    // เรียกของ class แม่ก่อน
        os << ", ID: " << id;
    }

    void setStudent(istream& is) {
        Person::setPerson(is);     // รับข้อมูล class แม่ก่อน
        cout << "Enter ID: "; is >> id;
    }
};

ostream& operator<<(ostream& os, Student& s) {
    s.showStudent(os);
    return os;
}

istream& operator>>(istream& is, Student& s) {
    s.setStudent(is);
    return is;
}
```

---

## 🎯 สรุปสูตรท่องจำก่อนสอบ

### 1. ลำดับ Constructor/Destructor
```
สร้าง: Base → Derived (จากบนลงล่าง)
ทำลาย: Derived → Base (จากล่างขึ้นบน)

Virtual Inheritance: Virtual Base สร้างก่อนเสมอ
Composition: Member สร้างก่อน Container
```

### 2. Deep Copy Checklist
```
มี new → ต้องมี delete
มี delete → ต้องเขียน Copy Constructor + operator=
Copy Constructor → สร้าง memory ใหม่ (new) แล้วคัดลอกค่า
operator= → ตรวจ self-assignment + คัดลอกค่า (ไม่ต้อง new ใหม่ถ้าใช้ *ptr = *src)
```

### 3. Virtual Function
```
virtual → ให้ polymorphism ทำงาน (runtime binding)
= 0   → pure virtual function → abstract class → สร้าง object ไม่ได้
virtual destructor → ต้องใส่เมื่อมี virtual function
```

### 4. Operator Overloading
```
operator= → member function, return *this
operator<< / >> → global function, return ostream&/istream&
```

---

> 💡 **เคล็ดลับสอบ**: ข้อสอบมักออกให้เขียน class hierarchy ที่มี composition + inheritance + virtual inheritance + operator overloading + deep copy รวมกัน ให้ฝึกเขียนจากไฟล์ Exam8.cpp เป็นหลัก!

