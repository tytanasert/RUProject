/******************************************************************************

• รหัสนักศึกษา (ID) จำนวน 8 ตัวอักษร  (20 คะแนน)
• ชื่อ-นามสกุล (NAME) จำนวน 20 ตัวอักษร
• คณะ  (FAC)  1 = นิติศาสตร์   ,2 = วิทยาศาสตร์   ,3 = รัฐศาสตร์   ,4 = บริหารธุรกิจ
• อายุ (AGE) xx  ปี
จง

*******************************************************************************/





#include <iostream>
#include <cstring>
using namespace std;
struct STUDENT {
    char id[8];
    char name[20];
    int fac;
    int age;
};

int main()
{
    int choice;
    struct STUDENT    std[300] ;
    struct STUDENT    t;    
    int n=0,i;
    int sumlaw,sumsci,sumadm,sumpoli;
    int nlaw,nsci,nadm,npoli;
    sumlaw = sumsci = sumadm = sumpoli=0;
    nlaw  = nsci = nadm = npoli = 0;
    
    int cntFac[5] = {0,0,0,0,0};
    int sumAgeFac[5] = {0,0,0,0,0};
    while(true)
    {
        cout<<"1.get student info" << endl;
        // cout<<"2.compute average age " << endl;
        cout<<"3.exit " << endl;
        cin >> choice;
        if( choice==3) {
            break;
        }
        
        switch(choice) {
            case 1:
                    cout << "id = ";
                    cin >> t.id;
                    for(i=0; i < n ; i++) {
                        if( strcmp(t.id,std[i].id)==0) {
                            cout << "duplicate id" << endl;
                            break;
                        }
                    }
                   if(i==n ) {
                        cout << "name = ";
                        cin >> t.name;
                        cout << "fac = (1=law,2=sci,3.=poli,4=adm) ";
                        cin >> t.fac;
                        cout << "age = ";
                        cin >> t.age;
                        std[n] = t;
                        n++;
                   }
                        break;
                case 2:
                        for(i = 0 ; i < n ; i++) {
                            switch( std[i].fac ) {
                                case 1 : sumlaw = sumlaw + std[i].age;
                                         nlaw++;
                                         break;
                                case 2 : sumsci = sumsci + std[i].age;
                                         nsci++;
                                         break;
                                case 3 : sumpoli = sumpoli + std[i].age;
                                         npoli++;
                                         break;
                                case 4 : sumadm = sumadm + std[i].age;
                                         nadm++;
                                         break;
                                         
                            }
                        }
                        cout << "avg law  = " << float( sumlaw ) /nadm ;
                        cout << "avg sci  = " << float( sumsci )/nsci ;
                        cout << "avg poli = " << float( sumpoli )/npoli ;
                        cout << "avg adm  = " << float( sumadm )/nadm ;
                        
                        
                        break;
                case 3:
                    for(i = 0 ;i< n ;i++){
                        cntFac[std[i].fac ] = cntFac[std[i].fac ] + 1;
                        sumAgeFac[ std[i].fac ] = sumAgeFac[ std[i].fac ] + std[i].age;
                    }
                    cout << "avg law  = " << float( sumAgeFac[1] ) /cntFac[1] ;
                    cout << "avg sci  = " << float( sumAgeFac[2] ) /cntFac[2] ;
                    cout << "avg poli = " << float( sumAgeFac[3] ) /cntFac[3] ;
                    cout << "avg adm  = " << float( sumAgeFac[4] ) /cntFac[4] ;
                    break;
        } //switch    
    } //while
    return 0;
}
