/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arrays;
import java.util.ArrayList;
/**
 *
 * @author ComSCIv3400
 */
public class ArrayList2_Delete {
    public static void main(String args[]){
        ArrayList myArray = new ArrayList();
        myArray.add(23);
        myArray.add(33);
        myArray.add(56);
        myArray.add(78);
        myArray.add(90);
        //show
        System.out.println("ข้อมูล ก่อนการลบ");
        for(int i=0;i<myArray.size();i++)
          System.out.println(myArray.get(i));
        
        myArray.remove(2);  //ลบข้อมูลรายการที่สาม
        System.out.println("ข้อมูล หลังการลบ");
        
        for(int i=0;i<myArray.size();i++)
          System.out.println(myArray.get(i));

    }
    
}
 