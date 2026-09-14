/*
 * PreprocessingPhrase.java
 *
 * Created on 17 �ԧ�Ҥ� 2547, 10:44 �.
 */

package MMP.IVL;
import java.util.ArrayList;
import java.util.Vector;
import java.io.*;
/**
 *
 * @author  user
 */
public class PreprocessingPhraseforSearch551 {   
    ArrayList data = new ArrayList();
    public ArrayList loadText(int endcount, String filename) throws IOException{
        File fos = new File(filename); //File("c://MyResearch/Implementation/textrec.txt");
        FileReader fileReader= new FileReader(fos);
        BufferedReader reader = new BufferedReader(fileReader);
        for(int i=0;i<endcount;i++)
           data.add(reader.readLine());
        fileReader.close();
        return data;
}
//    public ArrayList CreatePattern(int num_pattern,String filename){
//        String []pattern = new String[num_pattern];
//     /*
//      *   ����� pattern ����tŧ�����躹˹��¤��h�
//      */
//      MyUrl my = new MyUrl();
//      DBDirect Conn = new DBDirect();
//      java.sql.Connection Trans
//                = Conn.Connect(my.MyUrl()+"/Thesis", my.MyUser(),my.MyPassWord());
//        try
//        {
//
//                    Trans.setAutoCommit(false);
//    //                RandomText a = new RandomText();
//                    String SQL = "SELECT pattern FROM "+filename;
//                    java.sql.ResultSet rs = Conn.SQLRetrive(SQL);
//                    int rec=0;
//                    int i=0;
//                   if(rs.first()){
//                      while(i<num_pattern){
//                         // pattern[rec] = rs.getString("pattern");
//                         // System.out.println("Test Read to memory:"+rec +":"+pattern[rec]);                          rec++;
//                           data.add(rs.getString("pattern"));
//                          rs.next();
//                          i++;
//
//                      }
//                   }else {
//                        Conn.Close(Trans);
//                        javax.swing.JOptionPane.showMessageDialog(null,
//                        "����բ�����","��سҵ�Ǩ�ͺ",
//                        javax.swing.JOptionPane.ERROR_MESSAGE);
//                   }
//                  Conn.Close(Trans);
//
//        }catch(java.sql.SQLException ex2){
//                javax.swing.JOptionPane.showMessageDialog(null,
//                ex2.getMessage(),"�ѹ�֡��������",
//                javax.swing.JOptionPane.ERROR_MESSAGE);
//        }
//   //   System.out.println("Data"+data);
//   // ��ǹ�ͧ��� Generate Node ����t
//     // ��ǹ�ͧ������ҧ Trie
//
//     //****  เริ่มคำนวณ ***
////      long beforTime,afterTime;
////      IVLTable1 testTable = new IVLTable1();
////      System.out.println("เริ่มการทำงาน");
////      beforTime=System.nanoTime();
////      try{
////        testTable.createTable(data);
////      }catch(Exception e){System.out.println("Error:"+e);}
////       afterTime=System.nanoTime();
////       System.out.println("เวลาประมวลผล = "+(afterTime-beforTime));
////      //***** จบการคำรวณ ***
//      return data;
//    }

    public ArrayList getData() {
        return data;
    }
    
}
