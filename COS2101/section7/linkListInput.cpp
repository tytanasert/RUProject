#include <iostream>
#include <iomanip>

struct node  {
    char d;
    int x,y;
    struct node *next;

};

void display(struct node *a){

    struct node *p = a;
    printf("p \t\t\t\t d \t\tx  \t\ty  \t\tnext  \n");
     
    while(p!=NULL) {

        printf("%p \t\t\t %c \t\t%d  \t\t%d  \t\t%p  \n",
            p,p->d,p->x,p->y,p->next);
     
        p = p->next;
    }
}

void deleteNode(struct node *p){
    while(p!= NULL){
        struct node *d = p;
        p = p->next;
        delete d;
    }
}

int main(){
    //ปรับให้ใช้ตัวแปรลดลง

    struct node *p;
    struct node *a = new struct node;
    p = a;
    p -> d = 'p'; p->x = 10; p->y = 20;
    p -> next = new struct node;
    p = p->next;
    p -> d = 'b'; p->x = 11; p->y = 21;
    p -> next = new struct node;
    p = p->next;
    p -> d = 'c'; p->x = 12; p->y = 22;
    p -> next = new struct node;
    p = p->next;
    p -> d = 'd'; p->x = 13; p->y = 23;

    display(a);

    p=a;
    display(a);
    deleteNode(a);
    delete(a);
    delete(p);
    
    /* output
            p 				 d 		x  		y  		next  
        0x117f02b0 			 p 		10  		20  		0x117f02d0  
        0x117f02d0 			 b 		11  		21  		0x117f02f0  
        0x117f02f0 			 c 		12  		22  		0x117f0310  
        0x117f0310 			 d 		13  		23  		(nil)  
    */
    return 0;
}