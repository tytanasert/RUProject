#include<iostream>
using namespace std;
class Material{
    private:
    double price;
    public:
    Material(){setPrice(500);}
    Material(double p){setPrice(p);}
    void setPrice(int x){
        if(x>0){
        price=x;}
        else{
            price=1;
        }
    }
    double getPrice(){
        return price;
    }
    virtual void show()=0;
    virtual string getType()=0;
    void showMaterial(){
        cout<<"Price = "<<price<<endl;
    }
    virtual ~Material(){
        cout<<"~Material Piece = "<<price<<endl;
    }
};
class Gem:public Material{
    private:
    int type;//1.diamond 2.ruby 3.sapphire 4.emerald 5.jasper
    public:
    Gem():Material(500){setType(1);}
    Gem(double p,int t):Material(p){setType(t);}
    void setType(int x){
        if(x>0&&x<6){
            type=x;
        }
        else{
            type=1;
        }
    }
    string getType(){
        switch (type)
        {
        case 1:return "Gem: Diamond";break;
        case 2:return "Gem: Ruby";break;
        case 3:return "Gem: Saphhire";break;
        case 4:return "Gem: Emerald";break;
        case 5:return "Gem: Jasper";break;
        }
        return 0;
    }
    void showGem(){
        cout<<"Gem Type = "<<endl;
        switch (type)
        {
        case 1:cout<<"Diamond"<<endl;break;
        case 2:cout<<"Ruby"<<endl;break;
        case 3:cout<<"Sapphire"<<endl;break;
        case 4:cout<<"Emerald"<<endl;break;
        case 5:cout<<"Japer"<<endl;break;
        default:cout<<"Invalid"<<endl;break;
        }

    }
    void show(){
        cout<<"Gem !"<<endl;
        cout<<"Price = "<<getPrice()<<endl;
        cout<<"Type = ";
        switch (type)
        {
        case 1:cout<<"Diamond"<<endl;break;
        case 2:cout<<"Ruby"<<endl;break;
        case 3:cout<<"Sapphire"<<endl;break;
        case 4:cout<<"Emerald"<<endl;break;
        case 5:cout<<"Japer"<<endl;break;
        default:cout<<"Invalid"<<endl;break;
        }
    }
    ~Gem(){
        cout<<"~Gem Type = "<<type<<endl;
    }
};
class Gold:public Material{
    private:
    int type;//1.9k 2.10k 3.14k 4.18k 5.20k
    public:
    Gold():Material(1000){setType(1);}
    Gold(double p,int t):Material(p){setType(t);}
    void setType(int x){
        if(x>0&&x<6){
            type=x;
        }
        else{
            type=1;
        }
    }

    string getType(){
        switch (type)
        {
        case 1:return "Gold: 9k";break;
        case 2:return "Gold: 10k";break;
        case 3:return "Gold: 14k";break;
        case 4:return "Gold: 18k";break;
        case 5:return "Gold: 20k";break;
        }
        return 0;
    }

    void showGold(){
        cout<<"Gold type = ";switch (type)
        {
        case 1:cout<<"9k"<<endl;break;
        case 2:cout<<"10k"<<endl;break;
        case 3:cout<<"14k"<<endl;break;
        case 4:cout<<"18k"<<endl;break;
        case 5:cout<<"20k"<<endl;break;
        default:cout<<"Invalid"<<endl;;break;
        }
    }
    void show(){
        cout<<"Gold !"<<endl;
        cout<<"Price = "<<getPrice()<<endl;
        cout<<"Type = ";
        switch (type)
        {
        case 1:cout<<"9k"<<endl;break;
        case 2:cout<<"10k"<<endl;break;
        case 3:cout<<"14k"<<endl;break;
        case 4:cout<<"18k"<<endl;break;
        case 5:cout<<"20k"<<endl;break;
        default:cout<<"Invalid"<<endl;;break;
        }
    }
    ~Gold(){
        cout<<"~Gold type = ";
        switch (type)
        {
        case 1:cout<<"9k"<<endl;break;
        case 2:cout<<"10k"<<endl;break;
        case 3:cout<<"14k"<<endl;break;
        case 4:cout<<"18k"<<endl;break;
        case 5:cout<<"20k"<<endl;break;
        default:cout<<"Invalid"<<endl;;break;
        }
    }
};
class Jewelry{
    private:
    static int count;
    double pay;
    Material **m;
    int num;
    public:
    Jewelry(){setPay(300);num=0;m=0;count++;}
    Jewelry(double p,int n){
        setPay(p);
        num=n;
        m=new Material*[num];
        count++;}

