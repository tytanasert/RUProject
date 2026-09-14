package MMP.HP;
import java.io.*;
public class HPAlgorithm {          
   BuildHPTrie1 pattern = new BuildHPTrie1();    
    public void HPSearch(String P[], String T) throws IOException{
        try{
           //Preprocessing
             pattern.HO(P);  //สร้าง HPTrie
             //----- Searching Phase ---
            int lmin=calculatelmin(P);
            DataNode Current=null; 
            int pos=lmin-1;
           while(pos<T.length())   //เริ่มค้นหา
           { 
               int j=0; 
                  Current=(DataNode)RoFunction(0,T.charAt(pos),Current,pos);
               j++;   
               while( ((pos-j)>=0) && Current!=null ){//end while              
                      if(RoFunction(1,T.charAt(pos-j),Current,pos-j)!=null)
                         Current = (DataNode)RoFunction(1,T.charAt(pos-j),Current,pos-j);
                      if(Current !=null) 
                      if(Current.getTerminate()==1) //set Mark founded state
                       {
                           System.out.println("ค้นพบที่ตำแหน่ง :"+(pos+1) +" อักขระแบบ :"+
                                   T.substring(pos-j,pos+1));
                           Current=null;
                       }                           
                        j++;
               }//end while  
               pos = pos+pattern.dTable[caseNode(T.charAt(pos))];
           }//end while    
        }catch(java.lang.NullPointerException e){
            System.out.println("Error ="+e);
          }  
    }
  
    public int calculatelmin(String p[]){
        int lm=999;
        for(int i=0;i<p.length;i++){
            if(lm>p[i].length())
            lm = p[i].length();
        }
        return lm;
    }
//*********** function ro Current ***
   public Object RoFunction(int i,char tpos,Object o,int poscal)  
   {
       Object now=null;  
       boolean found=false;
      try{ 
       if(i==0){     
                 int k=0;
                 found =false;
                 while(k<pattern.root.getLink().size()){
                     DataNode a = (DataNode)pattern.root.getLink().elementAt(k); 
                     if(a.getData() == tpos){   // ��Ҿ�
                        now = a;//root.getLink().elementAt(k); 
                        k=pattern.root.getLink().size();
                        found=true;
                     }
                     else{
                       k++;
                     }
                 }   
         }
         else   
         {
             if(o!=null){   
               int l=0;
                    int k=0; 
                    while(k<((DataNode)o).getNextLink().size()){  
                          DataNode a = (DataNode)((DataNode)o).getNextLink().elementAt(k);
                          if((a.getData()) == tpos ){   // ��Ҿ�
                             now = a;    
                             k=((DataNode)o).getNextLink().size();
                             found=true;
                          }
                          else
                              k++;
                       } //end while
             }      
         }
      }catch(Exception e){System.out.println("Error Ro function :"+e);}  
     return now;
   } 
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
 }
