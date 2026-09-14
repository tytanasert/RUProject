#include <iostream>
using namespace std;

class Food{
    double price; //ราคา
    public:
    Food(){
        price = 40;
    }

    Food(int p){
        price = p;
    }

    virtual ~Food(){

    }

    virtual string get() =0;

    void setPrice(double p){
        price = p;
    }

    double getPrice(){
        return price;
    }

    virtual void show(){
        cout << "price : " << price << endl;
    }

    void operator<<(Food &f){
        f.show();
    }
};

class StirFried:public Food{
    int type; //1.ผัดกระเพรา 2.ผัดพริกสด 3.ผัดพริกแกง
    int meat; //หมู ไก่ เนื้อ

    public:
    StirFried(){
        type = 1;
        meat = 1;
    }

    StirFried(int p,int t,int m):Food(p){
        type = t;
        meat = m;
    }

    string get(){
        string k="";
        if(type == 1){
            k = "ผัดกระเพรา";
        }else if(type == 2){
            k = "ผัดพริกสด";
        }else if(type == 3){
            k = "ผัดพริกแกง";
        }
        return k;
    }

    void setType(int t){
        type = t;
    }

    void setMeat(int m){
        meat = m;
    }

    int getType(){
        return type;
    }

    int getMeat(){
        return meat;
    }

    void show(){
        Food::show();
        cout << "type : " << type << endl;
        cout << "meat : " << meat << endl;
    }
};

class Rice:public Food{
    int type; //ข้าวขาว  ข้าวกล้อง
    public:
    Rice(){
        type = 1;
    }

    Rice(int p,int t):Food(p){
        type = t;
    }

    string get(){
        string k="";
        if(type == 1){
            k = "ข้าวขาว";
        }else if(type == 2){
            k = "ข้าวกล้่อง";
        }
        return k;
    }

    void setType(int t){
        type = t;
    }

    int getType(){
        return type;
    }

    void show(){
        Food::show();
        cout << "type : " << type << endl;
    }
};

class Egg:public Food{
    int type; //ไข่ด้วยสุก  ไข่ดาวไม่สุก  ไข่เจียว
    public:
    Egg(){
        type = 1;
    }

    Egg(int p,int t):Food(p){
        type = t;
    }

    string get(){
        string k="";
        if(type == 1){
            k = "ไข่ดาวสุก";
        }else if(type == 2){
            k = "ไข่ดาวไม่สุก";
        }else if(type == 3){
            k = "ไข่เจียว";
        }
        return k;
    }

    void setType(int t){
        type = t;
    }

    int getType(){
        return type;
    }

    void show(){
        Food::show();
        cout << "type : " << type << endl;
    }
};

class Soup:public Food{
    int type;  //ต้มยำ ต้มแซ่บ
    int meat; //หมู ไก่
    static int soups;
    public:
    Soup(){
        type = 1;
        meat = 1;
        soups++;
        
    }

    Soup(int p, int t, int m):Food(p){
        type = t;
        meat = m;
        soups++;
    }

    void s1(){cout << "1" << endl;}
    void s1(int i){cout << i << endl;}
    void s1(string s){cout << s << endl;}
    void s1(double d){cout << d << endl;}

    string get(){
        string k="";
        if(type == 1){
            k = "ต้มยำ";
        }else if(type == 2){
            k = "ต้มแซ่บ";
        }
        return k;
    }

    void setType(int t){
        type = t;
    }

    void setMeat(int m){
        meat = m;
    }

    int getType(){
        return type;
    }

    int getMeat(){
        return meat;
    }

    static int getSoups(){
        return soups;
    }

    void show(){
        Food::show();
        cout << "type : " << type << endl;
        cout << "meat : " << meat << endl;
    }
};

int Soup::soups = 0;

class TamSang{
    Food** food; //อาเรย์ขนาด num เก็บพอยเตอร์ที่ชี้ไป Food
    int num; //ขนาดของอาเรย์
    int type; //เอาน้ำปลาพริกด้วย  ไม่เอานำ้ปลาพริก
    public : 
    TamSang(){
        food =0;
        num = 0;
        type = 1;
    }

    ~TamSang(){
        for(int i=0;i<num;i++){
            delete food[i];
        }
        delete[] food;
    }

    //copy Contructor
    TamSang(TamSang &t){
        *food = *t.food;
        num = t.num;
        type = t.type;
    }

    string get(){
        string k="";
        if(type == 1){
            k = "เอานำ้ปลาพริกด่้วย";
        }else if(type == 2){
            k = "ไม่เอาน้ำปลาพริก";
        }
        return k;
    }

    void setFood(int n, Food *f){
        food[n] = f;
    }

    void setNum(int n){
        for(int i=0; i< num;i++){
            delete[] food[i];
        }
        num = n;
        food = new Food*[num];
        // for(int i=0; i< num;i++){
        //     food[i] = new Food();
        // }
    }

    void setType(int t){
        type = t;
    }

    Food* getFood(int i){
        return food[i];
    }

