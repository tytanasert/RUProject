#include <iostream>
#include <stdio.h>
 
using namespace std;

struct employee {
    char name[16];
    int  id;
};

int main()
{
    int  i, *pi;
    float  f, *pf;
    char  c, *pc;
    double  d, *pd;
    struct employee e, *pe;

    cout << "\n sizeof(i) = " << sizeof(i) << " sizeof(pi) = " << sizeof(pi) ; 
    cout << "\n sizeof(f) = " << sizeof(f) << " sizeof(pf) = " << sizeof(pf) ; 
    cout << "\n sizeof(c) = " << sizeof(c) << " sizeof(pc) = " << sizeof(pc) ; 
    cout << "\n sizeof(d) = " << sizeof(d) << " sizeof(pd) = " << sizeof(pd) ; 
    cout << "\n sizeof(e) = " << sizeof(e) << " sizeof(pe) = " << sizeof(pe) ;
    
    int  a[3], *pa;
    pa = a;  // or pa = &a[0];
    for(i=0; i < 3 ; i++) {
        a[i] = 10 + i;
    }
    for(i=0; i < 3 ; i++) {
        printf("\n a[%d] = %d  *(pa+%d) = %d", i, a[i], i, *(pa+i) );
    }
    

    return 0;
}

