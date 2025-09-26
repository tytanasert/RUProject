// Online C++ compiler to run C++ program online
#include <iostream>
#include <iomanip>

struct node  {
    char d;
    int x,y;
    struct node *next;

};

void simple(){
    struct node a = {'a',10,20 };
    struct node b = {'b',11,21 };
    struct node c = {'c',12,22 };
    struct node d = {'d',13,23 };
    a.next = &b;
    b.next = &c;
    c.next = &d;
    d.next = NULL;
    struct node *p = &a;

    printf("p \t\t\t\t d \t\tx  \t\ty  \t\tnext  \n");
     
    while(p!=NULL) {

        printf("%p \t\t\t %c \t\t%d  \t\t%d  \t\t%p  \n",
            p,p->d,p->x,p->y,p->next);
     
        p = p->next;
    }
}
int main() {
    struct node *a = new struct node;
    a -> d = 'a'; a->x = 10; a->y = 20;
    struct node *b = new struct node;
    b -> d = 'b'; b->x = 11; b->y = 21;
    struct node *c = new struct node;
    c -> d = 'c'; c->x = 12; c->y = 22;
    struct node *d = new struct node;
    d -> d = 'd'; d->x = 13; d->y = 23;
    (*a).next = b;
    (*b).next = c;
    (*c).next = d;
    (*d).next = NULL;
    struct node *p = a;

    printf("p \t\t\t\t d \t\tx  \t\ty  \t\tnext  \n");
     
    while(p!=NULL) {

        printf("%p \t\t\t %c \t\t%d  \t\t%d  \t\t%p  \n",
            p,p->d,p->x,p->y,p->next);
     
        p = p->next;
    }

    return 0;
}

