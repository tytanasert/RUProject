/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trees;

/**
 *
 * @author ComSCIv3400
 */
public class Fig27Impl {
    
  public static void main(String args[]){
      //สร้างโนด และกำหนดข้อมูลแต่ละโนด
      Node A = new Node(); A.INFOR = "A";
      Node B = new Node(); B.INFOR = "B";
      Node C = new Node(); C.INFOR = "C";
      Node D = new Node(); D.INFOR = "D";
      Node E = new Node(); E.INFOR = "E";
      Node F = new Node(); F.INFOR = "F";
      Node G = new Node(); G.INFOR = "G";
      Node H = new Node(); H.INFOR = "H";
      Node J = new Node(); J.INFOR = "J";
      Node K = new Node(); K.INFOR = "K";
      Node L = new Node(); L.INFOR = "L";
      
      Node ROOT;  //กำหนดตัวแปร ROOT
      //เชื่อมโยงการใช้งานตามรูปภาพที่ 7-6
      A.LEFT = B; A.RIGHT = C;
      B.LEFT = D; B.RIGHT = E;
      E.LEFT = F;
      C.LEFT = G; C.RIGHT = H;
      H.LEFT = J; H.RIGHT = K;
      J.LEFT = L; 
      
      ROOT=A;  // กำหนดค่า Root ชี้ไปยังโนด A
      
  }  
    
    
}
