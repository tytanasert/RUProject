#include <iostream>
#include <ctype.h>
#include <cstring>
using namespace std;

void forward(int n) {
    if(n != 0) {
        forward(n / 10);
        cout << n % 10 << endl;
    }
}

void f2(int i){
    if(i<=3){
        cout << "\n line No. " << i << endl;
        f2(i + 1);
    }
}
void f3(int i){
    
    if(i>0){
        cout << "\n line No. " << i << endl;
        f3(i-1);
    }
    // for(int i = 3;i>0 ;i--){
    //     cout << "\n line No. " << i << endl;
    // }
}

void f4(int i){
    if(i>0){
        f4(i-1);
        cout << "\n line No. " << i << endl;
    }
}

void f5(int i, int s){
    if(i>0){
        s =s +i;
        cout << "\n line No. " << i << " s : " << s << endl;
        f5(i-1, s);
        
    }

    // int s =0;
    // for(int i = 3 ;i>0 ;i--){
    //     s = s + i;
    //     cout << s << endl;
    // }
}

int main()
{
    cout << "test pases" <<endl;
    int n = 123;
    forward(n);
    // f2(1);
    // f5(3,0);
    return 0;

}