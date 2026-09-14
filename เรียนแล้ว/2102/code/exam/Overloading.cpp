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


        ////////////
        Rectangle operator++(){
            height++;
            return *this;
        }

        Rectangle operator++(int){
            width++;
            return *this;
        }

        friend Rectangle operator--(Rectangle &x){
            if(x.height > 1){
                x.height--;
            }
            return x;
        }

        friend Rectangle operator--(Rectangle &x, int){
            if(x.width > 1){
                x.width--;
            }
            return x;
        }

        string operator<(Rectangle &i){
            if(area() < i.area()){
                return "less than";
            }else{
                return "more than";
            }
        }

        string operator<=(Rectangle &i){
            if(area() <= i.area()){
                return "less or equal than";
            }else{
                return "more than";
            }
        }

        string operator>(Rectangle &i){
            if(area() > i.area()){
                return "more than";
            }else{
                return "less than";
            }
        }

        string operator>=(Rectangle &i){
            if(area() >= i.area()){
                return "more or equal than";
            }else{
                return "less than";
            }
        }

        string operator!=(Rectangle &i){
            if(area() != i.area()){
                return "not equal";
            }else{
                return "equal";
            }
        }

        int operator[](int i){
            height = height + i;
            return height;
        }

        int operator()(){
            width = width + width;
            return width;
        }

        int operator()(int i){
            width = width + i;
            return width;
        }

        int operator()(int i, int j){
            width = width + (i*j);
            return width;
        }

        operator int(){
            return width * height;
        }
        
        Rectangle(int num){
            width = num;
            height = 1;
        }

    
};

void Rectangle::show() {
            cout << "width: " << width << ", height: " << height << endl;
            cout << "area: " << area() << ", around: " << around() << endl;
}

int Rectangle::countRectangle;

int main(){
    
    Rectangle obj = 1;
    Rectangle objReT1 = ++obj;
    cout << "obj.Height ++ pre: " << objReT1.getHeight() << endl;
    cout << "obj.Height ++ pre: " << obj.getHeight() << endl;
    Rectangle objReT2 = obj++;
    cout << "obj.getWidth ++ post : " << objReT2.getWidth() << endl;
    cout << "obj.getWidth ++ post: " << obj.getWidth() << endl;
    Rectangle objReT3 = --obj;
    cout << "obj.getWidth -- prefix : " << objReT3.getHeight() << endl;
    cout << "obj.getWidth ++ prefix: " << obj.getHeight() << endl;
    Rectangle objReT4 = obj--;
    cout << "obj.getWidth -- post: " << objReT4.getWidth() << endl;
    cout << "obj.getWidth ++ post: " << obj.getWidth() << endl;
    
    cout << endl << endl;

    Rectangle obj1(10,20);
    cout << "obj < obj1 : " << (obj < obj1) << endl;
    cout << "obj <= obj1 : " << (obj <= obj1) << endl;
    cout << "obj > obj1 : " << (obj > obj1) << endl;
    cout << "obj >= obj1 : " << (obj >= obj1) << endl;
    cout << "obj != obj1 : " << (obj != obj1) << endl;

    cout << endl << endl;

    obj[5];
    cout << "obj.Height[]: " << obj.getHeight() << endl;
    obj();
    cout << "obj.getWidth() : " << obj.getWidth() << endl;
    obj(3);
    cout << "obj.getWidth(3) : " << obj.getWidth() << endl;
    obj(2,3);
    cout << "obj.getWidth(2,3) : " << obj.getWidth() << endl;

    cout << "area : " << int(obj) << endl;
    Rectangle d = 5;
    
    cout << "d : " << d.getWidth() << endl;
    cout << "d : " << d.getHeight() << endl;
    cout << endl << endl;
    return 0;
}

