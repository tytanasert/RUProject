#include<iostream>
using namespace std;

class Rectangle {
    private:
        int width;
        int height;
        static int countRectangle;
    public:
        Rectangle() {
            set(0,0);
            countRectangle++;
        }
        Rectangle(int w, int h) {
            set(w,h);
            countRectangle++;
        }
        ~Rectangle() {
            cout << "good bye " << endl;
            cout << "width : " << width << ", height : " << height << endl;
            countRectangle--;
            cout << "countRectangleDelete : " << countRectangle << endl;
        }

        static int getCountRectangle() {
            return countRectangle;
        }

        void setWidth(int w) {
            width = w;
        }
        void setHeight(int h) {
            height = h;
        }
        void set(int w, int h) {
            width = w;
            height = h;
        }

        int getWidth() {
            return width;
        }
        int getHeight() {
            return height;
        }

        int area() {
            return width * height;
        }
        int around() {
            return 2 * (width + height);
        }
        
        void show(void);
};

void Rectangle::show() {
            cout << "width: " << width << ", height: " << height << endl;
            cout << "area: " << area() << ", around: " << around() << endl;
}

int Rectangle::countRectangle;

int main() {
    cout << "countRectangle : " << Rectangle::getCountRectangle() << endl;
    Rectangle r1;
    r1.show();
    cout << "countRectangle : " << Rectangle::getCountRectangle() << endl;

    Rectangle r2(5, 10);
    
    r2.show();
    r2.setWidth(7);
    r2.setHeight(14);
    cout << "r2.width : " << r2.getWidth() << endl;
    cout << "r2.height : " << r2.getHeight() << endl;

    r1.set(3, 4);
    r1.show();
    cout << "r1.around : " << r1.around() << endl;
    cout << "r1.area : " << r1.area() << endl;

    cout << "countRectangle : " << Rectangle::getCountRectangle() << endl;
    return 0;
}