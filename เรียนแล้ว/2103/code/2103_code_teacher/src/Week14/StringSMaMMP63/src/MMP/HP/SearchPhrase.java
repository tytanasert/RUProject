/*
 * SearchPhrase.java
 *
 * Created on 29 �ԧ�Ҥ� 2547, 22:18 �.
 * Last update 29 �ѹ��¹ 2547,10.20 �.
 */

package MMP.HP;
import java.io.*;

/**
 *
 * @author  user
 */
public class SearchPhrase {       
   public char []text;  
   int MAXX=100000,MAXTEXT=100000;
//   int flag1=0,flag2=0,countset1=-1,countset2=-1,countset3=-1,countset4=-1;
//   int pos1=0,pos2=0,countfound=-1,count1=-1;
//   int SHIFT=2,N1=0,N2=1;
   int indexfound=0;

   //SLNode SET1,SET2,SET3,SET4; 
   int FoundPost[][] =new int[MAXTEXT][3];
   char CharFound[] = new char[MAXTEXT];
//   int temp[][] = new int[MAXX][3];
//   int counttemp =0;

   //SLinkedList temp1,temp2;
   PreprocessingPhrase pattern;
    /** Creates a new instance of SearchPhrase */
    public SearchPhrase() {
      pattern = new PreprocessingPhrase();  // ���ҧ pattern ��ѡ�ͧ����ѡ��� 52 ���
    }
    public void GenerateText(String Filename,int size) throws IOException{
        File fos;
        FileReader fileReader;
        BufferedReader reader;      
       try{
        fos = new File(Filename);
        fileReader= new FileReader(fos);
        reader = new BufferedReader(fileReader);  
        text = new char[size];
        int count = 0;
        String value="!";
        while(value != null){
            value = reader.readLine();
            for(int i=0;i<value.length();i++){
              text[count] = value.charAt(i);
          //     System.out.println(text[count]); // �ʴ��ŷ��ͺ
              count++;
            }
        }
        fileReader.close();
       }catch(java.lang.Exception e) {}
    }   // End Generate Text in memory
    public void mainSearch(int numPattern,int lengtPattern,String filePattern,String textFile,int textSize,int cal) throws IOException{
        int timecount=0,numCal;
        numCal=cal;
        long t1, t2;
        //DataNode SET1,SET2,SET3,SET4,temp1,temp2;        
        try{
            t1=System.nanoTime();
            pattern.CreatePattern(numPattern,lengtPattern,filePattern);  // Create pattern
             t2=System.nanoTime();
           // pattern.ShowDataNode();
            //pattern.ShowDataRoot();
            //pattern.ShowdTable();
            GenerateText(textFile,textSize);    // Generate Text in memory
           // countset1= StoreSet(SET1,pos1,countset1); // single Search
            timecount++;
            //*************  ��ǹ�ͧ��èѺ���� *********
//                MyUrl my = new MyUrl();
//                DBConnect a = new DBConnect();     
//                java.sql.Connection conn=a.DBConnect(my.MyUrl()+"/Thesis", my.MyUser(), my.MyPassWord());        
                long beforTime[]=new long[7],afterTime[]=new long[7],avg=0;
         ///        for(int i=0;i<7;i++){
                  beforTime[1]=System.nanoTime();//.currentTimeMillis();  // �����ҡ�͹��äӹǳ
            //***************************************
            int flag=0,lmin=lengtPattern;
            //int indexfound=0;
            DataNode Current=null,temprow=null,initialNode=new DataNode();
            int pos=lmin-1;
           while(pos<textSize)  //��ǹ��ä�����ѡ
           { 
               int j=0; 
                  Current=(DataNode)RoFunction(0,text[pos],Current,pos);
               j++;  //�ա�äӹǳ���Ǥ���˹��
               while( ((pos-j)>=0) && Current!=null ){//end while             {//(DataNode)RoFunction(1,text[pos-j],Current,pos-j)!=null){ 
                      if(RoFunction(1,text[pos-j],Current,pos-j)!=null)
                         Current = (DataNode)RoFunction(1,text[pos-j],Current,pos-j);
                      if(Current !=null) 
                      if(Current.getTerminate()==1) //set Mark founded state
                       {
                          if(indexfound<MAXTEXT){
                           FoundPost[indexfound][0]=pos;
                           FoundPost[indexfound][1]=lengtPattern;
                           CharFound[indexfound] = text[pos];
                          }
                           indexfound++;
                           flag=0;
                           Current=null;
                       }                           

                        j++;
               }//while( ((pos-j)>=0) &&(Current.getNextLink()!=null) );//end while  
               pos = pos+pattern.dTable[caseNode(text[pos])];
           }//end while    
            //**************** ��ǹ��èѺ���� *******************
               afterTime[1]=System.nanoTime();//.currentTimeMillis();            
               long val[]= new long[7];
              avg=afterTime[1]-beforTime[1];//avg/7;
              System.out.println("Searching Time = "+avg);
              System.out.println("Preprocessing Time = "+(t2-t1));
        }catch(java.lang.NullPointerException e){
            System.out.println("Error ="+e);
          }  
        // �� main search 
 
    }
    //*********** function ro Current ***
   public Object RoFunction(int i,char tpos,Object o,int poscal)  // ��Ǩ�ͺ��÷�ͧ� ro �ѧ��ѹ���t
   {
       Object now=null;  // index ��Ǥ���
       boolean found=false;
      try{ 
       if(i==0){   //�鹷�� root 
                 int k=0;
                 found =false;
                 //if()
                 while(k<pattern.root.getLink().size()){
                     DataNode a = (DataNode)pattern.root.getLink().elementAt(k); 
                   //  System.out.println("Data traversal in root :"+a.getData());
                     if(a.getData() == tpos){   // ��Ҿ�
                     //   System.out.println("����Ƿ������͹�ѹ��� :"+a.getData()+a.getState());
                        now = a;//root.getLink().elementAt(k); 
                       // a.getState();
                        k=pattern.root.getLink().size();
                        found=true;
                     }
                     else{
                       k++;
                     }
                 }   
             //    if(found==false) now=null;
         }
         else  // �óշ���������˹觷�� root */
         {
             //System.out.println("o object ��͹��äԴ :"+((DataNode)(((DataNode)o).getNextLink()).elementAt(0)).getData()+" State :"+((DataNode)o).getState()+" Terminate :"+((DataNode)o).getTerminate());
             if(o!=null){  //��Ǩ�ͺ�ҡ�繤�� null �����ӧҹ ���Шз�����Դ exception
               int l=0;
                    int k=0; 
                 //   if(poscal == 0){ 
                 //       now = o; 
                 //       System.out.println("data : when poscal=0  ::"+((DataNode)now).getState());
                  //  }
                  //  else{
                    while(k<((DataNode)o).getNextLink().size()){  
                       //   System.out.println("��Ҵ��� :"+((DataNode)o).getNextLink().size());
                          DataNode a = (DataNode)((DataNode)o).getNextLink().elementAt(k);
                       //   System.out.println("Data traversal :"+a.getData()+"char Search :"+tpos); 
                          if((a.getData()) == tpos ){   // ��Ҿ�
                         //    System.out.println("����Ƿ������͹�ѹ��� :"+a.getData()+" State :"+a.getState()+"  Terminate :"+a.getTerminate());
                             // System.out.println("Data traversal :"+a.getData()+"char Search :"+tpos); 
                             now = a; //((DataNode)o).getNextLink().elementAt(k);  
                             k=((DataNode)o).getNextLink().size();
                             found=true;
                             //*************************
                          }
                          else
                              k++;
                          //    now = null;   // �����辺
                       } //end while
            // if(found==false) {now=((DataNode)o).getBackLink();  System.out.println("false");}   
               //     }     
             }      
         }
      }catch(Exception e){System.out.println("Error Ro function :"+e);}  
       //System.out.println("now befor return "+((DataNode)now).getState());
     return now;
   } 

