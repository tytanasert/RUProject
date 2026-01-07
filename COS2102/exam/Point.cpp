#include <iostream>
// #include <string.h>
using namespace std;

class Point{
    private:
        double x;
        double y;
        string name1;
        char name2[20];
        static int countPoint;
    public:
        
        Point(){
            set(9999,9999,"nameDefualt_1", (char*)"nameDefualt_2");
            // show();
            countPoint++;
        }
        Point(int x){
            set(x,0,"", (char*)"");
            // show();
            countPoint++;
        }
        Point(int x, int y){
            set(x, y, "", (char*)"");
            // show();
            countPoint++;
        }
        Point(string n1){
            set(0, 0, n1, (char*)"");
            // show();
            countPoint++;
        }
        Point(char* n2){
            set(0, 0, "", n2);
            // show();
            countPoint++;
        }
        Point(string n1,  char* n2){
            set(0, 0, n1, n2);
            // show();
            countPoint++;
        }
        Point(int x, int y, string n1,  char* n2){
            set(x, y, n1, n2);
            // show();
            countPoint++;
        }

        ~Point(){
            cout << "name1 : " << name1 << " bye bye" << endl;
            cout << "name2 : " << name2 << " bye bye" << endl;
            countPoint--;
            cout << "countPointDeleted : " << countPoint << endl;
        }

        static int getCountPoint(){
            return countPoint;
        }
        
        void set(double x1, double y1, string n1, char *n2){
            x = x1;
            y = y1;
            name1 = n1;
            strcpy(name2, n2);
        }

        void setX(double x1){
            x = x1;
        }

        void setY(double y1){
            y = y1;
        }

        void setName1(string n){
            name1 = n;
        }
        void setName2(char *n){
            strcpy(name2, n);
        }

        double getX(){
            return x;
        }
        double getY(){
            return y;
        }
        string getName1(){
            return name1;
        }
        char* getName2(){
            return name2;
        }
        void show(void);
        //exam4
        int dot(Point &b){
            return (x * b.x) + (y * b.y);
        }

        Point midPoint(const Point &p1,const Point &p2){
            // Point mid;
            x = (p1.x + p2.x) / 2;
            y = (p1.y + p2.y) / 2;
            return *this;
        }
};



void Point::show(){
    cout << "x : " << x << endl;
    cout << "y : " << y << endl;
    cout << "name1 : " << name1 << endl;
    cout << "name2 : " << name2 << endl;
    cout << endl;
}
int Point::countPoint;
int main(){

    Point a;
    Point b;
    a.setName1("p1");
    a.setX(2);
    a.setY(3);

    b.setName1("p2");
    b.setX(4);
    b.setY(5);

    int dot = a.dot(b);
    Point d;
    Point c = d.midPoint(a,b);

    cout << "dot product of " << a.getName1() << " and " << b.getName1() << " is " << dot << endl;
    cout << "mid point of " << a.getName1() << " and " << b.getName1() << " is :" << endl;
    cout << "c.x : " << c.getX() << endl;
    cout << "c.y : " << c.getY() << endl;
    d.show();

    // cout << "countPoint : " << Point::getCountPoint() << endl;

    // cout << " Point P" << endl;
    // Point p;
    // p.setName1("pointP_name1");
    // p.setName2((char*)"pointP_name2");
    // cout << "countPoint : " << Point::getCountPoint() << endl;

    // cout << " Point P1" << endl;
    // Point p1(11);
    // cout << "countPoint : " << Point::getCountPoint() << endl;

    // cout << " Point P2" << endl;
    // Point p2(21,22);
    // cout << "countPoint : " << Point::getCountPoint() << endl;

    // cout << " Point P3" << endl;
    // Point p3("P3_1");
    // cout << "countPoint : " << Point::getCountPoint() << endl;

    // cout << " Point P4" << endl;
    // Point p4((char*)"P4_2");
    // cout << "countPoint : " << Point::getCountPoint() << endl;

    // cout << " Point P5" << endl;
    // Point p5("P5_1", (char*)"P5_2");
    // cout << "countPoint : " << Point::getCountPoint() << endl;

    // cout << " Point P6" << endl;
    // Point p6(61,62,"P6_1",(char*)"P6_2");
    // cout << "countPoint : " << Point::getCountPoint() << endl;

    // cout << "----- set -----" << endl;
    // p.set(2, 3,"mypointer", (char*)"pointer2");
    // cout << "getX : " << p.getX() << endl;
    // cout << "getY : " << p.getY() << endl;
    // cout << "getName1 : " << p.getName1() << endl;
    // cout << "getName2 : " << p.getName2() << endl;


    // p.setX(2);
    // p.setY(3);
    // p.setName1("mypoints11");
    // p.setName2((char*)"mypoint22");
    // cout << "getX : " << p.getX() << endl;
    // cout << "getY : " << p.getY() << endl;
    // cout << "getName1 : " << p.getName1() << endl;
    // cout << "getName2 : " << p.getName2() << endl;
    // cout << endl;

    // p.show();

    return 1;
}