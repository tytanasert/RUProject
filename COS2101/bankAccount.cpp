#include <iostream>
#include <cstring>
using namespace std;

struct Account {
    char  id[10];
    char  name[20+30];
    char  address[200];
    float deposit;
};


int main()
{
    struct Account acc[100];
    int i;
    int choice;
    int n = 0;
    char  id[10];
    char  name[20+30];
    char  address[200];
    float deposit,withdraw,rate;
    bool bfound ;
    while(true)
    {
        std::cout<<"1.Open Account" << endl;
        std::cout<<"2.Deposit Account" << endl;
        std::cout<<"3.Withdraw Account" << endl;
        std::cout<<"4.Compute Interest" << endl;
        std::cout<<"5.Quit" << endl;
        cin >> choice;
        if( choice == 5) {
            break;
        }
        switch(choice)
        {
            case 1:
                    cout << "id = ";
                    cin >> id;
                    bfound = false;
                    for(i=0 ; i < n ; i++) {
                        if( strcmp( id, acc[i].id) == 0) {
                            bfound=true;
                            cout << "id duplicate" << endl;
                            break;
                        }
                    }
                    if(bfound==false) {
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
                        
                    }
                    break;
                    
            case 2:
                    cout << "id = ";
                    cin >> id;
                    bfound = false;
                    for(i=0 ; i < n ; i++) {
                        if( strcmp( id, acc[i].id) == 0) {
                            bfound=true;
                            break;
                        }
                    }
                    
                    if(bfound==true) {
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
            
                    break;
            case 3:
                    cout << "id = ";
                    cin >> id;
                    bfound = false;
                    for(i=0 ; i < n ; i++) {
                        if( strcmp( id, acc[i].id) == 0) {
                            bfound=true;
                            break;
                        }
                    }
                    
                    if(bfound==true) {
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
                            cout << "accout below 100 " << acc[i].deposit << endl; 
                        }
                        
                        
                    }     
                    else {
                        cout << "not found " << endl;
                    }

                    break;
            case 4:
                    cout << "rate = ";
                    cin >> rate;
                    for(i=0; i < n ; i++) {
                        cout << "acco = " << acc[i].id << endl; 
                        cout <<" before eposit = " << acc[i].deposit << endl; 
                        acc[i].deposit = acc[i].deposit + (acc[i].deposit*rate);
                        cout << "update  deposit = " << acc[i].deposit << endl; 
                    } //end for
                    break;
        } //endswitch
        
    } //endwhile

    return 0;
}
