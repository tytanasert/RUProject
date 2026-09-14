package MMP.AC;
import java.io.*;
public class AhoCorasickAlgorithm {       
   BuildACTrie  pattern= new BuildACTrie();
    public void AhoCorasickSearch(String P[], String text) throws IOException{
        try{
            String result="";
            //Preprocessing
             pattern.ACTrie(P); //สร้าง ACTrie
            //***************************************
            int flag=0;
            DataNode Current=null,temprow=null,initialNode=new DataNode();
           for(int pos=0;pos<text.length();pos++)  //��ǹ��ä�����ѡ
           {  if(pos==0) flag=0;
               while((Current!=null) && (RoFunction(flag,Current,text.charAt(pos))==null) ){
                   Current = Current.getBackLink();
               }
                 temprow =(DataNode)RoFunction(flag,Current,text.charAt(pos));     
               if(temprow !=null){
                   Current=temprow;
                   flag++;   
                   result = result+temprow.getData();
               }else
               {
                   flag=0;
                   Current=initialNode;
                   result="";
               }   
              if(Current !=null){
                   if(Current.getTerminate()==1) //set Mark founded state
                   {
                       System.out.println("ค้นพบที่ตำแหน่ง :"+(pos+1) +" อักขระแบบ :"+result);
                   }
              } 
           }//end while    
        }catch(java.lang.NullPointerException e){
            System.out.println("Error ="+e);
          }
    }

    public void AhoCorasickSearch1(String P[], char text[]) throws IOException{
        try{
            String result="";
            //Preprocessing
             pattern.ACTrie(P); //สร้าง ACTrie
            //***************************************
            int flag=0;
            DataNode Current=null,temprow=null,initialNode=new DataNode();
           for(int pos=0;pos<text.length;pos++)  //��ǹ��ä�����ѡ
           {  if(pos==0) flag=0;
               while((Current!=null) && (RoFunction(flag,Current,text[pos])==null) ){
                   Current = Current.getBackLink();
               }
                 temprow =(DataNode)RoFunction(flag,Current,text[pos]);     
               if(temprow !=null){
                   Current=temprow;
                   flag++;   
                   result = result+temprow.getData();
               }else
               {
                   flag=0;
                   Current=initialNode;
                   result="";
               }   
              if(Current !=null){
                   if(Current.getTerminate()==1) //set Mark founded state
                   {
                       System.out.println("ค้นพบที่ตำแหน่ง :"+(pos+1) +" อักขระแบบ :"+result);
                   }
              } 
           }//end while    
        }catch(java.lang.NullPointerException e){
            System.out.println("Error ="+e);
          }
    }
    
    
    //*********** function ro Current ***
   public Object RoFunction(int i,Object o,char tpos)  // ��Ǩ�ͺ��÷�ͧ� ro �ѧ��ѹ���t
   {
       Object now=null;  // index ��Ǥ���
       boolean found=false;
      try{ 
       if(i==0){   //�鹷�� root 
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
         else  // �óշ���������˹觷�� root */
         {
             if(o!=null){  //��Ǩ�ͺ�ҡ�繤�� null �����ӧҹ ���Шз�����Դ exception
               int l=0;
                    int k=0; 
                    while(k<((DataNode)o).getNextLink().size()){  
                          DataNode a = (DataNode)((DataNode)o).getNextLink().elementAt(k);
                          if((a.getData()) == tpos ){   // ��Ҿ�
                             now = a; //((DataNode)o).getNextLink().elementAt(k);  
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
}
