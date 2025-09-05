//
#include <iostream>
using namespace std;
#include <ctype.h>
int main()
{
 char c;
 cout << "enter a characer :";
 cin >>c;
 if( isalpha(c) )
  {
    if( isupper(c) )
     { cout << c << " is an upper leter\n"; }
    else
     { cout << c << " is an lower leter\n"; }
  }
  if( isdigit(c) )
    { cout << c << " is a number\n"; }
  if( !( isdigit(c) || isalpha(c) ) )
    { cout << c << " is a number\n"; }
}