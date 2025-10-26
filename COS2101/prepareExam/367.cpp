//เฉลยข้อสอบข้อ 3 ปี 2567 by AI
#include <iostream>
using namespace std;

void toHex(int n) {
    if (n == 0) return;

    toHex(n / 16);
    int rem = n % 16;
    if (rem < 10)
        cout << rem;
    else if(rem == 10)
        cout << "A";
    else if(rem == 11)
        cout << "B";
    else if(rem == 12)
        cout << "C";
    else if(rem == 13)
        cout << "D";
    else if(rem == 14)
        cout << "E";
    else if(rem == 15)
        cout << "F";
        
}

int main() {
    int num;
    cout << "Enter an integer: ";
    cin >> num;
    if (num == 0) {
        cout << "0";
    } else if (num < 0) {
        cout << "-";
        num = -num;
        toHex(num);
    } else {
        toHex(num);
    }
    cout << endl;
    return 0;
}