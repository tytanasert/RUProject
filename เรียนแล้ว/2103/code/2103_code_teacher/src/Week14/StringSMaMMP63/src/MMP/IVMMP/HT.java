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
public class HT {
  Hashtable<String, Hashtable> table =new Hashtable<String, Hashtable>();
 
//  public boolean addPattern(String st,int pos, int terminate, int patternnumber){
//    System.out.println("test before insert: "+table.containsKey(st) +":"+st); 
//      if(table.containsKey(st)) { 
//          System.out.println("Stored Data: "+table.get(st));
//          String keysearch = String.valueOf(pos)+":"+String.valueOf(terminate);
//          HashSet temp=(HashSet)(((Hashtable)table.get(st)).get(keysearch));
//        //((HashSet)(((Hashtable)table.get(st)).get(keysearch))).add(patternnumber); //เพิ่มเข้าไปในเซต
//        System.out.println("Add:"+table.get(st));
//        System.out.println("Show temp:"+temp);
//        return true; 
//      }
//      else
//      {
//          Hashtable<String, HashSet> secondtable =new Hashtable<String, HashSet>();
//          table.put(st, secondtable);
//          HashSet setivl = new HashSet();
//          String keysecondtable  = String.valueOf(pos)+":"+String.valueOf(terminate);
//          setivl.add(patternnumber);
//          secondtable.put(keysecondtable, setivl);
//          System.out.println("Add:"+table.get(st));
//         return true;
//      }     
//  }
  
  public boolean addPattern(String st,int pos, int terminate, int patternnumber){
 //   System.out.println("test before insert: "+table.containsKey(st) +":"+st); 
    if(!table.containsKey(st)) { 
          Hashtable<String, HashSet> secondtable =new Hashtable<String, HashSet>();
          table.put(st, secondtable);
          HashSet setivl = new HashSet();
          String keysecondtable  = String.valueOf(pos)+":"+String.valueOf(terminate);
          setivl.add(patternnumber);
          secondtable.put(keysecondtable, setivl);
         // System.out.println("Add:"+table.get(st));
         return true;
    }
    else  
    if(table.containsKey(st)) { 
         // System.out.println("Stored Data: "+table.get(st));
          String keysearch = String.valueOf(pos)+":"+String.valueOf(terminate);
          if(((Hashtable)table.get(st)).containsKey(keysearch)){ //ถ้ามีkey แล้ว เช่นกรณี terminate 0,1 ตำแหน่งเดียวกัน
          //HashSet temp=(HashSet)(((Hashtable)table.get(st)).get(keysearch));
            ((HashSet)(((Hashtable)table.get(st)).get(keysearch))).add(patternnumber); //เพิ่มเข้าไปในเซต
          }else
          { //กรณียังไม่มี key 0;1
              HashSet setivl = new HashSet();
              String s = String.valueOf(pos)+":"+String.valueOf(terminate);
              setivl.add(patternnumber);
             ((Hashtable)table.get(st)).put(s, setivl);
          } 
      //  System.out.println("Add:"+table.get(st));
        //System.out.println("Show temp:"+temp);
        return true; 
      }
     return true; 
  }
  public Hashtable<String, Hashtable> getHT(){
      return table;
  }  
  
  public Hashtable<String, HashSet> getHTLevel2(String key){
      return table.get(key);
  }
}
