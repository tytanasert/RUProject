#include <iostream>
#include <cstring>
using namespace std;

struct Account {
    char  id[10];
    char  name[20+30];
    char  address[200];
    float deposit;
};

int getChoice() {
    int choice;
    cout<<"1.Open Account" << endl;
    cout<<"2.Deposit Account" << endl;
    cout<<"3.Withdraw Account" << endl;
    cout<<"4.Compute Interest" << endl;
    cout<<"5.Quit" << endl;
    cin >> choice;
    // if (cin.fail()) {
    //     cin.clear(); // ล้างสถานะ error ของ cin
    //     cin.ignore(numeric_limits<streamsize>::max(), '\n'); // ทิ้ง input ที่ผิด
    //     cout << "กรุณาใส่ตัวเลขเท่านั้น!\n\n";
    // } else {
    //     return choice; // ออกเมื่อใส่ตัวเลขจริง
    // }
    return choice;
}


int befound(Account acc[], int n, char *id){
    int i;
    for(i=0 ; i < n ; i++) {
        if( strcmp( id, acc[i].id) == 0) {
            return i;
        }
    }
    return -1;
}

void createAccount(Account acc[], int &n) {
    char  id[10];
    char  name[20+30];
    char  address[200];
    float deposit,withdraw,rate;
    bool bfound ;

    cout << "id = ";
    cin >> id;
    int i = befound(acc, n, id);
    
    if(i < 0) {
        cout << "name = ";
        cin >> name;
        cout << "address = ";
        cin >> address ;
        cout << "deposit = ";
        cin >> deposit; 
        strcpy(acc[n].id,id);
        strcpy(acc[n].name ,name);
        strcpy(acc[n].address ,address);
        acc[n].deposit = deposit;
        n++;
        
    }else {
        cout << "id duplicate" << endl;
    }
}

void deposit(Account acc[], int n){
    char id[10];
    cout << "id = ";
    cin >> id;
    int i = befound(acc, n, id);
    
    if(i >= 0) {
        float deposit;
        cout << "name = " << acc[i].name <<endl;
        cout << "address = " << acc[i].address <<endl;
        cout << "before deposit = " << acc[i].deposit <<endl;
        cout << "new  deposit = ";
        cin >> deposit; 
        //acc[i].deposit = acc[i].deposit+deposit;
        acc[i].deposit += deposit;
        
        cout << "update  deposit = " << acc[i].deposit << endl; 
    }     
    else {
        cout << "not found " << endl;
    }
    
}

void withdraw(Account acc[], int n){
    
    char id[10];
    float withdraw;
    cout << "id = ";
    cin >> id;
    int i = befound(acc, n, id);
    
    if(i >= 0) {
        cout << "name = " << acc[i].name <<endl;
        cout << "address = " << acc[i].address <<endl;
        cout << "before deposit = " << acc[i].deposit <<endl;
        cout << "Withdraw = ";
        cin >> withdraw; 
        //acc[i].deposit = acc[i].deposit+deposit;
        if( (acc[i].deposit-withdraw ) > 100) {
            acc[i].deposit -= withdraw;
            cout << "update  deposit = " << acc[i].deposit << endl; 
        }
        else {
            cout << "accout below 100 : " << acc[i].deposit << endl; 
        }
    }     
    else {
        cout << "not found " << endl;
    }
}

void computeRate(Account acc[], int n){
    int i;
    float rate;
    cout << "rate = ";
    cin >> rate;
    for(i=0; i < n ; i++) {
        cout << "acco = " << acc[i].id << endl; 
        cout <<" before deposit = " << acc[i].deposit << endl; 
        acc[i].deposit = acc[i].deposit + (acc[i].deposit*rate);
        cout << "update deposit = " << acc[i].deposit << endl; 
    }
}

int main()
{
    Account acc[100];
    int n = 0;
    while(true)
    {
        int choice = getChoice();
        if( choice == 5) {
            break;
        }
        switch(choice)
        {
            case 1:
                    createAccount(acc, n);
                    break;
            case 2:
                    deposit(acc, n);
                    break;
            case 3:
                    withdraw(acc, n);
                    break;
            case 4:
                    computeRate(acc, n);
                    break;
        } 
        
    } 
    return 0;
}
