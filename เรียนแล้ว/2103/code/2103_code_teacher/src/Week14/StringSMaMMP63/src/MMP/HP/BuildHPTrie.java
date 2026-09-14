package MMP.HP;
import java.util.Vector;
public class BuildHPTrie {
    public DataRoot root=new DataRoot();
    public int[] dTable=new int[65];
    public Object Current;
        public DataRoot HO(String P[]){
        String []pattern = new String[P.length];
        pattern = P;
        DataNode newNode;//Object Current;
    try{  
        String RvPattern="";
        for(int i=0;i<pattern.length;i++){
            RvPattern = RevertPattern(pattern[i]);
            Current = root;   
            int j=0;
            while(j<RvPattern.length() && (RoFunction(j,RvPattern,Current)!=null)){
                 Current = RoFunction(j,RvPattern,Current);
                 j++;   
            }
            while(j<RvPattern.length()){   
                if((j==0) && (Current == root)){  // root node
                   newNode = new DataNode(); 
                   root.addState();
                   newNode.setData(RvPattern.charAt(j));  // �Ӥ�� �ѡ��з�� j �����
                   newNode.setState(root.getTotalState()); // set State ����
                   root.addLink(newNode);  //new State
                   //root.addState();
                   Current = newNode; 
                }
                else  
                {  newNode = new DataNode();
                   root.addState();
                   newNode.setData(RvPattern.charAt(j));   
                   newNode.setState(root.getTotalState());  
                   ((DataNode)Current).setNextLink(newNode);    
                   Current = newNode;               
                } 
                j++;
            } // end while       
             ((DataNode)Current).setTerminate();    
        }//end for 
    }catch(Exception e){System.out.println("Error befor in Ro :"+e);}  
      int localmin, length_pattern, lmin=999;
        for(int i=0;i<pattern.length;i++){
            if(lmin>pattern[i].length())
            lmin = pattern[i].length();
        }
        for(int i=0;i<54;i++)     
          dTable[i]=lmin;      
        for(int i=0;i<pattern.length;i++){    
         length_pattern=pattern[i].length();
          for(int k=0;k<=length_pattern-2;k++)
           {
             localmin=dMin(k,pattern[i]);
             storelMin(localmin,pattern[i].charAt(k));
           }
        } 
      return root;
    }
   public String RevertPattern(String pattern){
       String patt="";
       for(int i=pattern.length()-1;i>-1;i--){
           patt = patt+pattern.charAt(i);
       }
       return patt;
   }
   public Object RoFunction(int i,String ch,Object o)   
   {
       Object now=null;   
      try{ 
       if(i==0){     
                 int k=0;
                 while(k<root.getLink().size()){
                     DataNode a = (DataNode)root.getLink().elementAt(k); 
                     if((a.getData()) == ch.charAt(0)){    
                        now = a;     
                       k=root.getLink().size();
                     }
                     else{
                       k++;
                     }
                 }   
         }
         else   
         {
           int l=0;
                int k=0; 
                while(k<((DataNode)o).getNextLink().size()){  
                      DataNode a = (DataNode)((DataNode)o).getNextLink().elementAt(k);
                      if((a.getData()) == ch.charAt(i) ){    
                         now = a;    
                         k=((DataNode)o).getNextLink().size();
                      }
                      else
                          k++;
                   } //end while
         }
      }catch(Exception e){System.out.println("Error Ro function :"+e);}  
     return now;
   } 
   public void defaultdTable(int n,int number){
      for(int i=0;i<number;i++)
          dTable[i]=n;
  }    
  public int dMin(int n,String pattern){
      int temp=100;
      char ch;
      ch=pattern.charAt(n);
      for(int i=n;i<=pattern.length()-2;i++)
      {
          if(pattern.charAt(i)== ch) 
              temp = pattern.length()-(i+1);
      }
      return temp;
  }  
  private void storelMin(int min,char pattchar){
      if( dTable[caseNode(pattchar)]>min ) 
          dTable[caseNode(pattchar)]= min;       
  };
      private int caseNode(char char_pattern){
        char ch='$';
        int gonode=0;
           if( char_pattern == 'A') gonode=1; else
           if( char_pattern =='a') gonode=2; else
           if( char_pattern =='B') gonode=3; else
           if( char_pattern =='b') gonode=4; else
           if( char_pattern =='C') gonode=5; else    
           if( char_pattern =='c') gonode=6; else
           if( char_pattern =='D') gonode=7; else
           if( char_pattern =='d') gonode=8; else
           if( char_pattern =='E') gonode=9; else
           if( char_pattern =='e') gonode=10; else    
           if( char_pattern =='F') gonode=11; else
           if( char_pattern =='f') gonode=12; else
           if( char_pattern =='G') gonode=13; else
           if( char_pattern =='g') gonode=14; else
           if( char_pattern =='H') gonode=15; else    
           if( char_pattern =='h') gonode=16; else
           if( char_pattern =='I') gonode=17; else
           if( char_pattern =='i') gonode=18; else
           if( char_pattern =='J') gonode=19; else
           if( char_pattern =='j') gonode=20; else    
           if( char_pattern =='K') gonode=21; else
           if( char_pattern =='k') gonode=22; else
           if( char_pattern =='L') gonode=23; else
           if( char_pattern =='l') gonode=24; else
           if( char_pattern =='M') gonode=25; else    
           if( char_pattern =='m') gonode=26; else
           if( char_pattern =='N') gonode=27; else
           if( char_pattern =='n') gonode=28; else
           if( char_pattern =='O') gonode=29; else
           if( char_pattern =='o') gonode=30; else    
           if( char_pattern =='P') gonode=31; else
           if( char_pattern =='p') gonode=32; else
           if( char_pattern =='Q') gonode=33; else
           if( char_pattern =='q') gonode=34; else
           if( char_pattern =='R') gonode=35; else    
           if( char_pattern =='r') gonode=36; else
           if( char_pattern =='S') gonode=37; else
           if( char_pattern =='s') gonode=38; else
           if( char_pattern =='T') gonode=39; else
           if( char_pattern =='t') gonode=40; else    
           if( char_pattern =='U') gonode=41; else
           if( char_pattern =='u') gonode=42; else
           if( char_pattern =='V') gonode=43; else
           if( char_pattern =='v') gonode=44; else
           if( char_pattern =='W') gonode=45; else    
           if( char_pattern =='w') gonode=46; else
           if( char_pattern =='X') gonode=47; else
           if( char_pattern =='x') gonode=48; else
           if( char_pattern =='Y') gonode=49; else
           if( char_pattern =='y') gonode=50; else    
           if( char_pattern =='Z') gonode=51; else
           if( char_pattern =='z') gonode=52; else
           if( char_pattern =='0') gonode=53; else
           if( char_pattern =='1') gonode=54; 
           return gonode-1;   
    }  
          private char caseChar(int num){
        char ch='$';
        switch(num){
           case 1: {ch='A'; break;} 
           case 2: {ch='a'; break;}
           case 3: {ch='B'; break;}
           case 4: {ch='b'; break;} 
           case 5: {ch='C'; break;}
           case 6: {ch='c'; break;}
           case 7: {ch='D'; break;} 
           case 8: {ch='d'; break;}
           case 9: {ch='E'; break;}
           case 10: {ch='e'; break;} 
           case 11: {ch='F'; break;}
           case 12: {ch='f'; break;}
           case 13: {ch='G'; break;} 
           case 14: {ch='g'; break;}
           case 15: {ch='H'; break;}
           case 16: {ch='h'; break;} 
           case 17: {ch='I'; break;}
           case 18: {ch='i'; break;}
           case 19: {ch='J'; break;} 
           case 20: {ch='j'; break;}
           case 21: {ch='K'; break;}
           case 22: {ch='k'; break;} 
           case 23: {ch='L'; break;}
           case 24: {ch='l'; break;}
           case 25: {ch='M'; break;} 
           case 26: {ch='m'; break;}
           case 27: {ch='N'; break;} 
           case 28: {ch='n'; break;}
           case 29: {ch='O'; break;}
           case 30: {ch='o'; break;} 
           case 31: {ch='P'; break;}
           case 32: {ch='p'; break;}
           case 33: {ch='Q'; break;} 
           case 34: {ch='q'; break;}
           case 35: {ch='R'; break;}
           case 36: {ch='r'; break;} 
           case 37: {ch='S'; break;}
           case 38: {ch='s'; break;}
           case 39: {ch='T'; break;} 
           case 40: {ch='t'; break;}
           case 41: {ch='U'; break;}
           case 42: {ch='u'; break;} 
           case 43: {ch='V'; break;}
           case 44: {ch='v'; break;}
           case 45: {ch='W'; break;} 
           case 46: {ch='w'; break;}
           case 47: {ch='X'; break;}
           case 48: {ch='x'; break;} 
           case 49: {ch='Y'; break;}
           case 50: {ch='y'; break;}
           case 51: {ch='Z'; break;} 
           case 52: {ch='z'; break;}
           case 53: {ch='0'; break;} 
           case 54: {ch='1'; break;}
        }
           return ch;   
    }     
    } 
