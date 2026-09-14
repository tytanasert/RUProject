/*
 * PreprocessingPhrase.java
 *
 * Created on 17 �ԧ�Ҥ� 2547, 10:44 �.
 */

package MMP.AC;
import java.util.Vector;
/**
 *
 * @author  user
 */
public class PreprocessingPhrase {
    public DataRoot root=new DataRoot();
    public Object Current,Zeta,stat0;
  //  private int numofnode;
    /** Creates a new instance of PreprocessingPhrase */
    public PreprocessingPhrase(){
      //  CreateRoot(num_pattern);
        
    }
    public void CreatePattern(int num_pattern,int length_pattern,String filename){
       // System.out.println("Pre: numb_pattern"+num_pattern);
        String []pattern = new String[num_pattern];
        DataNode newNode;//Object Current;     
        try{
            pattern = createText.getPatternText(filename, num_pattern);   
        }catch(Exception em){System.out.println(em);}
      long bef, aft;
     // bef=System.nanoTime();
    try{  
       // System.out.println("num_pattern:"+num_pattern);
        for(int i=0;i<num_pattern;i++){
            Current = root;  // �����Ҫ�������� root
            int j=0;
         //   System.out.println("For i:"+i);
          // System.out.println("Before Check Ro:" +i+"  root State :"+root.getTotalState());
           // if(root.getTotalState()>0){
           // System.out.println("Pattern i: len:"+i+":"+pattern[i].length());
            while(j<pattern[i].length() && (RoFunction(j,pattern[i],Current)!=null)){
             //   System.out.println("in first while : i j"+i+":"+j);
                 Current = RoFunction(j,pattern[i],Current);
             //    System.out.println("in first call Ro : i j"+i+":"+j);
                 j++;   
            }
           // }
            //System.out.println("j:"+j);
            while(j<pattern[i].length()){  // ��ǹ�ͧ������ҧ�˹�
              //  System.out.println("Test i:"+i);
                if((j==0) && (Current == root)){  // root node
                  //*******************
                  //*******************  
                   root.addState();
                   newNode = new DataNode(); 
                //   System.out.println("i j"+ i+":"+j);
                   newNode.setData(pattern[i].charAt(j));  // �Ӥ�� �ѡ��з�� j �����
                //   System.out.println("aff i j"+ i+":"+j);
                   newNode.setState(root.getTotalState()); // set State ����
                   root.addLink(newNode);  //new State
                   //root.addState();
                  // ((DataNode)root.getLink().lastElement()).setData(pattern[i].charAt(j)); // ���ѡ��з�� j �� �˹��á
                  // ((DataNode)root.getLink().lastElement()).setState(root.getTotalState());  // �� State
                   Current = newNode;//(DataNode)root.getLink().lastElement();
          //         System.out.println("Pattern :"+i+"Add Data in root :"+((DataNode)Current).getData());
                }
                else // Add ����˹����Է����˹� Current */
                { 
                  //  System.out.println("j else:"+j);
                    newNode = new DataNode();
                   root.addState();
                   newNode.setData(pattern[i].charAt(j));  // �Ӥ�� �ѡ��з�� j �����
                   newNode.setState(root.getTotalState()); // set State ����
                   ((DataNode)Current).setNextLink(newNode);   // �����ѧ state ���������ҧ���
                   Current = newNode;               
                  // System.out.println("j after else:"+j);
        //           System.out.println("Pattern :"+i+"Add Data  :"+((DataNode)Current).getData());
                } 
                j++;

            } // end while �ͧ ������ҧ�˹�      
             ((DataNode)Current).setTerminate();  // ��˹��˹�������˹����� (����ش pattern) 
            // System.out.println("Set Terminate Ok");
        }//end for ��ѡ
       // aft=System.nanoTime();
       // System.out.println("Time PreProcessing:"+(aft-bef));
    }catch(Exception e){System.out.println("Error befor in Ro :"+e);}  
      BUILD_AC(length_pattern);
    }
  public Object RoFunction(int i,String ch,Object o)  // ��Ǩ�ͺ��÷�ͧ� ro �ѧ��ѹ���t
   {
       Object now=null;  // index ��Ǥ���
      try{ 
       if(i==0){   //�鹷�� root 
                 int k=0;
                 while(k<root.getLink().size()){
                     DataNode a = (DataNode)root.getLink().elementAt(k); 
                    //// System.out.println("Data traversal in root :"+a.getData());
                     if((a.getData()) == ch.charAt(0)){   // ��Ҿ�
                      //  System.out.println("����Ƿ������͹�ѹ��� :"+a.getData());
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
  //******************
  public void BUILD_AC(int finalLevel){
      Object Parrent=null,Down,travcurr,travtemp;
      Vector label=new Vector(),temptrav,templabel=new Vector();
      Vector [] travindex;
      Vector tr=new Vector();
      DataNode temp; // ���繵�Ǫ���÷�ͧ����� Level
      //System.out.println("Data Build AC Tries");
      temp = new DataNode();
      temp.setBackLink(null);
      temp.setState(0);
      Zeta = temp;
      stat0 = temp;
      travindex = new Vector[65]; //เขียนเพิ่มใหม่ จาก 20 เป็น 65
      for(int i=0;i<finalLevel;i++){ //Traversal in all node
          travindex[i] = new Vector();
          travindex[i].removeAllElements();
          if(i==0) {   // ��� root Parrent ��ѡ �ͧ�����˹� Level 0    
              //travindex[i] = new Vector();
              for(int j=0;j<root.getLink().size();j++) {
                  // �ӹǳ Back Link
                   temptrav = ((DataNode)root.getLink().elementAt(j)).getNextLink();// .getData());
                 // System.out.println("����˹��дѺ 0  "+temptrav.size()+ "link to  "+ ((DataNode)temptrav.elementAt(0)).getData());// ((DataNode)temptrav).getData());//+
                  //for(int m=0;m<temptrav.size();m++)  // �˹�ŧ level ����
                     travindex[i].add((DataNode)root.getLink().elementAt(j)); 
                // System.out.println("State :"+
               //  ((DataNode)root.getLink().elementAt(j)).getState()+"  Data : "+
               //  ((DataNode)root.getLink().elementAt(j)).getData());
                 // ������ͧ��˹�����u�
                ((DataNode)root.getLink().elementAt(j)).setBackLink((DataNode)stat0); //.getBackLink() = root;
              }  
                // for(int xxx=0;xxx<travindex[i].size();xxx++)
                //     System.out.println("�����á �͹��ѧ�纤��ŧ Data[i] "+i+
                //     "  Data = "+((DataNode)travindex[i].elementAt(xxx)).getData());

          }//end if
          else{
          //Level ��� �
           
             for(int p=0;p< travindex[i-1].size();p++){ // �Դ��ͧ����� parrent 
                 //System.out.println("�͹�纤�� Test Befor traversal travindex[i-1].size(): "+travindex[i-1].size());
                    //travindex[i] = new Vector();
                   //  System.out.println(" �͹�纤�� Befor Store data  Data in travindex :"+i+ "  Size of :"+travindex[i].size() ); 
                    for(int n=0;n<((DataNode)travindex[i-1].elementAt(p)).getNextLink().size();n++){ // ���˹��дѺ�Ѵ�ŧ� Vector �����ͤӹǳ�ͺ����                        
                   //     System.out.println("�͹�纤�� Size of next ="+((DataNode)travindex[i-1].elementAt(p)).getNextLink().size());
                       travtemp = (DataNode)travindex[i-1].elementAt(p);
                       travindex[i].add(((DataNode)travtemp).getNextLink().elementAt(n));
                    } // ������纤�� 
             } //enf for �纤��  
                // for(int xxx=0;xxx<travindex[i].size();xxx++)
                //     System.out.println("੾�� �͹��ѧ�纤��ŧ Data[i] "+i+
                //     "  Data = "+((DataNode)travindex[i].elementAt(xxx)).getData());
               //  System.out.println("�͹��ѧ�纤��ŧ travindex[i] "+i+"Size of Vector "+travindex[i].size());
                 //����dԴ���ͺ
                for(int p=0;p< travindex[i].size();p++){ // �Դ��ͧ����� parrent 
                 //System.out.println(" ����wӧҹ Test Befor traversal travindex[i-1].size(): "+travindex[i-1].size());
 
                //     System.out.println("����wӧҹ Test Befor For = Data in travindex :"+i
                //     + "  Size of :"+travindex[i].size()+ "Data :"+((DataNode)travindex[i].elementAt(p)).getData() );
                     //for(int kk=0;kk<travindex[i].size();kk++)  // �ʴ���ͤ���ź��
                     //   System.out.println(((DataNode)travindex[i].elementAt(kk)).getData());
                     // �� label function
                        
                         templabel.removeAllElements();
                         if(label.size()>0) label.removeAllElements(); //�� label �����ҧ
                          Current =travindex[i].elementAt(p);  // Current ���Фӹǳ
                         // System.out.println("Current new round :"+((DataNode)Current).getData());
                          travcurr = Current;
                          //System.out.println("Set travcur = Current new round :");
                          templabel.add(Current);
                          //System.out.println("Add Current to temp label new round :");
                          int indexlabel = i;
                          //*************
                         if(indexlabel>1){ // �ó� level 2 ����
                           //  System.out.println("��͹��� while Test Befor For = Data in travindex :"+i+ "  Size of :"+travindex[indexlabel].size() );
                           while((indexlabel>0)){
                               int x=0;
                               while(x<travindex[indexlabel-1].size()){
                    //               System.out.println("x="+x);
                                   int z=0;
                                   while( z<((DataNode)travindex[indexlabel-1].elementAt(x)).getNextLink().size()) 
                                   {
                      //                 System.out.println("z="+z);
                                       if(((DataNode)((DataNode)travindex[indexlabel-1].elementAt(x)).getNextLink().elementAt(z)).getState() ==
                                           ((DataNode)travcurr).getState() ){
                                            z=((DataNode)travindex[indexlabel-1].elementAt(x)).getNextLink().size();
                                          // x=loop1;  // ��Ҿ���鹷ҧ������
                                            travcurr=travindex[indexlabel-1].elementAt(x);   // �纡�÷�ͧ�Ѩ�غѹ
                                            templabel.add(travcurr);
//                                           for(int kk=0;kk<templabel.size();kk++){
                        //                        System.out.println("Add Node in templabel :"+
                        //                        ((DataNode)templabel.lastElement()).getData());
                                           //}
                                       }//else
                                           z++;
                                   }
                                   x++;
                               }
                               indexlabel--;
                         //    System.out.println("Node Root templabel :"+
                          //   ((DataNode)templabel.elementAt(0)).getData());

                               }
                          //   System.out.println("Node Root templabel :"+
                            // ((DataNode)templabel.elementAt(0)).getData());
                              //***** �ӹǳ���ŵç��� *****
                             // for(int kk=0;kk<templabel.size();kk++){
                             //    System.out.println("�����š�͹ �ӹǳ ���� :"+
                             //    ((DataNode)templabel.elementAt(kk)).getData());
                             //  }

                               for(int count=templabel.size();count>0;count--){
                                   if(count!=templabel.size())
                                     label.add(templabel.elementAt(count-1));
                                   //System.out.println("Data in");
                               }
                               Parrent = (DataNode)templabel.lastElement();
                              // System.out.println("Data in label Level 2: Parrent is :"+
                              // ((DataNode)Parrent).getData());
                            //  for(int xx=0;xx<label.size();xx++){
                            //      System.out.println(((DataNode)label.elementAt(xx)).getData()+"state = "+((DataNode)label.elementAt(xx)).getState());
                            //  }    
                         }else
                         { 
                            // System.out.println("Test Befor Add travindex[i]");
                             label.add(travindex[i].elementAt(p));
                           //  System.out.println("Test Befor Add After travindex[i]"+root.getLink().size());
                             for(int pp=0;pp<root.getLink().size();pp++){
                                // System.out.println("Data :"+((DataNode)((DataNode)root.getLink().elementAt(pp)).getNextLink().elementAt(0)).getData()+"  :"+((DataNode)travindex[i].elementAt(p)).getData());
                                // if(((DataNode)root.getLink().elementAt(pp)).getData() == ((DataNode)travindex[i].elementAt(p)).getData() )
                                if(((DataNode)((DataNode)root.getLink().elementAt(pp)).getNextLink().elementAt(0)).getData() == ((DataNode)travindex[i].elementAt(p)).getData() )     
                                 {
                                   Parrent =   (DataNode)root.getLink().elementAt(pp);
                                //   System.out.println("Test in set Parrent");
                                 }
                             }    
                         }
                          // ��ǹ�ͧ����� Sac(Current)
                            //  System.out.println("Test Befor Down set ");
                              Down = ((DataNode)Parrent).getBackLink();  // Down = Sac(Parrent)
                            // System.out.println("Test Befor Row Ac down while");
                              while((Down != null) &&(RoACDown(label) == null) ){
                                  Down = ((DataNode)Down).getBackLink();
                              }
                              if(Down != null){
                                  ((DataNode)Current).setBackLink(RoACDown(label));
                              } // ����ͧ set Terminal ������� set �͹ ���ҧ Trie ����  
                              else
                              {
                                  ((DataNode)Current).setBackLink((DataNode)stat0);
                              }
                                 
                          // ��ǹ�ͧ����� Sac(Current)
             }// end for 
           //  }// end for �Դ��ͧ����� parrent
      }  //end Els ��ѡ
      }  //end for ��ѡ
     // System.out.println("End Show Data Build AC Tries");
  }
  //******************
  //******************
  public DataNode RoACDown(Vector l){
      int index=0;
      DataNode n=new DataNode();
     // for(int xx=0;xx<l.size();xx++)
     //     System.out.println("Data in l Vector :"+((DataNode)l.elementAt(xx)).getData());
      for(int i=0;i<l.size();i++){
          if(index==0){  //�������º��º��� root  level 0
              int j=0;
              while(j<root.getLink().size()){
                if(((DataNode)l.elementAt(i)).getData() == ((DataNode)root.getLink().elementAt(j)).getData())
                {
                  n = (DataNode)root.getLink().elementAt(j);  
                  j=root.getLink().size();
                // System.out.println("��� �ѧ��ѹ��� RowAcDown �ͺ�ͧ Root "+ n.getData()+n.getState());
                  index=1;
                }else
                { 
                    j++;
                    index=0;
                }   
              }//while
          }//end if ��ѡ
          else
          {    // �ӹǳ�ó� �ҡ���� level 0
         //     System.out.println("��� �ѧ��ѹ��� RowAcDown �ͺ�ͧ�ҡ����  Root");
              int j=0;
              if(n.getNextLink().size()>0){
                  boolean found=false;
              while(j< n.getNextLink().size()){
           //       System.out.println("loop link ="+n.getNextLink().size() +" ����ٻ n= "+n.getData()+n.getState()+" next n" +
            //      ((DataNode)n.getNextLink().elementAt(j)).getData()+" i.data ="+
            //      ((DataNode)l.elementAt(i)).getData() +" l data= "+((DataNode)l.elementAt(i)).getData());
                if(((DataNode)l.elementAt(i)).getData() == ((DataNode)n.getNextLink().elementAt(j)).getData())
                {
                  n = (DataNode)n.getNextLink().elementAt(j);  
                  j=n.getNextLink().size();
            //      System.out.println("��� �ѧ��ѹ��� RowAcDown "+n.getData() +n.getState()+ " index :"+index);
                  index=index++;
                  found =true;
                }else
                {
                    j++;
                    //index=0;
                   // n=null;
                }   
              }//while
                if(found==false) { index=0; }
              } //end if  
              //System.out.println("�������äӹǳ�ҡ���� Level 0");
          }
      } //end for ��ѡ
      if(index==0) n=null;
      //else
      //    System.out.println("Befor return :"+n.getData() +"  :"+n.getState());
      return n;
  }
  //******************
    public void ShowDataRoot(){
        for(int i=0;i<root.getLink().size();i++)
            System.out.println("State :"+
            ((DataNode)root.getLink().elementAt(i)).getState()+"  Data : "+
            ((DataNode)root.getLink().elementAt(i)).getData() + "   Link to State :"+
            ((DataNode)root.getLink().elementAt(i)).getBackLink().getState());
    }
  // ***************
   public void ShowDataNode(){
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
                  System.out.println("Level 1 :" +ptr.getData()+":"+ptr.getState()+":"+ptr.getTerminate()+
                  "   Link to State :"+ptr.getBackLink().getState()+"  Data in link Node :"+ptr.getBackLink().getData()+ "");
                  a1 = ptr.getNextLink();
                  for(int j=0;j<a1.size();j++){     //level 2
                      ptr1 =  (DataNode)ptr.getNextLink().elementAt(j);
                      System.out.println("Level 2 :" +ptr1.getData()+":"+ptr1.getState()+":"+ptr1.getTerminate()+
                      "Link to Node ->"+ptr1.getBackLink().getState()+"  Data in link Node :"+ptr1.getBackLink().getData()+ "");                      
                  }
                
            }        

           }
   }      
   //****   
    } 
