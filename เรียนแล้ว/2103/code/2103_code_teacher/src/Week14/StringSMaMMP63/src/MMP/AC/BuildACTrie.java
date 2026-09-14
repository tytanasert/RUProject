
package MMP.AC;
import java.util.Vector;
public class BuildACTrie {
    public DataRoot root=new DataRoot();
    public Object Current,Zeta,stat0;
    public DataRoot ACTrie(String P[]){
        String []pattern = new String[P.length];
        pattern = P;
        DataNode newNode;//Object Current;     
    try{  
        for(int i=0;i<pattern.length;i++){
            Current = root;  // �����Ҫ�������� root
            int j=0;
            while(j<pattern[i].length() && (RoFunction(j,pattern[i],Current)!=null)){
                 Current = RoFunction(j,pattern[i],Current);
                 j++;   
            }
            while(j<pattern[i].length()){  // ��ǹ�ͧ������ҧ�˹�
                if((j==0) && (Current == root)){  // root node
                   root.addState();
                   newNode = new DataNode(); 
                   newNode.setData(pattern[i].charAt(j));  // �Ӥ�� �ѡ��з�� j �����
                   newNode.setState(root.getTotalState()); // set State ����
                   root.addLink(newNode);  //new State
                   Current = newNode;//(DataNode)root.getLink().lastElement();
                }
                else // Add ����˹����Է����˹� Current */
                { 
                    newNode = new DataNode();
                   root.addState();
                   newNode.setData(pattern[i].charAt(j));  // �Ӥ�� �ѡ��з�� j �����
                   newNode.setState(root.getTotalState()); // set State ����
                   ((DataNode)Current).setNextLink(newNode);   // �����ѧ state ���������ҧ���
                   Current = newNode;               
                } 
                j++;
            } // end while �ͧ ������ҧ�˹�      
             ((DataNode)Current).setTerminate();  // ��˹��˹�������˹����� (����ش pattern) 
        }//end for ��ѡ
    }catch(Exception e){System.out.println("Error befor in Ro :"+e);}  
      BUILD_AC(4);
     return root;
    }
//-------------
  public Object RoFunction(int i,String ch,Object o)  // ��Ǩ�ͺ��÷�ͧ� ro �ѧ��ѹ���t
   {
       Object now=null;  // index ��Ǥ���
      try{ 
       if(i==0){   //�鹷�� root 
                 int k=0;
                 while(k<root.getLink().size()){
                     DataNode a = (DataNode)root.getLink().elementAt(k); 
                     if((a.getData()) == ch.charAt(0)){   // ��Ҿ�
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
                      if((a.getData()) == ch.charAt(i) ){   // ��Ҿ�
                         now = a; //((DataNode)o).getNextLink().elementAt(k);  
                         k=((DataNode)o).getNextLink().size();
                      }
                      else
                          k++;
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
              for(int j=0;j<root.getLink().size();j++) {
                   temptrav = ((DataNode)root.getLink().elementAt(j)).getNextLink();// .getData());
                     travindex[i].add((DataNode)root.getLink().elementAt(j)); 
                ((DataNode)root.getLink().elementAt(j)).setBackLink((DataNode)stat0); //.getBackLink() = root;
              }  
          }//end if
          else{
             for(int p=0;p< travindex[i-1].size();p++){ // �Դ��ͧ����� parrent 
                    for(int n=0;n<((DataNode)travindex[i-1].elementAt(p)).getNextLink().size();n++){ // ���˹��дѺ�Ѵ�ŧ� Vector �����ͤӹǳ�ͺ����                        
                       travtemp = (DataNode)travindex[i-1].elementAt(p);
                       travindex[i].add(((DataNode)travtemp).getNextLink().elementAt(n));
                    } // ������纤�� 
             } //enf for �纤��  
                for(int p=0;p< travindex[i].size();p++){ // �Դ��ͧ����� parrent 
                         templabel.removeAllElements();
                         if(label.size()>0) label.removeAllElements(); //�� label �����ҧ
                          Current =travindex[i].elementAt(p);  // Current ���Фӹǳ
                          travcurr = Current;
                          templabel.add(Current);
                          int indexlabel = i;
                          //*************
                         if(indexlabel>1){ // �ó� level 2 ����
                           while((indexlabel>0)){
                               int x=0;
                               while(x<travindex[indexlabel-1].size()){
                                   int z=0;
                                   while( z<((DataNode)travindex[indexlabel-1].elementAt(x)).getNextLink().size()) 
                                   {
                                       if(((DataNode)((DataNode)travindex[indexlabel-1].elementAt(x)).getNextLink().elementAt(z)).getState() ==
                                           ((DataNode)travcurr).getState() ){
                                            z=((DataNode)travindex[indexlabel-1].elementAt(x)).getNextLink().size();
                                            travcurr=travindex[indexlabel-1].elementAt(x);   // �纡�÷�ͧ�Ѩ�غѹ
                                            templabel.add(travcurr);
                                       }//else
                                           z++;
                                   }
                                   x++;
                               }
                               indexlabel--;
                               }
                               for(int count=templabel.size();count>0;count--){
                                   if(count!=templabel.size())
                                     label.add(templabel.elementAt(count-1));
                               }
                               Parrent = (DataNode)templabel.lastElement();
                         }else
                         { 
                             label.add(travindex[i].elementAt(p));
                             for(int pp=0;pp<root.getLink().size();pp++){
                                if(((DataNode)((DataNode)root.getLink().elementAt(pp)).getNextLink().elementAt(0)).getData() == ((DataNode)travindex[i].elementAt(p)).getData() )     
                                 {
                                   Parrent =   (DataNode)root.getLink().elementAt(pp);
                                 }
                             }    
                         }
                              Down = ((DataNode)Parrent).getBackLink();  // Down = Sac(Parrent)
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
             }// end for 
      }  //end Els ��ѡ
      }  //end for ��ѡ
  }
  //******************
  public DataNode RoACDown(Vector l){
      int index=0;
      DataNode n=new DataNode();
      for(int i=0;i<l.size();i++){
          if(index==0){  //�������º��º��� root  level 0
              int j=0;
              while(j<root.getLink().size()){
                if(((DataNode)l.elementAt(i)).getData() == ((DataNode)root.getLink().elementAt(j)).getData())
                {
                  n = (DataNode)root.getLink().elementAt(j);  
                  j=root.getLink().size();
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
              int j=0;
              if(n.getNextLink().size()>0){
                  boolean found=false;
              while(j< n.getNextLink().size()){
                if(((DataNode)l.elementAt(i)).getData() == ((DataNode)n.getNextLink().elementAt(j)).getData())
                {
                  n = (DataNode)n.getNextLink().elementAt(j);  
                  j=n.getNextLink().size();
                  index=index++;
                  found =true;
                }else
                {
                    j++;
                }   
              }//while
                if(found==false) { index=0; }
              } //end if  
          }
      } //end for ��ѡ
      if(index==0) n=null;
      return n;
  }  
    } 
