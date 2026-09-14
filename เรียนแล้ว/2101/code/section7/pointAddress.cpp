#include <iostream>
#include <stdio.h>
using namespace std;

struct point {
    int x;
    int y;
};

void p_swap(int *, int *);
void r_swap(int&, int&);

void p_swap(int *a, int *b)
{
 int temp;
  temp = *a;	 
  *a = *b;	 
  *b = temp;
}  

void r_swap(int &a, int &b)
{
 int temp;
 temp = a;	 
 a = b;	 
 b = temp;
}

int passByAddressTwoWay (void){
 int v = 5, x = 10;
 cout << v << x << endl;
 p_swap(&v,&x);
 cout << v << x << endl;
 r_swap(v,x);
 cout << v << x << endl;
 return 0;
}

int main()
{
    int     x= 50;
    int     y= 100;
    float   number=40.4;
    
    int *px;
    px = &x;

    int **ppx;
    ppx = &px;

    //%lx แสดงค่า address ในรูปแบบเลขฐาน 16
    //%d แสดงค่า address ในรูปแบบเลขฐาน 10
    //%p แสดงค่า address ในรูปแบบ pointer (มาตรฐานสำหรับ address)
    
    cout << &x << endl; //= %p
    printf("\nx= %d , addr &x= %lx",x,&x); 
    printf("\npx= %d , addr *px= %d",px,*px); //การใส่ * หน้า px แสดงค่า content ของ address px 

    px = &y;
    printf("\ny= %d , addr &y= %p",y,&y); 
    printf("\npx= %d , addr *px= %d",px,*px); 
    
    char    ch='A';
    char *pch;
    pch = &ch;
    printf("\n\n ch= %c , addr &ch= %lx",ch,&ch); 
    printf("\npch= %lx , addr *pch= %c",pch,*pch); 

    //กำหนดค่า ch โดยใช้ pointer pch
    *pch = 'B';
    printf("\n ch= %c , addr &ch= %lx",ch,&ch); 
    printf("\npch= %lx , addr *pch= %c",pch,*pch); 

    struct point p1 = {20, 30}, *p2;
    p2 = &p1;
    printf("\n\np1.x= %d , p1.y= %d ,addr p1 =%p",p1.x,p1.y ,&p1);
    printf("\np2= %p  , addr p2->x= %d , addr p2->y= %d",p2,p2->x ,p2->y); //การใช้ -> แทนการใช้ *p2.x
    printf("\np2= %p  , addr (*p2).x= %d , addr (*p2).y= %d",p2,(*p2).x ,(*p2).y);

    p2->x = 15;
    p2 ->y = 25;
    printf("\n\np1.x= %d , p1.y= %d ,addr p1 =%p",p1.x,p1.y ,&p1);
    printf("\np2= %p  , addr p2->x= %d , addr p2->y= %d",p2,p2->x ,p2->y);

    return 0;
}
