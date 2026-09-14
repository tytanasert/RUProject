#include<iostream>
using namespace std;

class Shape{
    public :
    virtual double area() = 0;
};

class TwoDimensional:public Shape{
    public :

    double area() = 0;
};

class ThreeDimensional:public Shape{
    public :
    double area() = 0;
    virtual double volume() = 0;
};

class Rectangle:public TwoDimensional{
    int length1;
    int length2;
    public :
    void setLength(int l1, int l2){
        length1 = l1;
        length2 = l2;
    }
    double getLenght1(){return length1;}
    double getLenght2(){return length2;}
    double area(){
        return length1 * length2;
    };

    virtual ~Rectangle(){
        cout << "Rectangle bye bye" << endl;
    }
};
class Triangle:public TwoDimensional{
    int length;
    int height;
    public :
    void setLength(int l){
        length = l;
    }
    void setHeight(int h){
        height = h;
    }
    double getLength(){return length;}
    double getHeight(){return height;}

    double area(){
        return 0.5 * length * height;
    };
    virtual ~Triangle(){
        cout << "Triangle bye bye" << endl;
    }
};
class Circle:public TwoDimensional{
    int radius;
    public :
    void setRadius(int r){
        radius = r;
    }
    double getRadius(){return radius;}
    double area(){
        return 3.14 * radius * radius;
    };
    virtual ~Circle(){
        cout << "Circle bye bye" << endl;
    }
};
class Cylinder:public ThreeDimensional{
    int radius;
    int height;
    public :
    void setRadius(int r){
        radius = r;
    }
    void setHeight(int h){
        height = h;
    }
    double getRadius(){return radius;}
    double getHeight(){return height;}
    double area(){
        return (2 * 3.14 * radius * height) + (2 * 3.14 * radius * radius);
    };
    double volume(){
        return 3.14 * radius * radius * height;
    };

    virtual ~Cylinder(){
        cout << "Cylinder bye bye" << endl;
    }
};

class Sphere:public ThreeDimensional{
    int radius;
    public :
    void setRadius(int r){
        radius = r;
    }
    double getRadius(){return radius;}
    double area(){
        return 4 * 3.14 * radius * radius;
    };
    double volume(){
        return (4/3) * 3.14 * radius * radius * radius;
    };

    virtual ~Sphere(){
        cout << "Sphere bye bye" << endl;
    }
};

template <typename T>
double area(T &t){
    return t.area();
}

template <typename T>
double volume(T &t){
    return t.volume();
}


int main(){

    Rectangle r;
    r.setLength(5, 10);
    cout << "Area of Rectangle: " << area(r) << endl;

    Triangle t;
    t.setLength(5);
    t.setHeight(10);
    cout << "Area of Triangle: " << area(t) << endl;

    Circle c;
    c.setRadius(5);
    cout << "Area of Circle: " << area(c) << endl;

    Cylinder cy;
    cy.setRadius(5);
    cy.setHeight(10);
    cout << "Surface Area of Cylinder: " << area(cy) << endl;
    cout << "Volume of Cylinder: " << volume(cy) << endl;

    Sphere s;
    s.setRadius(5);
    cout << "Surface Area of Sphere: " << area(s) << endl;
    cout << "Volume of Sphere: " << volume(s) << endl;

    return 0;
}