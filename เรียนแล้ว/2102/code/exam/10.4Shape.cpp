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
    virtual ~ThreeDimensional(){
        cout << "ThreeDimensional bye bye" << endl;
    }
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

template <class T>
double area(T &t){
    return t.area();
}

template <class T>
double volume(T t){
    return t.volume();
}


int main(){

    Rectangle r;
    r.setLength(5, 10);
    cout << "Area of Rectangle: " << area(r) << endl;

//     Triangle t;
//     t.setLength(5);
//     t.setHeight(10);
//     cout << "Area of Triangle: " << area(t) << endl;

//     Circle c;
//     c.setRadius(5);
//     cout << "Area of Circle: " << area(c) << endl;

//     Cylinder cy;
//     cy.setRadius(5);
//     cy.setHeight(10);
//     cout << "Surface Area of Cylinder: " << area(cy) << endl;
//     cout << "Volume of Cylinder: " << volume(cy) << endl;

//     Sphere sp;
//     sp.setRadius(5);
//     cout << "Surface Area of Sphere: " << area(sp) << endl;
//     cout << "Volume of Sphere: " << volume(sp) << endl;

//     cout << " -----------  I finish 11.1 and 11.2 ------------" << endl << endl;
//     TwoDimensional *two[3];
//     Rectangle rr;
//     Triangle tt;
//     Circle cc;

//     rr.setLength(5, 10);
//     tt.setLength(5);
//     tt.setHeight(10);
//     cc.setRadius(5);

//     two[0] = &rr;
//     two[1] = &tt;
//     two[2] = &cc;
    


//     for(int i=0; i<3; i++){
//         cout << "area of twodimension " << i+1 << " : " << two[i]->area() << endl;
//     }

//     ThreeDimensional *three[3];

//     three[0] = new Cylinder();
//     ((Cylinder*)three[0])->setRadius(5);
//     ((Cylinder*)three[0])->setHeight(100);
//     three[1] = new Sphere();
//     ((Sphere*)three[1])->setRadius(5);

//     for(int i=0; i<3; i++){
//         cout << "volume of threedimension " << i+1 << " : " << three[i]->volume() << endl;
//     }
// for(int i=0; i<3; i++){
//         delete three[i];
//     }
    


    return 0;
}