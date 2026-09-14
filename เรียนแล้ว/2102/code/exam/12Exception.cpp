#include<iostream>
using namespace std;

class Exception{
    public:
    // virtual void 
};

class Animal{

};

class Human:public Animal{
    public:
    void sleep()throw(int){
        throw 0;
    }
    void gostudy() throw(int){
        sleep();
    }
    void doHw() throw(){
        try{
            gostudy();
        }catch(int e){
            cout << "Exception caught in doHw : " << e << endl;
        }
    }
};

class Cat:public Animal{
};

class MyException:public Exception{

    public:
    virtual const char* what() const throw(){
        return "divide is 0 can not divide";
    }
};

int main(){
    //12.1 12.2
    // for(int i = 0; i < 5; i++){
    //     try{
    //         int type =0;
    //         cout << "Enter exception type (1 = int ,2 = double ,3 = char ,4 = other ) : "; cin >> type;
    //         if(type == 1){
    //             throw 10;
    //         }else if(type == 2){
    //             throw 3.14;
    //         }else if(type == 3){
    //             throw 'a';
    //         }else{
    //             throw "Unknown exception";
    //         }
    //         cout << "oh is not throw exception" << endl;
    //     }catch(int e){
    //         cout << "Exception caught int" << endl;
    //     }
    //     catch(double e){
    //         cout << "Exception caught double" << endl;
    //     }
    //     catch(char e){
    //         cout << "Exception caught char" << endl;
    //     }
    //     catch(...){
    //         cout << "Exception caught other" << endl;
    //     }
    //     cout << "I happy " << endl;
    // }

    // //12.3
    
    // try{
    //     // Human h;
    //     // throw h;

    //     Cat c;
    //     throw c;
    // }catch(Cat c){
    //     cout << "Cat exception caught" << endl;
    // }catch(Animal a){
    //     cout << "Animal exception caught" << endl;
    // }catch(Human h){
    //     cout << "Human exception caught" << endl;
    // }catch(...){
    //     cout << "Other exception caught" << endl;
    // }
    // cout << " -----------  I finish 12.3 ------------" << endl;
    

    //12.4
    Human hu;
    try{
        // hu.gostudy();
        hu.doHw();
    }catch(int e){
        cout << "Exception in main : " << e << endl;
    }
    cout << " -----------  I finish 12.4 ------------" << endl << endl;



    MyException ex;
    try{
        int divide =0;
        cout << "Enter number for divide (100 / divide) : "; cin >> divide;

        if(divide == 0){
            throw ex;
        }
        cout << "your answer is : " << 100 / divide << endl;

    }catch(MyException &e){
        cout << "Caught myException : " << e.what() << endl;
    }catch(...){
        cout << "Caught other exception" << endl;
    }


    return 0;
}