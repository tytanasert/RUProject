//โครงสร้างพื้นฐาน
#include<iostream>
using namespace std;
int get_value_ten ();    // prototype for print_title function
int get_value_two ();
float g =  15.5; //global value

int main (  )
 {
  int x,y,z;
  //cast
//   Double(1);
 }



//pass by value , pass by reference
void pass_val ( int l , double &y) 
{
    l = l*2;  y = y+2;
    cout << "\nl = " << l; 
    cout << "\ny = " << y ;
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
