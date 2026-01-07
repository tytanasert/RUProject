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

class MyRect {
    private:
        int row,col;
        Rectangle **a;
        void createNew(int row, int col);
        void deleteAll();
    public:
        MyRect(){ row=col=0; a=0;}
        MyRect(int r, int c);
        ~MyRect();
        void set(int row, int col , int width, int height);
        void set(int row, int col , Rectangle r);
        void setRect();
        Rectangle getRect(int row, int col);
        void reset(int row, int col);
        void show();
};

void MyRect::createNew(int row, int col){
    a = new Rectangle*[row];
    for(int i=0; i<row; i++){
        a[i] = new Rectangle[col];
    }
}

void MyRect::deleteAll(){
    if(a != 0){
        for(int i=0; i<row; i++){
            delete [] a[i];
        }
        delete [] a;
    }
}

MyRect::MyRect(int r, int c){
    row = r; col = c;
    createNew(row,col);
}
MyRect::~MyRect(){
    deleteAll();
}

void MyRect::set(int row, int col , int width, int height){
        a[row][col].set(width, height);
}

void MyRect::set(int row, int col , Rectangle r){
        a[row][col]= r;
}

void MyRect::setRect(){
    int w,h;
    for(int i=0; i<row; i++){
        for(int j=0; j<col; j++){
            cout << "Input a[" << i << "][" << j << "] width : " ;
            cin >> w;
            a[i][j].setWidth(w);
            cout << "Input a[" << i << "][" << j << "] height : " ;
            cin >> h;
            a[i][j].setHeight(h);
        }
    }
    cout << "set finish" << endl << endl;
}

Rectangle MyRect::getRect(int row, int col){
    return a[row][col];
}

void MyRect::reset(int row, int col){

    deleteAll();

    createNew(row,col);

    setRect();
    cout << "reset finish" << endl << endl;
}

void MyRect::show(){
    cout << "row : " << row << ", col : " << col << endl;
    for(int i=0; i<row; i++){
        for(int j=0; j<col; j++){
            cout << "a[" << i << "][" << j << "] = ";
            a[i][j].show();
        }
    }
    cout << "show finish" << endl << endl;
}

int main(){
    cout << "---- start -----" << endl;
    MyRect x(2,3);
    x.show();

    cout << endl << "---- setRect -----" << endl;
    x.setRect();
    x.show();

    cout << endl << "---- set from input width , height (9,9) -----" << endl;
    x.set(0,1,9,9);

    cout << endl << "---- set from Rect[0,1] -----" << endl;
    x.set(0,0,x.getRect(0,1));
    x.show();

    cout << endl << "---- reset -----" << endl;
    x.reset(2,1);
    x.show();
    
    return 0;
}

