package MMP.IVL;
import java.util.*;
public class IVLTable {
    private static ArrayList pattern=new ArrayList();//=new ArrayList{"aab","aabc","aabcd"};
    private Vector IVLtableZero=new Vector();
    private Vector IVLtableOne=new Vector();
    public Vector getIVLtableZero() {
        return IVLtableZero;
    }
    public Vector getIVLtableOne() {
        return IVLtableOne;
    }    
    public IVLTable(){
        for(int i=0;i<=122;i++)
        {
            IVLtableZero.add(null);
            IVLtableOne.add(null);
        }
    }
    public void createTable(String P[]) throws Exception{
       // ArrayList patterns=new ArrayList();
        for(int i=0;i<P.length;i++) pattern.add(P[i]);
        for(int i=0;i<pattern.size();i++)
        {
           String temp=pattern.get(i).toString();
            for(int j=0;j<temp.length();j++)
            {
              if(j==(temp.length()-1)) { //กรณีที่เป็นตัวสุดท้าย
                  try {
                 if((Hashtable)IVLtableOne.get((int)temp.charAt(j))==null){ //กรณีที่ยังไม่มีอยู่
                     IVLtableOne.add((int)temp.charAt(j), new Hashtable());                                         
                     ((Hashtable)IVLtableOne.get((int)temp.charAt(j))).put(j+1,new HashSet());
                     ((HashSet)((Hashtable)IVLtableOne.get((int)temp.charAt(j))).get(j+1)).add(i+1);
                 }else
                   //กรณีที่มีอยู่แล้ว แต่เพิ่ม :1
                  if(((Hashtable)IVLtableOne.get((int)temp.charAt(j))).get(j+1)==null){
                      ((Hashtable)IVLtableOne.get((int)temp.charAt(j))).put(j+1,new HashSet());
                     ((HashSet)((Hashtable)IVLtableOne.get((int)temp.charAt(j))).get(j+1)).add(i+1);
                  }   
                  else
                 { //กรณีที่มีอยู่แล้วทั้ง 0 และ 1
                     ((HashSet)((Hashtable)IVLtableOne.get((int)temp.charAt(j))).get(j+1)).add(i+1);                       
                 }
                     
                }catch(Exception e){}
                  //************ เพิ่มเข้าไปตารางที่ 0 ด้วย 
                  try {
                 if((Hashtable)IVLtableZero.get((int)temp.charAt(j))==null){ //กรณีที่ยังไม่มีอยู่
                     IVLtableZero.add((int)temp.charAt(j), new Hashtable());                                         
                     ((Hashtable)IVLtableZero.get((int)temp.charAt(j))).put(j+1,new HashSet());
                     ((HashSet)((Hashtable)IVLtableZero.get((int)temp.charAt(j))).get(j+1)).add(i+1);
                 }else
                    //กรณีที่มีอยู่แล้ว แต่เพิ่มเพียงหมายเลขของแพทเทอร์นเท่านนั้น :1
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
                 if((Hashtable)IVLtableZero.get((int)temp.charAt(j))==null){ //กรณีที่ยังไม่มีอยู่
                     IVLtableZero.add((int)temp.charAt(j), new Hashtable());                                         
                     ((Hashtable)IVLtableZero.get((int)temp.charAt(j))).put(j+1,new HashSet());
                     ((HashSet)((Hashtable)IVLtableZero.get((int)temp.charAt(j))).get(j+1)).add(i+1);
                 }else
                    //กรณีที่มีอยู่แล้ว แต่เพิ่มเพียงหมายเลขของแพทเทอร์นเท่านนั้น :1
                  if(((Hashtable)IVLtableZero.get((int)temp.charAt(j))).get(j+1)==null){
                      ((Hashtable)IVLtableZero.get((int)temp.charAt(j))).put(j+1,new HashSet());
                     ((HashSet)((Hashtable)IVLtableZero.get((int)temp.charAt(j))).get(j+1)).add(i+1);
                  }   
                  else
                 { //กรณีที่มีอยู่แล้วทั้ง 0 และ 1
                     ((HashSet)((Hashtable)IVLtableZero.get((int)temp.charAt(j))).get(j+1)).add(i+1);                       
                 }                     
              }catch(Exception e){System.out.println(e);}                
        } //end internal for         
        
    }//end external for
    } //end method       
}//end program