    //******************************
    // ��Ǩ�ͺ������ѡ������Ш��������˹��ԧ���
   private int caseNode(String char_pattern){
        char ch='$';
        
        int gonode=0;
           if( char_pattern.compareTo("A")==0) gonode=1; else
           if(char_pattern.compareTo("a")==0) gonode=2; else
           if(char_pattern.compareTo("B")==0) gonode=3; else
           if(char_pattern.compareTo("b")==0) gonode=4; else
           if(char_pattern.compareTo("C")==0) gonode=5; else    
           if(char_pattern.compareTo("c")==0) gonode=6; else
           if(char_pattern.compareTo("D")==0) gonode=7; else
           if(char_pattern.compareTo("d")==0) gonode=8; else
           if(char_pattern.compareTo("E")==0) gonode=9; else
           if(char_pattern.compareTo("e")==0) gonode=10; else    
           if(char_pattern.compareTo("F")==0) gonode=11; else
           if(char_pattern.compareTo("f")==0) gonode=12; else
           if(char_pattern.compareTo("G")==0) gonode=13; else
           if(char_pattern.compareTo("g")==0) gonode=14; else
           if(char_pattern.compareTo("H")==0) gonode=15; else    
           if(char_pattern.compareTo("h")==0) gonode=16; else
           if(char_pattern.compareTo("I")==0) gonode=17; else
           if(char_pattern.compareTo("i")==0) gonode=18; else
           if(char_pattern.compareTo("J")==0) gonode=19; else
           if(char_pattern.compareTo("j")==0) gonode=20; else    
           if(char_pattern.compareTo("K")==0) gonode=21; else
           if(char_pattern.compareTo("k")==0) gonode=22; else
           if(char_pattern.compareTo("L")==0) gonode=23; else
           if(char_pattern.compareTo("l")==0) gonode=24; else
           if(char_pattern.compareTo("M")==0) gonode=25; else    
           if(char_pattern.compareTo("m")==0) gonode=26; else
           if(char_pattern.compareTo("N")==0) gonode=27; else
           if(char_pattern.compareTo("n")==0) gonode=28; else
           if(char_pattern.compareTo("O")==0) gonode=29; else
           if(char_pattern.compareTo("o")==0) gonode=30; else    
           if(char_pattern.compareTo("P")==0) gonode=31; else
           if(char_pattern.compareTo("p")==0) gonode=32; else
           if(char_pattern.compareTo("Q")==0) gonode=33; else
           if(char_pattern.compareTo("q")==0) gonode=34; else
           if(char_pattern.compareTo("R")==0) gonode=35; else    
           if(char_pattern.compareTo("r")==0) gonode=36; else
           if(char_pattern.compareTo("S")==0) gonode=37; else
           if(char_pattern.compareTo("s")==0) gonode=38; else
           if(char_pattern.compareTo("T")==0) gonode=39; else
           if(char_pattern.compareTo("t")==0) gonode=40; else    
           if(char_pattern.compareTo("U")==0) gonode=41; else
           if(char_pattern.compareTo("u")==0) gonode=42; else
           if(char_pattern.compareTo("V")==0) gonode=43; else
           if(char_pattern.compareTo("v")==0) gonode=44; else
           if(char_pattern.compareTo("W")==0) gonode=45; else    
           if(char_pattern.compareTo("w")==0) gonode=46; else
           if(char_pattern.compareTo("X")==0) gonode=47; else
           if(char_pattern.compareTo("x")==0) gonode=48; else
           if(char_pattern.compareTo("Y")==0) gonode=49; else
           if(char_pattern.compareTo("y")==0)gonode=50; else    
           if(char_pattern.compareTo("Z")==0) gonode=51; else
           if(char_pattern.compareTo("z")==0) gonode=52; else 
           if(char_pattern.compareTo("0")==0) gonode=53; else
           if(char_pattern.compareTo("1")==0) gonode=54; 

           return gonode-1;   
    }
//********************************
      private int caseNode(char char_pattern){      
        int gonode=0;
           if( char_pattern == 'A') gonode=1; else
           if(char_pattern == 'a') gonode=2; else
           if(char_pattern == 'B') gonode=3; else
           if(char_pattern == 'b') gonode=4; else
           if(char_pattern == 'C') gonode=5; else    
           if(char_pattern == 'c') gonode=6; else
           if(char_pattern == 'D') gonode=7; else
           if(char_pattern == 'd') gonode=8; else
           if(char_pattern == 'E') gonode=9; else
           if(char_pattern == 'e') gonode=10; else    
           if(char_pattern == 'F') gonode=11; else
           if(char_pattern == 'f') gonode=12; else
           if(char_pattern == 'G') gonode=13; else
           if(char_pattern == 'g') gonode=14; else
           if(char_pattern == 'H') gonode=15; else    
           if(char_pattern == 'h') gonode=16; else
           if(char_pattern == 'I') gonode=17; else
           if(char_pattern == 'i') gonode=18; else
           if(char_pattern == 'J') gonode=19; else
           if(char_pattern == 'j') gonode=20; else    
           if(char_pattern == 'K') gonode=21; else
           if(char_pattern == 'k') gonode=22; else
           if(char_pattern == 'L') gonode=23; else
           if(char_pattern == 'l') gonode=24; else
           if(char_pattern == 'M') gonode=25; else    
           if(char_pattern == 'm') gonode=26; else
           if(char_pattern == 'N') gonode=27; else
           if(char_pattern == 'n') gonode=28; else
           if(char_pattern == 'O') gonode=29; else
           if(char_pattern == 'o') gonode=30; else    
           if(char_pattern == 'P') gonode=31; else
           if(char_pattern == 'p') gonode=32; else
           if(char_pattern == 'Q') gonode=33; else
           if(char_pattern == 'q') gonode=34; else
           if(char_pattern == 'R') gonode=35; else    
           if(char_pattern == 'r') gonode=36; else
           if(char_pattern == 'S') gonode=37; else
           if(char_pattern == 's') gonode=38; else
           if(char_pattern == 'T') gonode=39; else
           if(char_pattern == 't') gonode=40; else    
           if(char_pattern == 'U') gonode=41; else
           if(char_pattern == 'u') gonode=42; else
           if(char_pattern == 'V') gonode=43; else
           if(char_pattern == 'v') gonode=44; else
           if(char_pattern == 'W') gonode=45; else    
           if(char_pattern == 'w') gonode=46; else
           if(char_pattern == 'X') gonode=47; else
           if(char_pattern == 'x') gonode=48; else
           if(char_pattern == 'Y') gonode=49; else
           if(char_pattern == 'y')gonode=50; else    
           if(char_pattern == 'Z') gonode=51; else
           if(char_pattern == 'z') gonode=52; else
           if(char_pattern == '0') gonode=53; else
           if(char_pattern == '1') gonode=54; 
           return gonode-1;   
    }

