/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SM.KR;

/**
 *
 * @author Dell
 */
public class TestKR {
  int d, hp, hT;
  public int REHASH(String s){
      int temp=0;
      for(int i=0;i<s.length();i++)    
       temp = ((temp<<1)+s.charAt(i));
      return temp;
  } 
  public int preKR(String p){
      int m=p.length();
   //   d=1;
      hp =0;
    // for(int i=1;i<m;i++)
    //   d=(d<<1);      
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
     System.out.println("----- PreProcessing --------");
     preKR(p);
     System.out.println("hp:"+hp);
     //----- Searching -------
     System.out.println("----- Searching --------");
     for(int i=0;i<m; i++)  //first block to Hash
         hT = ((hT<<1)+T.charAt(i));
     System.out.println("Hash["+T.substring(j,j+m)+"]="+hT);
     while(j<n-m-1){
         System.out.println("---- ความพยายามครั้งที่ :"+(j+1)+"-------"+" j="+j);
         if(hp==hT)
             System.out.println("ค้นพบที่ตำแหน่ง :"+(j+m));
             
         j++;
         hT = REHASH(T.substring(j,j+m));
         System.out.println("Hash["+T.substring(j,j+m)+"]="+hT);
     }
 } 
 public static void main(String args[]) throws Exception{
         TestKR kr = new TestKR();
         kr.KRSearch("aabcz", "aabczefgaabczefgabcdg");
  } 
}