    void setPay(double x){
        if(x>0){
            pay=x;
        }
        else{
            pay=1;
        }
    }
    void setNum(int x){
        if(x==num){return;}
        if(num<=0){
            num=0;
            delete[] m;
            m=0;
        }
        else{
            delete[] m;
            num=x;
            m=new Material*[num];
        }
    }
    double getPay(){
        return pay;
    }
    int getNum(){
        return num;
    }
    void setMaterial(int x,Material *mat){
        m[x]=mat;
    }
    void showJewelry(){
        cout<<"Num = "<<num<<endl;
        for(int i=0;i<num;i++){
            m[i]->show();
        }
        cout<<"Pay = "<<pay<<endl;
    }
    Material* getMat(int x){
        return m[x];
    }
    virtual void show()=0;
    virtual string getType()=0;

    static int getCount(){
        return count;
    }
    double getPrice(){
        double amount=0;
        amount+=pay;
        for(int i=0;i<num;i++){
            amount+=m[i]->getPrice();
        }

        return amount;
    }
    virtual ~Jewelry(){
        cout<<"~Jewelry Pay = "<<pay<<endl;
        cout<<"Num = "<<num<<endl;
        cout<<"Material : ";
        for(int i=0;i<num;i++){
            m[i]->show();
        }
        delete[] m;
    }
    string operator!(){
        return this->getType();
    }
};
int Jewelry::count;
class Necklace:public Jewelry{
    private:
    int type;
    public:
    Necklace():Jewelry(500,1){setType(1);}
    Necklace(double p,int n,int t):Jewelry(p,n){setType(t);}
    void setType(int x){
        if(x==1||x==2){
            type=x;
        }
        else{
            type=1;
        }
    }
    string getType(){
        switch (type)
        {
        case 1:return "Necklace: Mee";break;
        case 2:return "Necklace: Mai mee";break;
        };
        return 0;
    }
    void showNecklace(){
        cout<<"Necklace type = ";
        switch (type)
        {
        case 1:cout<<"Mee"<<endl;break;
        case 2:cout<<"Mai mee"<<endl;break;
        };
    }
    void show(){
        cout<<"Necklace !"<<endl;
        cout<<"Type = ";
        switch (type)
        {
        case 1:cout<<"Mee"<<endl;break;
        case 2:cout<<"Mai mee"<<endl;break;
        };
        cout<<"Num = "<<getNum()<<endl;
        cout<<"Material : "<<endl;;
        for(int i=0;i<getNum();i++){
            cout<<getMat(i)->getType()<<endl;
        }
        cout<<"Pay = "<<getPay()<<endl;


    }
    ~Necklace(){
        cout<<"~Necklace Type =";
        switch (type)
        {
        case 1:cout<<"Mee"<<endl;break;
        case 2:cout<<"Mai mee"<<endl;break;
        };;
    }
};
class Earring:public Jewelry{
    private:
    int type;
    public:
    Earring():Jewelry(999,1){setType(1);}
    Earring(double p,int n,int t):Jewelry(p,n){setType(t);}
    void setType(int x){
        if(x>0&&x<4){
            type=x;
        }
        else{
            type=1;
        }
    }
    string getType(){
        switch(type){
            case 1:return "Earring: Bab pan";break;
            case 2:return "Earring: bab huang";break;
            case 3:return "Earring: bab raya";break;
        }
        return 0;
    }
    void showEarring(){
        cout<<"Earring Type = "<<type<<endl;
    }
    void show(){
        cout<<"Earring !"<<endl;
        cout<<"Type = ";
        switch(type){
            case 1:cout<<"Bab pan"<<endl;break;
            case 2:cout<<"bab huang"<<endl;break;
            case 3:cout<<"bab raya"<<endl;break;
            }
        cout<<"Num = "<<getNum()<<endl;
        cout<<"Material : "<<endl;
        for(int i=0;i<getNum();i++){
            cout<<getMat(i)->getType()<<endl;;
        }
        cout<<"Pay = "<<getPay()<<endl;
    }
    ~Earring(){
        cout<<"Type = ";
        switch(type){
            case 1:cout<<"Bab pan"<<endl;break;
            case 2:cout<<"bab huang"<<endl;break;
            case 3:cout<<"bab raya"<<endl;break;
            };
    }
};
class Ring:public Jewelry{
    private:
    int type;
    public:
    Ring():Jewelry(777,1){setType(1);}
    Ring(double p,int n,int t):Jewelry(p,n){setType(p);}
    void setType(int x){
        if(x>0&&x<3){
            type=x;
        }
        else{
            type=1;
        }
    }
    string getType(){
        switch (type)
        {
        case 1:return "Ring: Mee hua";break;
        case 2:return "Ring: Mai mee hua";break;
        }
        return 0;
    }

