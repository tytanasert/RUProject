/*
 * PreprocessingPhrase.java
 *
 * Created on 17 �ԧ�Ҥ� 2547, 10:44 �.
 */

package MMP.HP;
import java.util.Vector;
/**
 *
 * @author  user
 */
public class PreprocessingPhrase64 {
    public DataRoot root=new DataRoot();
    public int[] dTable=new int[65];
    public Object Current;
  //  private int numofnode;
    /** Creates a new instance of PreprocessingPhrase */
    public PreprocessingPhrase64(){
      //  CreateRoot(num_pattern);
        
    }
   public String RevertPattern(String pattern){
       String patt="";
     //        System.out.println("Befor Revert");
       for(int i=pattern.length()-1;i>-1;i--){
           patt = patt+pattern.charAt(i);
       }
     //  System.out.println("Revert OK");
       //patt = patt+pattern.substring(0,1);
       return patt;
   }
           // ���ҧ pattern Ẻ one way link list ��˹��¤��h�
    public void CreatePattern(int num_pattern,int length_pattern,String filename){
        String []pattern = new String[num_pattern];
        DataNode newNode;//Object Current;
        try{
            pattern = createText.getPatternText(filename, num_pattern);   
        }catch(Exception em){System.out.println(em);}      
      long bef, aft;
      bef=System.nanoTime();
    try{  
        String RvPattern="";
        for(int i=0;i<num_pattern;i++){
        //      System.out.println("Before Test Gennode 0");
            RvPattern = RevertPattern(pattern[i]);
        //      System.out.println("Before Test Gennode 1");
            Current = root;  // �����Ҫ�������� root
            int j=0;
            
//            System.out.println("Before Check Ro:" +i+"  root State :"+root.getTotalState()+
//            " Revert Pattern : "+RevertPattern(pattern[i]));
           // if(root.getTotalState()>0){
        //    System.out.println("Before Test Gennode 2");
            while(j<RvPattern.length() && (RoFunction(j,RvPattern,Current)!=null)){
                 Current = RoFunction(j,RvPattern,Current);
                 j++;   
            }
           // }
            while(j<RvPattern.length()){  // ��ǹ�ͧ������ҧ�˹�
                // ��ǹ�ͧ������ҧ�˹�����
      //                System.out.println("xxxxx OK"+j);
                if((j==0) && (Current == root)){  // root node
                  //*******************
                  //*******************  
                   newNode = new DataNode(); 
                   root.addState();
                   newNode.setData(RvPattern.charAt(j));  // �Ӥ�� �ѡ��з�� j �����
                   newNode.setState(root.getTotalState()); // set State ����
                   root.addLink(newNode);  //new State
                   //root.addState();
                   Current = newNode;//(DataNode)root.getLink().lastElement();
                  // System.out.println("Pattern :"+i+"Add Data in root :"+((DataNode)Current).getData());
                }
                else // Add ����˹����Է����˹� Current */
                {  newNode = new DataNode();
                   root.addState();
  //                       System.out.println("yyyy OK"+j+":"+RvPattern);
                   newNode.setData(RvPattern.charAt(j));  // �Ӥ�� �ѡ��з�� j �����
    //               System.out.println("zzzzz OK"+j+":"+RvPattern);
                   newNode.setState(root.getTotalState()); // set State ����
                   ((DataNode)Current).setNextLink(newNode);   // �����ѧ state ���������ҧ���
                   Current = newNode;               
                  // System.out.println("Pattern :"+i+"Add Data  :"+((DataNode)Current).getData());
                } 
                j++;
//System.out.println("aaa OK"+j+":"+RvPattern);
            } // end while �ͧ ������ҧ�˹�      
             ((DataNode)Current).setTerminate();  // ��˹��˹�������˹����� (����ش pattern) 
        }//end for ��ѡ
    }catch(Exception e){System.out.println("Error befor in Ro :"+e);}  
      //*****************************  ��ǹ��äӹǳ ���ҧ d ******************
      int localmin;
      
        for(int i=0;i<65;i++)         // ��˹��������u鹢ͧ��� Shift �����·���ش��ҡѺ pattern(lmin)
          dTable[i]=length_pattern;      
        for(int i=0;i<num_pattern;i++){   // �ӹǳ��� lmin 㹷ء � �ѡ���
         length_pattern=pattern[i].length();
          for(int k=0;k<=length_pattern-2;k++)
           {
             localmin=dMin(k,pattern[i]);
           //  System.out.println("bbb OK"+":"+i+":"+pattern[i]);
             storelMin(localmin,pattern[i].charAt(k));
            //  System.out.println("kkkk OK"+":"+k+" :"+length_pattern+" pi:"+pattern[i]);
           }
        } 
       aft=System.nanoTime();
      // System.out.println("Procesing Time:"+(aft-bef));
      //***************************** ����ǹ��äӹǳ ���ҧ d *****************
    }
  public Object RoFunction(int i,String ch,Object o)  // ��Ǩ�ͺ��÷�ͧ� ro �ѧ��ѹ���t
   {
       Object now=null;  // index ��Ǥ���
      try{ 
       if(i==0){   //�鹷�� root 
                 int k=0;
                 while(k<root.getLink().size()){
                     DataNode a = (DataNode)root.getLink().elementAt(k); 
                     //System.out.println("Data traversal in root :"+a.getData());
                     if((a.getData()) == ch.charAt(0)){   // ��Ҿ�
                       // System.out.println("����Ƿ������͹�ѹ��� :"+a.getData());
                        now = a;//root.getLink().elementAt(k);    
                       k=root.getLink().size();
                     }
                     else{
                       k++;
                     }
                 }   
         }
         else  // �óշ���������˹觷�� root */
         {
           int l=0;
                int k=0; 
                while(k<((DataNode)o).getNextLink().size()){  
                      DataNode a = (DataNode)((DataNode)o).getNextLink().elementAt(k);
                     // System.out.println("Data traversal :"+a.getData()); 
                      if((a.getData()) == ch.charAt(i) ){   // ��Ҿ�
                         now = a; //((DataNode)o).getNextLink().elementAt(k);  
                         k=((DataNode)o).getNextLink().size();
                      }
                      else
                          k++;
                      //    now = null;   // �����辺
                   } //end while

         }
      }catch(Exception e){System.out.println("Error Ro function :"+e);}  
     return now;
   } 
  //*************  ��˹��������u����Ѻ���ҧ d *************
  public void defaultdTable(int n,int number){
      for(int i=0;i<number;i++)
          dTable[i]=n;
  }  
  //****************** ��ǹ�ͧ��äӹǳ��� d min ����Դ�Ѻ�����ѡ��� **********
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
 // ***************  ��Ǩ�ͺ��� lmin �ͧ���� �ѡ��� **********  
  private void storelMin(int min,char pattchar){
      if( dTable[caseNode(pattchar)]>min ) 
          dTable[caseNode(pattchar)]= min;      // ��ҹ��¡��� update min
  };
  //**********************************************************
      private int caseNode(char char_pattern){
        char ch='$';
        int gonode=0;
      //  System.out.println("befor if :char_pattern:"+char_pattern);
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
           if( char_pattern =='@') gonode=53; else
           if( char_pattern =='#') gonode=54; else
           if( char_pattern =='%') gonode=55; else
           if( char_pattern =='&') gonode=56; else
           if( char_pattern =='*') gonode=57; else
           if( char_pattern =='(') gonode=58; else
           if( char_pattern ==')') gonode=59; else
           if( char_pattern =='-') gonode=60; else
           if( char_pattern =='=') gonode=61; else
           if( char_pattern =='<') gonode=62; else
           if( char_pattern =='>') gonode=63; else
           if( char_pattern =='?') gonode=64; //else
            //   gonode = 2;
          // System.out.println("char_pattern gonode="+gonode+"char:"+char_pattern);
           return gonode-1;   
    }
  //**********************************************************
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
           case 53: {ch='@'; break;} 
           case 54: {ch='#'; break;}
            case 55: {ch='%'; break;} 
           case 56: {ch='&'; break;}
            case 57: {ch='*'; break;} 
           case 58: {ch='('; break;}
            case 59: {ch=')'; break;} 
           case 60: {ch='-'; break;}
            case 61: {ch='='; break;} 
           case 62: {ch='<'; break;}
            case 63: {ch='>'; break;} 
           case 64: {ch='?'; break;}
           //default :{ch='A'; break;}

        }
           return ch;   
    }

  //**********************************************************
    public void ShowdTable(){
        System.out.println("Show Table :");
        for(int i=0;i<64;i++)
            System.out.println(" Node :"+i+" Data : "+caseChar(i+1)+" lmin :"+dTable[i]);
    }
  //**********************************************************    
    public void ShowDataRoot(){
        System.out.println("Show Data Root:");
        for(int i=0;i<root.getLink().size();i++)
            System.out.println("State :"+
            ((DataNode)root.getLink().elementAt(i)).getState()+"  Data : "+
            ((DataNode)root.getLink().elementAt(i)).getData());
    }
  // ***************
   public void ShowDataNode(){
       System.out.println("Show Data Root:");
         DataNode ptr,ptr1;
         Vector a,a1;
         Object b;
                 
       for(int i=0;i<root.getLink().size();i++){  /* Level 1 */
            System.out.println("State Level 0 :"+
            ((DataNode)root.getLink().elementAt(i)).getState()+"  Data : "+
            ((DataNode)root.getLink().elementAt(i)).getData());            
            a = ((DataNode)root.getLink().elementAt(i)).getNextLink();
            System.out.println("Size :"+a.size());
            for(int k=0;k<((DataNode)root.getLink().elementAt(i)).getNextLink().size();k++){
                  ptr = (DataNode)(((DataNode)root.getLink().elementAt(i)).getNextLink().elementAt(k));
                  System.out.println("Level 1 :" +ptr.getData()+":"+ptr.getState()+":"+ptr.getTerminate());
                  a1 = ptr.getNextLink();
                  for(int j=0;j<a1.size();j++){     //level 2
                      ptr1 =  (DataNode)ptr.getNextLink().elementAt(j);
                      System.out.println("Level 2 :" +ptr1.getData()+":"+ptr1.getState()+":"+ptr1.getTerminate());                      
                  }
                
            }        

           }
   }      
   //****   
    } 