    public void ShowMatch(){
        System.out.println("countfound :"+indexfound);
      //  if(countfound>-1){
        for(int i=0;i<indexfound;i++){
            System.out.println("Pattern :"+FoundPost[i][0]+"Position :"+FoundPost[i][1]);
        }
   //     }else System.out.println("��辺�����ŷ�� match �ѹ");
    }
//    public void WriteResult(int cal,int length,int size){
//      MyUrl my = new MyUrl();
//      DBDirect Conn = new DBDirect(); 
//      java.sql.Connection Trans 
//                = Conn.Connect(my.MyUrl()+"/Thesis", my.MyUser(),my.MyPassWord());
//        try
//        {
//            
//                    Trans.setAutoCommit(false);
//                   // if(count1>-1){
//                      for(int i=0;i<(int)(indexfound)/7;i++){
//                            String SQL = "INSERT INTO F_HORRES(GROUPCAL,PATTERN,POSITION,LENGTH,TEXTSIZE,CHARFOUND) VALUES("+                                
//                                        cal+","+FoundPost[i][0]+","+FoundPost[i][0]+","+FoundPost[i][1]+
//                                        ","+size+",'"+CharFound[i]+"')";
//                           if(Conn.SQLExecute(SQL)){ 
//                            Trans.commit();
//                           // Trans.setAutoCommit(true);
//                           // Conn.Close(Trans);
//                          //  javax.swing.JOptionPane.showMessageDialog(null,
//                          //          "��Ѻ��ا���������","Message",
//                          //          javax.swing.JOptionPane.INFORMATION_MESSAGE);    
//                                    //jButton4.setEnabled(false);
//                                    //Load1();
//                           }else {
//                                Trans.rollback();
//                                Trans.setAutoCommit(true);
//                                Conn.Close(Trans);
//                                javax.swing.JOptionPane.showMessageDialog(null,
//                                "�ջѭ�ҡ�س��ͧ����","�ѹ�֡��������",
//                                javax.swing.JOptionPane.ERROR_MESSAGE);  
//                           }
//                      }//end for
//                       Conn.Close(Trans);
//                   // }//end if 
//           
//        }catch(java.sql.SQLException ex2){
//                javax.swing.JOptionPane.showMessageDialog(null,
//                ex2.getMessage(),"�ѹ�֡��������",
//                javax.swing.JOptionPane.ERROR_MESSAGE);  
//        }        
//
//    }
}
