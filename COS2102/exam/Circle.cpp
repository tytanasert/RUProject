#include<iostream>
using namespace std;

class Circle;
class Point{
    private:
        double x;
        double y;
        string name1;
        char name2[20];
    public:
        
        Point(){
            set(9999,9999,"nameDefualt_1", (char*)"nameDefualt_2");
        }
        Point(int x){
            set(x,0,"", (char*)"");
        }
        Point(int x, int y){
            set(x, y, "", (char*)"");
        }
        Point(string n1){
            set(0, 0, n1, (char*)"");
        }
        Point(char* n2){
            set(0, 0, "", n2);
        }
        Point(string n1,  char* n2){
            set(0, 0, n1, n2);
        }
        Point(int x, int y, string n1,  char* n2){
            set(x, y, n1, n2);
        }

        ~Point(){
            // cout << "point name1 : " << name1 << " bye bye" << endl;
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

        Point static midPoint(const Point &p1,const Point &p2){
            Point mid;
            mid.setX((p1.x + p2.x) / 2);
            mid.setY((p1.y + p2.y) / 2);
            mid.setName1("mid of " + p1.name1 + " and " + p2.name1);
            return mid;
        }

        friend bool inCircle(Circle &c1, Point &p1);
};

void Point::show(){
    cout << "x : " << x << endl;
    cout << "y : " << y << endl;
    cout << "name1 : " << name1 << endl;
    cout << "name2 : " << name2 << endl;
    cout << endl;
}

class Circle{
    double rad;
    Point p;
    public:
        Circle(){ rad=0.0; p = Point(); }
        Circle(int r){ rad = r; p = Point(); }
        Circle(Point point){ rad = 0.0; p = point; }
        Circle(int r, Point point){ rad = r; p = point; }

        ~Circle(){
            cout << "goodbye Circle "<< endl;
            cout << "rad : " << rad << endl;
            cout << "Point  x :" << p.getX() << "  , y :" << p.getY() << endl;
        }

        //set get show
        double getRad(){
            return rad;
        }       

        Point getP(){
            return p;
        }

        void setRad(double r){
            rad = r;
        }
        void setP(Point point){
            p = point;
        } 

        friend bool inCircle(Circle &c1, Point &p1){
            double d = sqrt((p1.x - c1.p.x)*(p1.x - c1.p.x) + (p1.y - c1.p.y)*(p1.y - c1.p.y));
            if(d <= c1.rad){
                return true;
            }else{
                return false;
            }
        }

};

// bool inCircle(Circle &c1, Point &p1){
//     double d = sqrt((p1.x - c1.getP().x)*(p1.x - c1.getP().x) + (p1.y - c1.getP().y)*(p1.y - c1.getP().y));
//     if(d <= c1.getRad()){
//         return true;
//     }else{
//         return false;
//     }
// }
    
int main(){
    Point p1(2.0,3.0);
    Circle c1(5.0,p1);

    Point p2(1.0,3.0);
    cout << "answer: " << inCircle(c1, p2) << endl;

    p2.setX(6.0);
    p2.setY(8.0);
    
    cout << "answer: " << inCircle(c1, p2) << endl;
    return 0;
}