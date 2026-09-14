package SM.PFIVL;
import java.util.HashSet;
import java.util.Hashtable;

public class PPFHashAlgorithm {
   char last;
   char first;
  HashSet HT=new HashSet();
  Hashtable Max = new Hashtable();
public void prePPFHash(String p){
      int m=p.length();
      last=p.charAt(m-1);
      first=p.charAt(0);
      HT.add(p.substring(1, p.length()-1));
      for(int i=0;i<m;i++){
        Max.put(p.charAt(i), m);  
      }
      for(int i=0;i<m-1;i++){
       // char c=p.charAt(i);
        Max.remove(p.charAt(i));
        Max.put(p.charAt(i), m-(i+1));              
      }
  }

  public void PPFHashSearch(String p, String text){ 
      int m=p.length();
      int n=text.length();
      int e=m-1;
      int b=0;
      // ---- Preprocessing ------ 
      prePPFHash(p);
      //---- Searching ------ 
      while(e < n ) {
        if(text.charAt(e)==last){
            if (text.charAt(b)==first){
                if(HT.contains(text.substring((b+1),e))){
                   System.out.println("ค้นพบที่ตำแหน่ง:"+(e+1));
                }
            }
        }           
        if(Max.get(text.charAt(e))!=null){
           e+=(Integer)Max.get(text.charAt(e));
           b=e-m+1;
        }
        else{
            e+=m;
            b=e-m+1;
        }
     }//end while   
  }//end method    
}
