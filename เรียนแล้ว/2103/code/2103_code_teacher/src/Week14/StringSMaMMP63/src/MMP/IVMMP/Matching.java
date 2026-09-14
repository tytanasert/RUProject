/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MMP.IVMMP;

//import rearach60.sm.*;
import java.util.HashSet;
import java.util.Hashtable;

/**
 *
 * @author PC
 */
public class Matching {
   public static void main(String arg[]) {
//  HT ht = new HT();
//   // ht.createHT();
//    ht.addPattern("aaa", 1, 0);
//    ht.addPattern("bbb", 2, 0);
//    ht.addPattern("ccc", 3, 0);
//    ht.addPattern("aaa", 4, 1);

Preprocessing1 p = new Preprocessing1();
System.out.println("befor: Preprocessing:");
String P[]={"aaa", "bbb", "ccc"}; //non-overlap //patterns are equaled
HT mytable = p.createDS(P,3);
//        mytable.addPattern(P[0], 1, 1, 1);
//        mytable.addPattern(P[1], 1, 1, 2);
//        mytable.addPattern(P[2], 1, 1, 3);
        mytable.addPattern("aaa", 1, 0, 4);
        mytable.addPattern("bb", 2, 1, 4);
        System.out.println(mytable.getHT());
   //Hashtable myht = ht.getHT();
System.out.println("after: Preprocessing:");   

String texttest="aaabbbccceefgggaaabbbcccoooooooooooooooooooaaabbbccceefgggaaabbbccc";
   Hashtable<String,Hashtable> ht=p.getIVLHT();
//   TestmatchingAlgo(texttest, 3, ht, 3 ); //กรณีความยาวแพทเทิร์นเท่ากัน
int r[]={2};
  try{
   TestmatchingAlgo1(texttest, 3, ht, 3,r,1); //กรณีความยาวแพทเทิร์นไม่เท่ากัน
  }catch(Exception e){System.out.println(e);}
  // matchingAlgo1(texttest, 5, 4, myht, 5 );
} 

//กรณีลงตัวจำนวนความยาวเท่ากันพอดี   
public static void TestmatchingAlgo(String text,int c,Hashtable t, int patternLength){ 
      int pos=1, cur=pos,begin, end, terminate, j=0, matchwindow;
      System.out.println("table::"+t);
      while(j<=((text.length()-patternLength))){
          System.out.println("j="+j);
          pos=1; begin=j; end=begin+c; terminate=0; matchwindow=1;     //กำหนดค่าเริ่มต้น
          while(matchwindow==1){
              String st=text.substring(begin, end);  //ตัดแต่ละหน้าต่างย่อย             
             if(t.containsKey(st)){ //เทียบแล้วมีในตาราง
                  Hashtable<String,HashSet> h = (Hashtable)t.get(st);
                  HashSet A=(HashSet)h.get(String.valueOf(pos)+":1");
                  HashSet B=(HashSet)h.get(String.valueOf(pos)+":0");
                  if(A!=null){
                      System.out.println("เทียบตรง:"+st+":"+h.get(st));
                      System.out.println("Match here."+text.charAt(end-1));
                  }                       
                  if(B!=null){ //ตรวจสอบว่า match?
                        //กรณีเทียบแล้วพบ แต่ยังไม่ ,match
                     System.out.println("เทียบตรง:"+st+":"+t.get(st));
                     pos++;
                     begin+=c; end=begin+c;  
                     System.out.println(":1");
                  }else
                  {
                     matchwindow=0;
//                     begin+=c; end=begin+c;
//                     pos=1;
                     System.out.println(":2");
                  }   
                      
              }//else 
             {              
                j++;  //เลื่อนหน้าต่าง
                System.out.println(":3:textlength: "+text.length()+" :j"+j);
                //text.length()
                matchwindow=0;
             }
          }
      }
}

//กรณีไม่เท่ากันของแพทเทิร์น patternLength = max, min, 
public static void TestmatchingAlgo1(String text,int c,Hashtable t, int patternLength, int r[], int max){ 
      int pos=1, cur=pos,begin, end, terminate, j=0, matchwindow;
      while(j<=((text.length()-patternLength))){
          System.out.println("j="+j);
          pos=1; begin=j; end=begin+c; terminate=0; matchwindow=1;     //กำหนดค่าเริ่มต้น
          while(matchwindow==1){
              String st=text.substring(begin, end);  //ตัดแต่ละหน้าต่างย่อย             
             if(t.containsKey(st)){ //เทียบแล้วมีในตาราง
                  Hashtable<String,HashSet> h = (Hashtable)t.get(st);
                  HashSet A=(HashSet)h.get(String.valueOf(pos)+":1");
                  HashSet B=(HashSet)h.get(String.valueOf(pos)+":0");
                  if(A!=null){
                      System.out.println("เทียบตรง:"+st+":"+h.get(st)+"set of pattern:"+A);
                      System.out.println("Match here."+text.charAt(end-1));
                  }                       
                  if(B!=null){ //ตรวจสอบว่า match? ถ้ามีข้อมูลในเซต B
                        //กรณีเทียบแล้วพบ แต่ยังไม่ ,match
                     System.out.println("เทียบตรง:"+st+":"+t.get(st));
                     if(pos==max){ //ตรวจสอบว่า เท่ากับหน้าต่างสุดท้ายก่อนจะเอาตัวเศษมาพิจารณา
                         //การวนหาตัวเศษ ว่า match ที่ตัวใด 
                         //หา ตัว end + ค่าในตาราง r ทีละตัวหาว่ามีตัวสุดท้ายอยู่หรือไม่
                         Hashtable<String,HashSet> h1;
                         for(int m=0;m<r.length;m++){ //วนหาตัวแมท ในส่วนที่มีเศษของ pattern
                             String temp = text.substring(end, end+r[m]);
                             System.out.println("remainer:"+temp);
                             h1= (Hashtable)t.get(temp);
                             HashSet C=(HashSet)h1.get(String.valueOf(pos+1)+":1");
                             System.out.println("C="+C+ ":"+String.valueOf(pos+1)+":1");
                             if(C!=null) 
                                 System.out.println("Match at:"+temp+"pos:"+(pos+1)+"Pattern:"+C); //ตรวจสอบการ match
                             else
                                 System.out.println("มีปัญหา  at:"+temp);
                         }//จบการวนหาเศษ
                     }            
                     else  //กรณีไม่มีเศษ
                     { //กรณีที่ยังไม่ถึงหน้าต่างสุดท้ายก่อนหาตัวเศษ   
                        pos++;
                        begin+=c; end=begin+c;  
                     }  
                     System.out.println(":1");
                  }else
                  {
                     matchwindow=0;
//                     begin+=c; end=begin+c;
//                     pos=1;
                     System.out.println(":2");
                  }   
                      
              }//else 
             {              
                j++;  //เลื่อนหน้าต่าง
                System.out.println(":3:textlength: "+text.length()+" :j"+j);
                //text.length()
                matchwindow=0;
             }
          }
      }
}
//
//    public static void matchingAlgo(String text,int c,Hashtable t, int patternLength){
//        
//      int pos, begin, end, terminate, j=0, matchwindow;
//      
//      while(j<=text.length()-(c*patternLength)){
//          pos=1; begin=j; end=begin+c; terminate=0; matchwindow=1;     //กำหนดค่าเริ่มต้น
//         while(matchwindow==1){               //ลูปใน
//              String st=text.substring(begin, end);  //ตัดแต่ละหน้าต่างย่อย             
//             if(t.containsKey(st)){ //เทียบแล้วมีในตาราง
//                  HashSet h = (HashSet)t.get(st);
//                  if(h.contains(String.valueOf(pos)+":"+String.valueOf(terminate))){
//                      if(terminate==1){ //ตรวจสอบว่า match?
//                          System.out.println("เทียบตรง:"+st+":"+t.get(st));
//                          System.out.println("Match here."+text.charAt(end-1)); 
//                          matchwindow=0;
//                      }else
//                      { //กรณีเทียบแล้วพบ แต่ยังไม่ ,match
//                          System.out.println("เทียบตรง:"+st+":"+t.get(st));
//                          pos++;
//                          begin+=c; end=begin+c;
//                          if(pos==(patternLength)) terminate=1;
//                      }
//                      
//                  } else // เทียบแล้วไม่ตรง กรณีมี แต่ไม่ไม่มีในการต่อเนื่อง 
//                      matchwindow=0;
//                    
//             }else
//             { //เทียบแล้วไม่มีในตาราง
//               matchwindow=0;  //ออกจาก while หน้าต่างการค้นหา
//             }
//             System.out.println("Loop ในหลังการวน"+ matchwindow);
//          }  //end while     
//          j++;
//          System.out.println("external loop:"+j);
//       } //end first for     
//  } //end search
//    public static void matchingAlgo1(String text,int c,int r, Hashtable t, int patternLength){
//      int pos, begin, end, terminate, j=0, matchwindow;
//      
//      while(j<=text.length()-(c*patternLength)+r){
//          pos=1; begin=j; end=begin+c; terminate=0; matchwindow=1;     //กำหนดค่าเริ่มต้น
//         while(matchwindow==1){               //ลูปใน
//              String st=text.substring(begin, end);  //ตัดแต่ละหน้าต่างย่อย             
//             if(t.containsKey(st)){ //เทียบแล้วมีในตาราง
//                  HashSet h = (HashSet)t.get(st);
//                  if(h.contains(String.valueOf(pos)+":"+String.valueOf(terminate))){
//                      if(terminate==1){ //ตรวจสอบว่า match?
//                          System.out.println("เทียบตรง:"+st+":"+t.get(st));
//                          System.out.println("Match here."+text.charAt(end-1)); 
//                          matchwindow=0;
//                      }else
//                      { //กรณีเทียบแล้วพบ แต่ยังไม่ ,match
//                          System.out.println("เทียบตรง:"+st+":"+t.get(st));
//                          pos++;                          
//                          begin+=c; end=begin+c;
//                          if(pos==(patternLength)){ 
//                              terminate=1;
//                              if(r>0) end=begin+r;
//                          }
//                      }
//                      
//                  } else // เทียบแล้วไม่ตรง กรณีมี แต่ไม่ไม่มีในการต่อเนื่อง 
//                      matchwindow=0;
//                    
//             }else
//             { //เทียบแล้วไม่มีในตาราง
//               matchwindow=0;  //ออกจาก while หน้าต่างการค้นหา
//             }
//             System.out.println("Loop ในหลังการวน"+ matchwindow);
//          }  //end while     
//          j++;
//          System.out.println("external loop:"+j);
//       } //end first for     
//  } //end search
    
}//end class