#include<iostream>
using namespace std;

class A{
    protected:
     int get(){
         return 10;
     }
    public:
    A(){
        cout << "A Constructor" << endl;
    }
};

class B {
    int b;
    A a;
    public:
    B(){
        cout << "B Constructor" << endl;
    }
    A getA(){
        return A();
    }
    int getfa(){
        return a.get();
    }
};

int main(){
    B b1;
    A a1 = b1.getA();
    cout << a1.get() << endl;
    return 0;
}