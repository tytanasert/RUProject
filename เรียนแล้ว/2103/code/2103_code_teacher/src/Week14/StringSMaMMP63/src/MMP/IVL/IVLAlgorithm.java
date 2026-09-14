package MMP.IVL;
import java.util.*;
import java.io.*;
public class IVLAlgorithm {    
    Set keepkey=new HashSet();
    int N,n;
    int pos;
    IVLTable preprocess=new IVLTable();
    
     public  void IVLSearch(String P[],String text) throws Exception{
   Hashtable SET1=new Hashtable(), SET2=new Hashtable();//, SETE=new HashSet();
       //------ PreProcessing ------------
           preprocess.createTable(P);
       //------- Searching ---------------
      n=text.length();
      int min_length=calculatelmin(P); 
      N=0; pos=1;
     try{
          SET1.putAll(keepSETbyPos((Hashtable)(preprocess.getIVLtableZero().elementAt((int)text.charAt(N))),pos));
        }catch(NullPointerException e){}  
     N++; //pos++;
     while(N<n){
         if(SET1.size()>0){
             pos++;
             try{
                 SET2.putAll(keepSETbyPos((Hashtable)(preprocess.getIVLtableZero().elementAt((int)text.charAt(N))),pos));
                 SET1=Intersection(SET1,SET2); //กรณีที่มีข้อมูลแล้ว
                 }catch(NullPointerException e){}
         }else
         {
            pos=1;
            try{
              SET1.putAll(keepSETbyPos((Hashtable)(preprocess.getIVLtableZero().elementAt((int)text.charAt(N))),pos));
              }catch(NullPointerException e){}               
         }
         if(pos>=min_length){//ลดจำนวนครั้งการตรวจสอบจะตรวจสอบเมื่อ pos>= min_length
           if(SET1.size()>0)
             try{
               checkingMatch(SET1,
                       (Hashtable)(preprocess.getIVLtableOne().elementAt((int)text.charAt(N))),
                       text.charAt(N),pos, text.substring(N-pos+1, N+1), (N+1));
             }catch(NullPointerException e){}
         } 
         N++;
  }//end external while 1     
  } //end main
     //------------------------
     public int calculatelmin(String p[]){
        int lm=999;
        for(int i=0;i<p.length;i++){
            if(lm>p[i].length())
            lm = p[i].length();
        }
        return lm;
    }

public  Hashtable keepSETbyPos(Hashtable set,int maxpos){
    Hashtable temp=new Hashtable();
    for(int i=1;i<=maxpos;i++){
      if(set.containsKey(i)){
         temp.put(i, set.get(i));   
      }
    }
    return temp;
}  
 public Hashtable Intersection(Hashtable A, Hashtable B) {
     HashSet temp=new HashSet();
     Hashtable temptable=new Hashtable(); 
     java.util.Iterator arrA,arrB;
     arrA = A.keySet().iterator();
     while(arrA.hasNext()){
         int i =(Integer)arrA.next();
         i++;
         temp.add(i);
     }
     temp.retainAll(B.keySet());
     arrB=temp.iterator();
     while(arrB.hasNext()){         
         int i=(Integer)arrB.next();
         if(i==1)
             temptable.put(i,(HashSet)B.get(i));
         else{
         Set tempSet = new HashSet();
         try{
           tempSet.addAll((HashSet)A.get(i-1));
         }catch(NullPointerException e){}
         try{
         tempSet.retainAll((HashSet)B.get(i)); //แก้ใหม่เมื่อเวอร์ชัน 5
         }catch(NullPointerException e){}
         if(tempSet.size()>0){
              temptable.put(i,tempSet);
         }//end else
         }
     }
     if((temptable.size()==1)&&(temptable.keySet().contains(1))){
         pos=1; //กรณีโอเวอร์แลปต์
     }
     return temptable;
 }
 
 public static void checkingMatch(Hashtable a,Hashtable b,char t,int p, String s, int n) throws NullPointerException{ //ปรับปรุงใหม่เวอร์ขัน 3
    String r="";// 
    Hashtable tempSET=new Hashtable();
    tempSET.put(p,(HashSet)a.get(p));
    if(b.keySet().contains(p)){
        System.out.println("ค้นพบตำแหน่งที่:"+n +" อักขระแบบ:"+s);
        HashSet t1=new HashSet();
        t1.addAll((HashSet)a.get(p));
        t1.retainAll((HashSet)b.get(p));
       try{
           try{
            java.util.Iterator rm=((HashSet)b.get(p)).iterator();
            if(((HashSet)a.get(p)).size()==1) 
                a.remove(p);
            else
            while(rm.hasNext()){
                ((HashSet)a.get(p)).remove((Integer)rm.next());
            }
           }catch (NullPointerException e){}                         
       }catch(NullPointerException e){}               
    }
 }//end checkingMatch
}
