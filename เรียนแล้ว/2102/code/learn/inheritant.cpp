#include<iostream>
using namespace std;

class A {
    int a;
    public:
    A(){
        cout << " A created" << endl;
    }
    ~A(){
        cout << " A death" << endl;
    }
};

class B: public A{
    int b;
    public:
    B(){
        cout << " B created" << endl;
    }
    ~B(){
        cout << " B death" << endl;
    }
};

class C : public A {
    int c;
    public:
    C(){
        cout << " C created" << endl;
    }
    ~C(){
        cout << " C death" << endl;
    }
};

int main(){
    A a;
    B b;
    C c;
    

    return 1;
}