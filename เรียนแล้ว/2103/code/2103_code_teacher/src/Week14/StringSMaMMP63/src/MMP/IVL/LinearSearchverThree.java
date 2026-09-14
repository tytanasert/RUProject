/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MMP.IVL;

//import SearchAlgo.FastMMP.*;
//import IVLTables.MMP.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author user
 */
public class LinearSearchverThree {
    static ArrayList result=new ArrayList();
    Set keepkey=new HashSet();
     int min_length=3,SHIFT,N,n;
     static int pos;
     static int count=0;
     
  public  void mainSearch(ArrayList p,String filetext,int size) throws Exception{
   IVLverTwo preprocess=new IVLverTwo();
   //ArrayList result=new ArrayList();
   //String text="testaabcdefaabaabc";
   Hashtable SET1=new Hashtable(), SET2=new Hashtable();//, SETE=new HashSet();
//   HashSet Temp=new HashSet();
//   Hashtable SETE=new Hashtable();
   long timebe,timeaf,t1=0,t2=0;
   char[] text=new char[size];
//   char[] text=new char[18];
//   for (int i=0;i<18;i++)
//       text[i]="testaabcdefaabaabc".charAt(i);
//////      //System.out.println("p:"+p);
//       p.clear();
//       p.add("aab");
//       p.add("aabc");
//       p.add("aabcd");

   try{
      text=GenerateText(filetext,size);
  //  System.out.println("Text:"+text+"text size:"+text.length);
   }catch(Exception e){System.out.println("text:"+e);}
       try{
           t1=System.nanoTime();
           preprocess.createTable(p);
           t2=System.nanoTime();
     //    System.out.println("Create Table OK:"+p);
       }catch(Exception e){System.out.println("table:"+e);}
    // System.out.println("after create table OK:");
     //  System.out.println("One:"+preprocess.getIVLtable());
//       System.out.println("Zero:"+preprocess.getTablePiZero());
   //    System.out.println("Text:"+text);
//       Set keyMap=new HashSet();    
//       int keepkeyPos=min_length;
//       int min_length=3,SHIFT,N,n;
       N=min_length-1; SHIFT=(2*min_length)-1; n=text.length;
     // System.out.println("Text length:"+text.length);
//       for(int i=0;i<min_length-1;i++){ //สร้าง key Map เอาไว้หาตำแหน่งของการทำงาน
//           keyMap.add(i);
//       }
//       Hashtable keepkey=new Hashtable();
       timebe=System.nanoTime();
//     System.out.println("Inverted lists in 'a':"+preprocess.getIVLtableZero().elementAt((int)'a'));
//     System.out.println("Inverted lists in 'b':"+preprocess.getIVLtableZero().elementAt((int)'b'));
//     System.out.println("Inverted lists in 'c':"+preprocess.getIVLtableZero().elementAt((int)'c'));
//     System.out.println("Inverted lists in 'd':"+preprocess.getIVLtableZero().elementAt((int)'d'));
//     System.out.println("Inverted lists in 'a':"+preprocess.getIVLtableOne().elementAt((int)'a'));
//     System.out.println("Inverted lists in 'b':"+preprocess.getIVLtableOne().elementAt((int)'b'));
//     System.out.println("Inverted lists in 'c':"+preprocess.getIVLtableOne().elementAt((int)'c'));
//     System.out.println("Inverted lists in 'd':"+preprocess.getIVLtableOne().elementAt((int)'d'));
     N=0; pos=1;
     //System.out.println("Befor Try");
     try{
      //   System.out.print("befor set SET1");
          SET1.putAll(keepSETbyPos((Hashtable)(preprocess.getIVLtableZero().elementAt((int)text[N])),pos));
     //   System.out.print("after set SET1");
          // System.out.println("text:"+N+":"+text[N]);            
        }catch(NullPointerException e){}  
     N++; //pos++;
//     System.out.println("Test befor loop.");
     while(N<text.length){
        // System.out.println("N in loop:"+N+" text[N]:"+text[N]+"  pos:"+pos+" SET1:"+SET1);
//         if(SET1.size()>0)
//             try{
//               checkingMatch(SET1,(Hashtable)(preprocess.getIVLtableOne().elementAt((int)text[N])),text[N],pos);
//              }catch(NullPointerException e){}
         if(SET1.size()>0){
             pos++;
//             SET2.clear();
//             System.out.println("text[N] before put to SET2:"+text[N]);
             try{
                 SET2.putAll(keepSETbyPos((Hashtable)(preprocess.getIVLtableZero().elementAt((int)text[N])),pos));
//                 System.out.println(" SET1 before intersect:"+SET1);
//                 System.out.println(" SET2 before intersect:"+SET2);
                 SET1=Intersection(SET1,SET2); //กรณีที่มีข้อมูลแล้ว
//                 if(SET1.size()==0){ //Overlap
//                    SET1.putAll(keepSETbyPos((Hashtable)(preprocess.getIVLtableZero().elementAt((int)text[N])),pos));
//                    pos=1; //กรณีที่ไม่มีข้อมูลแล้ว Overlap
//                 }
//                 System.out.println("  pos after intersect:"+pos+"  SET1:"+SET1);
                 }catch(NullPointerException e){}
         }else
         {
            pos=1;
//            System.out.println(" data before put ===>pos:"+pos+"text[N]:"+text[N]);
            try{
              SET1.putAll(keepSETbyPos((Hashtable)(preprocess.getIVLtableZero().elementAt((int)text[N])),pos));
              }catch(NullPointerException e){}               
         }
         if(pos>=min_length){//ลดจำนวนครั้งการตรวจสอบจะตรวจสอบเมื่อ pos>= min_length
           if(SET1.size()>0)
             try{
//               System.out.println("SET1 befor checking matched."+" pos:"+pos);
               checkingMatch(SET1,(Hashtable)(preprocess.getIVLtableOne().elementAt((int)text[N])),text[N],pos);
             }catch(NullPointerException e){}
         }  
         N++;
  }//end external while 1
     
      timeaf=System.nanoTime();
      System.out.println("Searching Time:"+(timeaf-timebe)); 
      System.out.println("Preprocessing Time:"+(t2-t1));
      //System.out.println("Table:"+preprocess.getIVLtableZero());
  } //end main
public static Hashtable keepSETbyPos(Hashtable set,int maxpos){
   // System.out.println("Befor : for in keepSET");
    Hashtable temp=new Hashtable();
   // Hashtable tempset=new Hashtable();
   // tempset.putAll(set);
   //System.out.println("Befor : for in keepSET"+temp);
    for(int i=1;i<=maxpos;i++){
      if(set.containsKey(i)){
         temp.put(i, set.get(i));   
      }
     // System.out.println("Keep SET befor sent to SETE or SET1:"+temp);          //    ;// .containsKey(set))  
    }
    return temp;
}  
 public static Hashtable Intersection(Hashtable A, Hashtable B){
     HashSet temp=new HashSet();
     Hashtable temptable=new Hashtable(); 
     //HashSet a=new HashSet(), b=new HashSet();
//     System.out.println("A:"+A+"   B:"+B);
     java.util.Iterator arrA,arrB;
     arrA = A.keySet().iterator();
     while(arrA.hasNext()){
         int i =(Integer)arrA.next();
         i++;
         temp.add(i);
     }
     temp.add(1); // แก้ไขเมื่อเวอร์ชัน 6
//     System.out.println("temp:"+temp);
     temp.retainAll(B.keySet());
//     System.out.println("Set B:"+B.keySet()+"  new temp:"+temp);
     arrB=temp.iterator();
//     System.out.println("arrB:"+arrB);
     while(arrB.hasNext()){         
         int i=(Integer)arrB.next();
         if(i==1)
             temptable.put(i,(HashSet)B.get(i));
         else{
//         System.out.println("round i:"+i);
         Set tempSet = new HashSet();
//         Set tempSet1 = new HashSet();
         try{
           tempSet.addAll((HashSet)A.get(i-1));
         }catch(NullPointerException e){}
//         tempSet1.addAll((HashSet)B.get(i));
//         System.out.println(" tempSet:"+tempSet+"  i:"+i+"  B.get(i):"+(HashSet)B.get(i));
         try{
         tempSet.retainAll((HashSet)B.get(i)); //แก้ใหม่เมื่อเวอร์ชัน 5
         }catch(NullPointerException e){}
//         System.out.println("tempSet aft:"+tempSet);
         if(tempSet.size()>0){
//              System.out.println("test tempSet>1"+tempSet.size());
              temptable.put(i,tempSet);
//              System.out.println("test tempSet>1:"+tempSet.size()+"temtable:"+temptable);
         }//end else
         }
     }
     if((temptable.size()==1)&&(temptable.keySet().contains(1))){
         pos=1; //กรณีโอเวอร์แลปต์
//         System.out.println("===>กรณีที่มีข้อมูลค้างใน SET1 แล้วไม่ Overlap"+pos+"   temptable:"+temptable);
     }
//     System.out.println("Test Befor retrun intersection:"+temptable+" size:"+temptable.size());
     return temptable;
 }
 public static void checkingMatch(Hashtable a,Hashtable b,char t,int p){ //ปรับปรุงใหม่เวอร์ขัน 3
    String r="";// 
    Hashtable tempSET=new Hashtable();
    tempSET.put(p,(HashSet)a.get(p));
    
//    System.out.println("set a:"+a);
//    System.out.println("tempSET:"+tempSET);
//    System.out.println("set b:"+b);
//    System.out.println("CheckingMatch===>text[n]:"+t);
//    System.out.println("CheckingMatch===>pos:"+p);
    if(b.keySet().contains(p)){
//        System.out.println("matched:"+t);
        HashSet t1=new HashSet();
     //   HashSet t2=new HashSet();
        t1.addAll((HashSet)a.get(p));
        t1.retainAll((HashSet)b.get(p));
        if(t1.size()>0)
            //r=r+":"+p+"  p:"+t1;
           // result.add(("match:"+t)); //เก็บผล
            count++;
       try{
          // if(a.size)
//           System.out.println("set1===>:"+((HashSet)a.get(p))+" setb==>"+b.get(p));
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
//    Set arrB=b.keySet();
////    System.out.println("key Set A:"+a.keySet()+"key Set B:"+b.keySet());
////    if(arrA.contains((Set)b.keySet())==true){
////     Set arrA=a.keySet();
//   //if((a.size()>1)||(!(a.contains(1))))  
//     java.util.Iterator arrA=a.keySet().iterator();
//     System.out.println("CheckingMatch===>SET1:"+a); 
//     System.out.println("CheckingMatch===>SET_one:"+b); 
//     System.out.println("CheckingMatch===>text[n]:"+t);
////     System.out.println("CheckingMatch===>pos:"+p);
//     while(arrA.hasNext()){
//         int i=(Integer)arrA.next();
//         if(arrB.contains(i)){
//             System.out.print("Data matched:"+a.get(i)+"   B:"+b.get(i));
//             Set temp=new HashSet();
//             try{
//                temp.addAll((HashSet)a.get(i)); 
//                try{
//                  temp.retainAll(((HashSet)b.get(i)));
//                }catch(ConcurrentModificationException e){}               
//              }catch(NullPointerException e){}               
//             
//            // temp..retainAll(((HashSet)b.get(i)).iterator());// ((HashSet)a.get(i)).
//             
//             System.out.println(" temp:"+temp);//values());
//             if(temp.size()>0) {
//                 r=r+":"+i+"p:"+temp.toString();
////                  if(((HashSet)a.get(i)).size()==1) a.remove(i); //ลบที่มีรายการเดียวเพื่อจะได้ออกไปลูปนอก
////                    System.out.println("(HahSet)a.get(i):===กรณีการ Match:"+(HashSet)a.get(i));
//             }
//         }//end if        
//     }//end while
////    }//end if
//     if(r.length()>0) result.add((r+":"+t));
//     System.out.println("Matched at:"+r);
   //  return tempSET;
 }//end checkingMatch
// public int farthermost(Set farthmost,int now){
//     int n=now-1;
//     while(!(farthmost.contains(n))&&(n>0)) n--;
//     return n;
// }//เมธอดนี้มีปัญหา
// public int nextfarthermost(Hashtable farthmost){     
//     Integer maxkey=0;
//     if(farthmost.size()>0){
//         maxkey =(Integer)Collections.max((HashSet)farthmost.get(0));
//         farthmost.remove(maxkey);
//     }
//     System.out.println("maxkey next:"+maxkey);
//     return maxkey;
// }

 //intersection ใหม่
//  public Hashtable IntersectionNew(Hashtable A, Hashtable B,Hashtable C){
//     Hashtable temp=new Hashtable();
//     HashSet a=new HashSet(), b=new HashSet();
// //    System.out.println("A:"+A);
//     java.util.Iterator arrA;
//     arrA = A.keySet().iterator();
//      a.addAll((HashSet)A.keySet());
//      b.addAll((HashSet)B.keySet());
//      
//    // System.out.println("arrA:"+A.keySet());
//    // System.out.println("B:"+B);
//     
//     try{
//        temp.put(0, B.get(0));
//     }catch(NullPointerException e){}
//     while(arrA.hasNext()){
//         int i=(Integer)arrA.next();
//         try{
//           if(B.get(i+1)!=null){
//             a.addAll((HashSet)A.get(i)); 
//             b.addAll((HashSet)B.get(i+1));
//             a.retainAll(b);
//             if(!a.isEmpty())
//                temp.put((i+1), a);
//            }  
//              HashSet aa=new HashSet();
//              aa.clear();
//              aa.addAll((HashSet)A.get(i));
//              aa.retainAll((HashSet)C.get(i+1));             
//             if(aa.size()>0){  //ตรวจสอบการ match                           
//      //         System.out.println("Matched OK.:"+C.get(i+1));
//               result.add(C.get(i+1));
//             }
//         }catch(NullPointerException e){}
//
//     }//endwhile
//    // System.out.println("Test Befor retrun intersection:"+temp);
//     return temp;
// }

 //**************************
     public char[] GenerateText(String Filename,int size) throws IOException{
        File fos;
        FileReader fileReader;
        BufferedReader reader;
//        String a="";
        char text[]=new char[size];
       try{
        fos = new File(Filename);
        fileReader= new FileReader(fos);
        reader = new BufferedReader(fileReader);  
//        text = new char[size];
        int count = 0;
        String value="!";
        while(value != null){
            value=reader.readLine();
           // System.out.println("value:"+value);
//            if(value!=null)
//            a = a+value;
            
            for(int i=0;i<value.length();i++){
              text[count] = value.charAt(i);
            //   System.out.println(text[count]); // �ʴ��ŷ��ͺ
              count++;
            }
        }
        fileReader.close();
       }catch(java.lang.Exception e) {}
        //if(a.length()>size); a=a.substring(0, size);
        return text;
    }   // End Generate Text in memory     
}