    int getNum(){
        return num;
    }

    int getType(){
        return type;
    }

    void show(){
        cout << "type : " << type << endl;
        cout << "num : " << num << endl;
        for(int i=0;i < num; i++ ){
            cout << "food[" << (i+1) << "]" << endl;
            food[i]->show();
        }
    }

    void operator<<(TamSang &t){
        t.show();
    }

    friend double operator!(TamSang &s){
        double sum = 0;
        for(int i=0;i<s.num;i++){
            sum += s.food[i]->getPrice();
        }
        return sum;
    };
};

class Bag{
    TamSang **tamSang; 
    int num;
    int type; //ใส่ถุงพลาสติก ลูกค้านำถุงมาเอง
    public:
    Bag(){
        tamSang = 0;
        num = 0;
        type = 1;
    }

    ~Bag(){
        for(int i=0;i<num;i++){
            delete tamSang[i];
        }
        delete[] tamSang;
    }

    string get(){
        string k="";
        if(type == 1){
            k = "ใส่ถุงพลาสติก";
        }else if(type == 2){
            k = "ลูกค้านำถุงมาเอง";
        }
        return k;
    }

    void setTamSang(int n, TamSang *t){
        *tamSang[n] = *t;
    }

    void setNum(int n){
        for(int i=0; i< num;i++){
            delete[] tamSang[i];
        }
        num = n;
        tamSang = new TamSang*[num];
        for(int i=0; i< num;i++){
            tamSang[i] = new TamSang();
        }
    }

    void setType(int t){
        type = t;
    }

    TamSang* getTamSang(int i){
        return tamSang[i];
    }

    int getNum(){
        return num;
    }

    int getType(){
        return type;
    }

    void show(){
        cout << "type : " << type << endl;
        cout << "num : " << num << endl;
        for(int i=0;i < num; i++ ){
            cout << "tamSang[" << (i+1) << "]" << endl;
            tamSang[i]->show();
        }
    }

    void operator<<(Bag &b){
        b.show();
    }

    double operatordouble(Bag &b){
        double sum = 0.00;
        for(int i=0;i<b.num;i++){
            sum += !(*b.tamSang[i]);
        }
        return sum;
    }

    bool operator>(Bag &b){
        
        double sum1 = 0;
        for(int i=0;i<num;i++){
            sum1 += !(*tamSang[i]);
        }

        double sum2 = 0;
        for(int i=0;i<b.num;i++){
            sum2 += !(*b.tamSang[i]);
        }
        return sum1 > sum2;
    }

    int getNumType(string type){
        int count =0;
        for(int i=0;i<num;i++){
            for(int j=0; j< tamSang[i]->getNum();j++){
                if(tamSang[i]->getFood(j)->get() == type){
                    count++;
                }
            }
            
        }
        return count;
    }
};

ostream& operator<< (ostream& os, Food &f){
    f.show();
    return os;
}

ostream& operator<<(ostream& os, TamSang &t){
    t.show();
    return os;
}

ostream& operator<< (ostream& os, Bag &b){
    b.show();
    return os;
}

