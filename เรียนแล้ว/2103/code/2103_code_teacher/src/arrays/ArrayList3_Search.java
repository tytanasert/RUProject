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
public class ArrayList3_Search {
    public static void main(String args[]){
        ArrayList myArray = new ArrayList();
        myArray.add(23);
        myArray.add(33);
        myArray.add(56);
        myArray.add(78);
        myArray.add(90);
        //show
        //myArray
        int loc = myArray.indexOf(56);
          System.out.println("พบที่ :"+loc); //พบ
          System.out.println("กรณีไม่พบ :"+ myArray.indexOf(156));
    }
    
}
 