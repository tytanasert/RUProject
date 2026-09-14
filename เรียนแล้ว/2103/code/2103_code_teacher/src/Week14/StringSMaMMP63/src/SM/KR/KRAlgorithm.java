
package SM.KR;


public class KRAlgorithm {
  int hp, hT;
  public int REHASH(String s){
      int temp=0;
      for(int i=0;i<s.length();i++)    
       temp = ((temp<<1)+s.charAt(i));
      return temp;
  } 
  public int preKR(String p){
      int m=p.length();
      hp =0;
     for(int i=0;i<m;i++)    
       hp = ((hp<<1)+p.charAt(i));
   return hp;  
  }  
 public void KRSearch(String p, String T){
     int m=p.length();
     int n=T.length();
     int j=0;
     hT = 0;
     //------ Pre Processing --------
     preKR(p);
     //System.out.println("hx:"+hx);
     //----- Searching -------
     for(int i=0;i<m; i++)  //first block to Hash
         hT = ((hT<<1)+T.charAt(i));
     //System.out.println("Hash["+T.substring(j,j+m)+"]="+hy);
     while(j<n-m){
         System.out.println("--- ความพยายามครั้งที่ ---"+(j+1));
         System.out.println("Hash["+T.substring(j,j+m)+"]="+hT);
         if(hp==hT)
             System.out.println("ค้นพบที่ตำแหน่ง :"+(j+m));
             
         j++;
         hT = REHASH(T.substring(j,j+m));
         //System.out.println("Hash["+T.substring(j,j+m)+"]="+hy);
     }
 }     
}
