//โครงสร้างพื้นฐาน
#include<iostream>
using namespace std;
int get_value_ten ();    // prototype for print_title function
int get_value_two ();


int main (  )
 {
  int x,y,z;
  
 }

void scope(){
 int x=10,y=20,z=30;
     {
         int z = 5 , a = 100;
         
         cout << "y: " << y << endl;
         cout << "z: " << z << endl;
         cout << "a: " << a << endl;
         y= a;
     }
    //  cout << "a: " << a << endl;
     cout << "y: " << y << endl;
     cout << z << endl;
     x = get_value_ten(  );      // call to print_title
     y = get_value_two();
     cout << x << endl;
     z = (x + get_value_two())*get_value_ten();
     cout << z;
}

// Function to print program title to screen.
 int get_value_two ()
 {
     return 2;
 }
 // Function to print program title to screen.
int get_value_ten (  )
 {
     return 10;
 }
