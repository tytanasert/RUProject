/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MMP.IVL;
//import Tester.*;
//import ddmfinal.IVLVectorBaseTop.*;
//import ddmfinal.IVLFastest.*;
import java.util.*;
/**
 *
 * @author user
 */
public class IVLverTwo {
    private static ArrayList pattern=new ArrayList();//=new ArrayList{"aab","aabc","aabcd"};
    private Vector IVLtableZero=new Vector();
    private Vector IVLtableOne=new Vector();
    public Vector getIVLtableZero() {
        return IVLtableZero;
    }
    //private HashSet a=new Hashtable();
    public Vector getIVLtableOne() {
        return IVLtableOne;
    }
    
    public IVLverTwo(){
        for(int i=0;i<=122;i++)
        {
            IVLtableZero.add(null);
            IVLtableOne.add(null);
        }
    }
    public void createTable(ArrayList patterns) throws Exception{
//        //for(int i=)
//        //pattern P={aab,aabc,aabcd}
//        patterns.add("aab");
//        patterns.add("aabc");
//        patterns.add("aabcd");
       /// patterns=pattern;
       // System.out.println("Pattern Number:"+patterns.size());
        for(int i=0;i<patterns.size();i++)
        {
           String temp=patterns.get(i).toString();
         //  System.out.println("temp:"+i+":"+temp);
           //((Hashtable)tablePiZero.get(temp.charAt(0))).size();
            for(int j=0;j<temp.length();j++)
            {
           //     try{                                        
//                   String terminate;  
              if(j==(temp.length()-1)) { //กรณีที่เป็นตัวสุดท้าย
                  try {
                     // System.out.println("temp.charAt:"+j+":"+temp.charAt(j)+":"+(int)temp.charAt(j));
                 if((Hashtable)IVLtableOne.get((int)temp.charAt(j))==null){ //กรณีที่ยังไม่มีอยู่
                   //  System.out.println("Null"+temp.charAt(j));
                     IVLtableOne.add((int)temp.charAt(j), new Hashtable());                                         
                     ((Hashtable)IVLtableOne.get((int)temp.charAt(j))).put(j+1,new HashSet());
                     ((HashSet)((Hashtable)IVLtableOne.get((int)temp.charAt(j))).get(j+1)).add(i+1);
                 }else
                   // dกรณีที่มีอยู่แล้ว แต่เพิ่ม :1
                  if(((Hashtable)IVLtableOne.get((int)temp.charAt(j))).get(j+1)==null){
                      ((Hashtable)IVLtableOne.get((int)temp.charAt(j))).put(j+1,new HashSet());
                     ((HashSet)((Hashtable)IVLtableOne.get((int)temp.charAt(j))).get(j+1)).add(i+1);
                  }   
                  else
                 { //กรณีที่มีอยู่แล้วทั้ง 0 และ 1
                     ((HashSet)((Hashtable)IVLtableOne.get((int)temp.charAt(j))).get(j+1)).add(i+1);                       
                 }
                     
                }catch(Exception e){}
                  //************ เพิ่มเข้าไปตารางที่ 0 ด้วย Version 2 เท่านั้น
                  try {
                 if((Hashtable)IVLtableZero.get((int)temp.charAt(j))==null){ //กรณีที่ยังไม่มีอยู่
//                     System.out.println("Null"+temp.charAt(j));
                     IVLtableZero.add((int)temp.charAt(j), new Hashtable());                                         
                     ((Hashtable)IVLtableZero.get((int)temp.charAt(j))).put(j+1,new HashSet());
                     ((HashSet)((Hashtable)IVLtableZero.get((int)temp.charAt(j))).get(j+1)).add(i+1);
                 }else
                    //dกรณีที่มีอยู่แล้ว แต่เพิ่มเพียงหมายเลขของแพทเทอร์นเท่านนั้น :1
                  if(((Hashtable)IVLtableZero.get((int)temp.charAt(j))).get(j+1)==null){
                      ((Hashtable)IVLtableZero.get((int)temp.charAt(j))).put(j+1,new HashSet());
                     ((HashSet)((Hashtable)IVLtableZero.get((int)temp.charAt(j))).get(j+1)).add(i+1);
                  }   
                  else
                 { //กรณีที่มีอยู่แล้วทั้ง 0 และ 1
                     ((HashSet)((Hashtable)IVLtableZero.get((int)temp.charAt(j))).get(j+1)).add(i+1);                       
                 }
                     
              }catch(Exception e){} // จบ Version 2 //
                  //************ จบส่วนของเพิ่มตาราง 0 กรณีเป็นตัวสุดท้าย
            } else //กรณีที่ไม่ใช่ตัวสุดท้าย
               
              try {
               //   System.out.println("temp.charAt:"+j+":"+temp.charAt(j)+":"+(int)temp.charAt(j));
                 if((Hashtable)IVLtableZero.get((int)temp.charAt(j))==null){ //กรณีที่ยังไม่มีอยู่
//                     System.out.println("Null"+temp.charAt(j));
                     IVLtableZero.add((int)temp.charAt(j), new Hashtable());                                         
                     ((Hashtable)IVLtableZero.get((int)temp.charAt(j))).put(j+1,new HashSet());
                     ((HashSet)((Hashtable)IVLtableZero.get((int)temp.charAt(j))).get(j+1)).add(i+1);
                 }else
                    //dกรณีที่มีอยู่แล้ว แต่เพิ่มเพียงหมายเลขของแพทเทอร์นเท่านนั้น :1
                  if(((Hashtable)IVLtableZero.get((int)temp.charAt(j))).get(j+1)==null){
                      ((Hashtable)IVLtableZero.get((int)temp.charAt(j))).put(j+1,new HashSet());
                     ((HashSet)((Hashtable)IVLtableZero.get((int)temp.charAt(j))).get(j+1)).add(i+1);
                  }   
                  else
                 { //กรณีที่มีอยู่แล้วทั้ง 0 และ 1
                     ((HashSet)((Hashtable)IVLtableZero.get((int)temp.charAt(j))).get(j+1)).add(i+1);                       
                 }
                     
              }catch(Exception e){System.out.println(e);}
                
                //***************    

          
//        }
//        for(int i=0;i<IVLtable.size();i++){
//            System.out.println(((char)i)+":"+IVLtable.elementAt(i));
        } //end internal for         
        
    }//end external for
       // System.out.println("Data:0:"+IVLtableZero);
       // System.out.println("Data:1:"+IVLtableOne);
    } //end method      
 
}//end program