    void showRing(){
        cout<<"Ring Type ="<<type<<endl;
    }

    void show(){
        cout<<"Ring"<<endl;
        cout<<"Type = ";
        switch (type)
        {
        case 1:cout<<"Mee hua"<<endl;break;
        case 2:cout<<"Mai mee hua"<<endl;break;
        };
        cout<<"Num = "<<getNum()<<endl;
        cout<<"Material : "<<endl;
        for(int i=0;i<getNum();i++){
            cout<<getMat(i)->getType()<<endl;
        }
        cout<<"Pay = "<<getPay()<<endl;
    }
    ~Ring(){
        cout<<"~Ring Type = "<<type<<endl;
    }
};
class Box{
    private:
    Jewelry **jew;
    int num;
    int color;
    public:
    Box(){num=0;jew=0;setColor(1);}
    Box(int n,int c){
        num=n;
        jew=new Jewelry*[num];
        setColor(c);
        }
    Box(Box &b){
        cout<<"Copy cosntructor"<<endl;
        num=b.num;
        jew=new Jewelry*[num];
        for(int i=0;i<num;i++){
            jew[i]=b.jew[i];
        }
        color=b.color;
    }
    void setColor(char l){
        if(l>0&&l<5){
            color=l;

        }
        else{
            color=1;
        }
    }
    void setColor(int x){
        if(x>0&&x<5){
            color=x;
        }
        else{
            color=1;
        }
    }
    void setNum(int x){
        if(num==x){return;}
        if(x<=0){
            num=0;
            delete[] jew;
            jew=0;
        }
        else{
            delete[] jew;
            num=x;
            jew=new Jewelry*[num];
        }
    }
    void setJew(int x,Jewelry *j){
        jew[x]=j;
    }
    int getNum(){
        return num;
    }
    int getColor(){
        return color;
    }
    Jewelry* getJew(int x){
        return jew[x];
    }
    double getPrice(){
        int amount=0;
        for(int i=0;i<num;i++){
            amount+=jew[i]->getPrice();
        }
        return amount;
    }
    int getNumJewelry(string mtype){
        int c=0;
        for(int i=0;i<num;i++){
            for(int j=0;j<jew[i]->getNum();j++)
                if(jew[i]->getMat(i)->getType()==mtype){
                c++;
            }
    }
    return c;
    }
    void showBox(){
        cout<<"Box !"<<endl;
        cout<<"Color = ";
        switch(color){
            case 1:cout<<"Black"<<endl;break;
            case 2:cout<<"Red"<<endl;break;
            case 3:cout<<"White"<<endl;break;
            case 4:cout<<"Pink"<<endl;break;
        }
        cout<<"Num = "<<num<<endl;
        for(int i=0;i<num;i++){
            jew[i]->show();
        }
    }
    ~Box(){
        cout<<"~Box"<<endl;
        cout<<"Color = ";
        switch(color){
            case 1:cout<<"Black"<<endl;break;
            case 2:cout<<"Red"<<endl;break;
            case 3:cout<<"White"<<endl;break;
            case 4:cout<<"Pink"<<endl;break;
        }
        cout<<"Num = "<<num<<endl;
        for(int i=0;i<num;i++){
            jew[i]->show();
        }
    }
    Jewelry* operator[](int x){
        return jew[x];
    }
    friend bool operator>(Box&,Box&);

