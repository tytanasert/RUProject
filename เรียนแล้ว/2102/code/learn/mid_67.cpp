#include<iostream>
using namespace std;

class Meat {
    private:
    int type =1 ; //1.หมู 2.ไก่ 3.ปลา 4.กุ้ง 5.ปลาหมึก 6.หอย
    public:
    void setType(int t){
        if(t >=1 && t <=6){
            type = t;
        }
    }
    int getType(){
        return type;
    }
};
class Vegetable {
    private:
    string name =""; // ชื่อผัก
    public:
    void setName(string n){
        name = n;
    }
    string getName(){
        return name;
    }
};

class Food {
    private:
    double price;
    Meat *meat;
    int meatNum ;
    Vegetable *veg;
    int vegNum;
    static int foodCount;

    public:
    Food(){
        setPrice(99);
        meat = 0;
        setMeatNum(0);
        veg = 0;
        setVegNum(0);
        foodCount++;
    }
    Food(double p){
        setPrice(p);
        meat = 0;
        setMeatNum(0);
        veg = 0;
        setVegNum(0);
        foodCount++;
    }
    ~Food(){
        cout << "Good bye Food" << endl;
        cout << "price : " << getPrice() << endl;
        cout << "meatNum : " << getMeatNum() << endl;
        for(int i=0; i<getMeatNum(); i++){
            cout << "meat type " << i << " : " << meat[i].getType() << endl;
        }

        cout << endl;

        cout << "vegNum : " << getVegNum() << endl;
        for(int i=0; i<getVegNum(); i++){
            cout << "veg name " << i << " : " << veg[i].getName() << endl;
        }

        cout << endl;

        //delete
        delete[] meat;
        delete[] veg;

    }
    void setPrice(double p){
        if(p >0){
            price = p;
        }
    }
    void setMeat(int type, int index){
        meat[index].setType(type);
    }
    void setMeatNum(int n){
        if(n >=0){
            meatNum = n;
            delete[] meat;
            meat = new Meat[n];
        }
    }
    void setVeg(int index, string name){
        veg[index].setName(name);
    }
    void setVegNum(int n){
        if(n >=0){
            vegNum = n;
            delete[] veg;
            veg = new Vegetable[n];
        }
    }

    //get
    double getPrice(){
        return price;
    }
    int getMeatNum(){
        return meatNum;
    }
    int getVegNum(){
        return vegNum;
    }  
    Meat getMeat(int i){
        return meat[i];
    }
    Vegetable getVeg(int i){
        return veg[i];
    }

    static void getFoodCount(){
        cout << "Food count : " << foodCount << endl;
    }
    static void foodIncrease(){
        foodCount++;
    }

};

int Food::foodCount =0;

class Soup : public Food {
    private:
    int type =1; // ตำยำ  แกงส้ม  ต้นโคล้ง  โป๊ะแตก
    int spicyLevel =1; // ระดับความเผ็ด 1-4 
    public:
    Soup(){
        setSpicyLevel(1);
    }
    void setSpicyLevel(int level){
        if(level >=1 && level <=4){
            spicyLevel = level;
        }
    }
    void setType(int t){
        if(t >=1 && t <=4){
            type = t;
        }
    }
    
    int getSpicyLevel(){
        return spicyLevel;
    }   
    int getType(){
        return type;
    }

    void show(){
        cout << "Spicy Level : " << getSpicyLevel() << endl;
        cout << "Soup Type : " << getType() << endl;
        cout << "Price : " << getPrice() << endl;
        cout << "Meat Num : " << getMeatNum() << endl;
        for(int i=0; i<getMeatNum(); i++){
            cout << "Meat " << i << " Type : " << getMeat(i).getType() << endl;
        }
        cout << "Veg Num : " << getVegNum() << endl;
        for(int i=0; i<getVegNum(); i++){
            cout << "Veg " << i << " Name : " << getVeg(i).getName() << endl;
        }
    }
};

class Kaopad : public Food{
    private:
    int type =1; // 1 = จานเล็ก, 2 = จานใหญ่
    public:
    Kaopad(){
        setType(1);
    }
    Kaopad(int t){
        setType(t);
    }
    void setType(int t){
        if(t ==1 || t==2){
            type = t;
        }
    }
    int getType(){
        return type;
    }
    bool isMoreExpensiveThan(Kaopad k){
        if(getPrice() > k.getPrice()){
            return true;
        }else{
            return false;
        }
    }
    void showMeat(){
        int n = getMeatNum();
        for(int i=0; i<n; i++){
            cout << getMeat(i).getType() << endl;
        }
    }

};

int main(){
    Soup s[2];
    s[0].setType(1);
    s[0].setSpicyLevel(4);
    s[0].setPrice(250);
    s[0].setMeatNum(3);
    s[0].setMeat(0,4);
    s[0].setMeat(1,5);
    s[0].setMeat(2,6);

    s[1].setType(2);
    s[1].setSpicyLevel(3);
    s[1].setPrice(100);
    s[1].setMeatNum(1);
    s[1].setMeat(0,3);
    s[1].setVegNum(2);
    s[1].setVeg(0,"มะละกอ");
    s[1].setVeg(1,"ถั่วฝักยาว");

    Kaopad k(2);
    k.setPrice(120);
    k.setMeatNum(1);
    k.setMeat(0,1);
    k.setVegNum(2);
    k.setVeg(0,"แครอท");
    k.setVeg(1,"ต้นหอม");


    //show info s&k

    double totalPriceS =s[0].getPrice() + s[1].getPrice();
    double totalPriceK =k.getPrice();
    cout << "Soup sum price : " << totalPriceS << endl;
    cout << "Kaopad price : " << totalPriceK << endl;
    int vegNum = s[0].getVegNum();
    string v[vegNum+1];
    for(int i=0;i<vegNum;i++){
        v[i] = s[0].getVeg(i).getName();
    }
    v[vegNum] = "เห็ด";
    vegNum++;
    s[0].setVegNum(vegNum);
    for(int i=0;i<vegNum;i++){
        s[0].setVeg(i, v[i]);
    }


    return 0;
}