int main(){

    StirFried stirFried[6];
    stirFried[0] = StirFried(40,1,1);
    stirFried[1] = StirFried(50,1,3);
    stirFried[2] = StirFried(40,2,1);
    stirFried[3] = StirFried(35,2,2);
    stirFried[4] = StirFried(35,3,2);
    stirFried[5] = StirFried(50,3,3);

    Rice rice[2];
    rice[0] = Rice(10,1);
    rice[1] = Rice(15,2);

    Egg egg[3];
    egg[0] = Egg(10,1);
    egg[1] = Egg(10,2);
    egg[2] = Egg(20,3);

    Soup soup[3];
    soup[0] = Soup(60,1,2);
    soup[1] = Soup(60,1,1);
    soup[2] = Soup(60,2,1);

    Food* dish[14];
    dish[0] = &stirFried[0];
    dish[1] = &stirFried[1];
    dish[2] = &stirFried[2];
    dish[3] = &stirFried[3];
    dish[4] = &stirFried[4];
    dish[5] = &stirFried[5];

    dish[6] = &rice[0];
    dish[7] = &rice[1];

    dish[8] = &egg[0];
    dish[9] = &egg[1];
    dish[10] = &egg[2];

    dish[11] = &soup[0];
    dish[12] = &soup[1];
    dish[13] = &soup[2];

    // for(int i=0;i<14;i++){
    //     dish[i]->show();
    // }

    //m3
    TamSang* kraprao[2];
    kraprao[0] = new TamSang();
    kraprao[0]->setNum(3);
    kraprao[0]->setFood(0,dish[0]);
    kraprao[0]->setFood(1,&egg[0]);
    kraprao[0]->setFood(2,&rice[0]);
    kraprao[0]->setType(1);

    kraprao[1] = new TamSang();
    kraprao[1]->setNum(3);
    kraprao[1]->setFood(0,dish[1]);
    kraprao[1]->setFood(1,&egg[1]);
    kraprao[1]->setFood(2,&rice[1]);
    kraprao[1]->setType(2);

    TamSang* padprik[2];
    padprik[0] = new TamSang();
    padprik[0]->setNum(2);
    padprik[0]->setFood(0,dish[2]);
    padprik[0]->setFood(1,&rice[0]);
    padprik[0]->setType(2);

    padprik[1] = new TamSang();
    padprik[1]->setNum(4);
    padprik[1]->setFood(0,dish[3]);
    padprik[1]->setFood(1,&egg[2]);
    padprik[1]->setFood(2,&rice[0]);
    padprik[1]->setFood(3,&soup[0]);
    padprik[1]->setType(1);

    // //m4
    TamSang* prikkang1;
    prikkang1 = new TamSang();
    prikkang1->setNum(3);
    prikkang1->setFood(0,dish[4]);
    prikkang1->setFood(1,&egg[2]);
    prikkang1->setFood(2,&soup[1]);
    prikkang1->setType(1);

    TamSang* prikkang2;
    prikkang2 = new TamSang();
    prikkang2->setNum(5);
    prikkang2->setFood(0,dish[5]);
    prikkang2->setFood(1,&soup[0]);
    prikkang2->setFood(2,&soup[2]);
    prikkang2->setFood(3,&rice[0]);
    prikkang2->setFood(4,&rice[1]);
    prikkang2->setType(1);

    cout << *kraprao[0] << endl;
    cout << *kraprao[1] << endl;
    cout << *padprik[0] << endl;
    cout << *padprik[1] << endl;
    cout << *prikkang1 << endl;
    cout << *prikkang1 << endl;

    //m5
    TamSang* kai[2];
    // kai[0](*prikkang1);                  //error
    // kai[0] = new TamSang(*prikkang1);    //error
    // kai[1] = new TamSang(*prikkang1);

    kai[0] = new TamSang(); //create when m5 error
    kai[0]->setNum(3);      //create when m5 error
    kai[1] = new TamSang(); //create when m5 error
    kai[0]->setFood(0,&egg[0]);
    kai[0]->setFood(1,&egg[0]);
    kai[0]->setFood(2,&stirFried[5]);
    //m6
    
    for(int i=0;i<kai[0]->getNum();i++){
        cout << "type" << i+1 << " : " << (kai[0]->getFood(i)->get()) << endl;
        cout << "price" << i+1 << " : " << kai[0]->getFood(i)->getPrice() << endl;
    }   

    //m7
    Bag* bag[4];
    bag[0] = new Bag();
    bag[0]->setType(1);
    bag[0]->setNum(3);
    bag[0]->setTamSang(0,prikkang1);
    bag[0]->setTamSang(1,prikkang2);
    bag[0]->setTamSang(2,prikkang1);

    bag[1] = new Bag();
    bag[1]->setType(2);
    bag[1]->setNum(3);
    bag[1]->setTamSang(0,kraprao[0]);
    bag[1]->setTamSang(1,kraprao[1]);
    bag[1]->setTamSang(2,kai[1]);

    bag[2] = new Bag();
    bag[2]->setType(2);
    bag[2]->setNum(2);
    bag[2]->setTamSang(0,padprik[0]);
    bag[2]->setTamSang(0,padprik[1]);

    //m8
    bag[0]->show();
    bag[1]->show();
    bag[2]->show();
    double(*bag[0]);
    double(*bag[1]);
    double(*bag[2]);

    //m9
    for(int i=0;i<3;i++){
        cout << "bag[ " << i+1 << "] : " << endl;
        cout << "num : " << bag[i]->getNum() << endl;
        cout << "type  : " << bag[i]->get() << endl;
        for(int j=0;j< bag[i]->getNum();j++){
            bag[i]->getTamSang(j)->show();
            cout << "sum : " << !(bag[i]->getTamSang(j)) << endl;;
        }
    }

    //m10
    for(int i=0;i<3;i++){
        cout << bag[i]->getNumType("ไข่เจียว") << endl;
    }

    //m11
    soup[0].s1();
    cout << soup[0];
    soup[0].s1(2);
    cout << soup[0];
    soup[0].s1("grade A is mind");
    cout << soup[0];
    soup[0].s1(4.00);
    cout << soup[0];
    
    //m12

    for(int i=0;i<14;i++){
        dish[i] = 0;
        delete dish[i];
    }
    for(int i=0;i<2;i++){
        kraprao[i] = 0;
        delete kraprao[i];
    }
    for(int i=0;i<2;i++){
        padprik[i] = 0;
        delete padprik[i];
    }
    prikkang1 = 0;
    delete prikkang1;

    prikkang2 = 0;
    delete prikkang2;

    for(int i=0;i<2;i++){
        kai[i] = 0;
        delete kai[i];
    }

    for(int i=0;i<3;i++){
        bag[i] = 0;
        delete bag[i];
    }
    
    //m13
    cout << Soup::getSoups() << endl;

    return 0;
}