    operator double(){
        return getPrice();
    }
};
bool operator>(Box &a,Box &b){
    cout<<"hello operator >"<<endl;
    return a.getPrice()>b.getPrice();
}
ostream &operator<<(ostream &os,Material &m){
    m.show();
    return os;
}
ostream &operator<<(ostream &os,Jewelry &j){
    j.show();
    return os;
}
int main(){
    Material *a[8];
    a[0]=new Gem(30000,1);
    a[1]=new Gem(25000,2);
    a[2]=new Gem(15000,3);
    a[3]=new Gem(1000,4);
    a[4]=new Gem(400,5);
    a[5]=new Gold(20000,4);
    a[6]=new Gold(10000,3);
    a[7]=new Gold(5000,2);
    for(int i=0;i<8;i++){
        cout<<"a["<<i<<"]"<<endl;
        cout<<*a[i]<<endl;
    }
    Jewelry *w[3];
    w[0]=new Necklace(2500,2,1);
    w[0]->setMaterial(0,a[5]);
    w[0]->setMaterial(1,a[0]);
    w[1]=new Earring(1500,2,2);
    w[1]->setMaterial(0,a[5]);
    w[1]->setMaterial(1,a[2]);
    w[2]=new Ring(900,2,1);
    w[2]->setMaterial(0,a[6]);
    w[2]->setMaterial(1,a[3]);
    for(int i=0;i<3;i++){
        cout<<"w["<<i<<"]"<<endl;
        w[i]->show();
        cout<<endl;
    }
    Box *b[2];
    b[0]=new Box(2,4);
    b[0]->setJew(0,w[0]);
    b[0]->setJew(1,w[1]);
    b[1]=new Box(1,1);
    b[1]->setJew(0,w[2]);
    for(int i=0;i<2;i++){
        cout<<"b["<<i<<"]"<<endl;
        b[i]->showBox();
        cout<<endl;
    }
    cout<<"b[0]"<<endl;
    cout<<b[0]->getJew(0)->getType()<<endl;
    cout<<b[0]->getJew(1)->getType()<<endl;
    cout<<"b[1]"<<endl;
    cout<<b[1]->getJew(0)->getType()<<endl;

    cout<<"Operator ![]"<<endl;
    cout<<!*(*b[0])[0]<<endl;
    cout<<!*(*b[0])[1]<<endl;
    cout<<!*(*b[1])[0]<<endl;

    cout<<"Operator>"<<endl;
    if(*b[0]>*b[1]==false){
            cout<<b[1]->getPrice()<<endl;
    }
    else{
        cout<<b[0]->getPrice()<<endl;
    }
    cout<<"Operator double()"<<endl;
    if(*b[0]>=*b[1]){
        cout<<*b[1]<<endl;
    }
    else{
        cout<<*b[0]<<endl;
    }
    cout<<"getNumJewelry"<<endl;
    cout<<"b[0] Gold: 18K = "<<b[0]->getNumJewelry("Gold: 18k")<<endl;
    cout<<"b[1] Gold: 18K = "<<b[1]->getNumJewelry("Gold: 18k")<<endl;
    cout<<"getPrice()"<<endl;
    int amount=b[0]->getPrice()+b[1]->getPrice();
    cout<<"b[0] price = "<<b[0]->getPrice()<<endl;
    cout<<"b[1] price = "<<b[1]->getPrice()<<endl;
    cout<<"Price of b[0] + b[1] = "<<amount<<endl;

    cout<<"Without getPrice()"<<endl;
    int amount2=b[0]->getJew(0)->getMat(0)->getPrice()+
    b[0]->getJew(0)->getMat(1)->getPrice()+
    b[0]->getJew(0)->getPay()+
    b[0]->getJew(1)->getMat(0)->getPrice()+
    b[0]->getJew(1)->getMat(1)->getPrice()+
    b[0]->getJew(1)->getPay()+b[1]->getJew(0)->getMat(0)->getPrice()+b[1]->getJew(0)->getMat(1)->getPrice()+b[1]->getJew(0)->getPay();


    cout<<"b[0] price = "<<
    b[0]->getJew(0)->getMat(0)->getPrice()+
    b[0]->getJew(0)->getMat(1)->getPrice()+
    b[0]->getJew(0)->getPay()+
    b[0]->getJew(1)->getMat(0)->getPrice()+
    b[0]->getJew(1)->getMat(1)->getPrice()+
    b[0]->getJew(1)->getPay()<<endl;

    cout<<"b[1] price = "<<b[1]->getJew(0)->getMat(0)->getPrice()+b[1]->getJew(0)->getMat(1)->getPrice()+b[1]->getJew(0)->getPay()<<endl;
    cout<<"price of b[0] + b[1] = "<<amount2<<endl;




     for(int i=0;i<2;i++){
        delete b[i];
    }

    for(int i=0;i<3;i++){
        delete w[i];
    }
    for(int i=0;i<8;i++){
        delete a[i];
    }

}
