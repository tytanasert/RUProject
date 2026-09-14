#include<iostream>
using namespace std;

template <class X>
class FindMaxMin{
    X max;
    X min;
    public:

    void findMaxfromArr(X* x, int size){
        max = x[0];
        min = x[0];
        for(int i = 1; i < size; i++){
            if(x[i] > max){
                max = x[i];
            }
            if(x[i] < min){
                min = x[i];
            }
        }
    }

    void show(){
        cout << " Max : " << this -> max << endl; 
        cout << " Min : " << this -> min << endl;
    }
};

template <class X>
X findMax(X x, X y, X z){
    if(x >= y && x >= z){
        return x;
    }else if(y >= x && y >= z){
        return y;
    }else{
        return z;
    }
}   

int main(){
    
    cout << findMax(10, 33, 22) << endl;  
    cout << findMax(10.4, 33.3, 22.5) << endl;  
    cout << findMax('a', 'b', 'c') << endl << endl;  


    int* arr = new int[5];
    arr[0] = 10;
    arr[1] = 20;
    arr[2] = 50;
    arr[3] = 40;
    arr[4] = 30;
    FindMaxMin<int> f;
    f.findMaxfromArr(arr, 5);
    f.show();
    delete[] arr;

    double* arrDouble = new double[5];
    arrDouble[0] = 10.1;
    arrDouble[1] = 20.2;
    arrDouble[2] = 50.5;
    arrDouble[3] = 40.4;
    arrDouble[4] = 30.3;
    FindMaxMin<double> fd;
    fd.findMaxfromArr(arrDouble, 5);
    fd.show();
    delete[] arrDouble;

    
    
    return 0;
}