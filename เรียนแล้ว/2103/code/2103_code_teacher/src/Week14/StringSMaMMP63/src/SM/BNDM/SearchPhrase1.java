/*
 * SearchPhrase.java
 *
 * Created on 29 �ԧ�Ҥ� 2547, 22:18 �.
 * Last update 29 �ѹ��¹ 2547,10.20 �.
 */

package SM.BNDM;
import java.io.*;

/**
 *
 * @author  user
 */
public class SearchPhrase1 {       
   String pattern;//="abcd", text="abcdeabcdaaabcd"; 
   // String p="abcd", text="abcdeabcdaaabcd";    
 // String p="aaaa", text="aaaaaaaabcdeabcdaaaabcd";   
   long B[] = new long[67];
  // int count=0;
   
   
   public SearchPhrase1(String p){
    pattern=p;
    System.out.println("-------- PreProcessing --------------");
    for(int i=0;i<65;i++) {
        B[i]=0;
        System.out.println("Bit:"+Long.toBinaryString(B[i]));
    }
    for(int j=0;j<pattern.length();j++) {
      B[gotoChar(pattern.charAt(j))]=B[gotoChar(pattern.charAt(j))]|(1<<(pattern.length()-j));        
      System.out.println("Bit Pattern char at:"+pattern.charAt(j)+
              (Long.toBinaryString(B[gotoChar(pattern.charAt(j))])));
    }
   }
   
   public int gotoChar(char c){
        int number=-1;
        switch(c){
           case 'A': {number=0; break;} 
           case 'B': {number=1; break;}
           case 'C': {number=2; break;}
           case 'D': {number=3; break;}
           case 'E': {number=4; break;}
           case 'F': {number=5; break;}
           case 'G': {number=6; break;}
           case 'H': {number=7; break;}
           case 'I': {number=8; break;}
           case 'J': {number=9; break;}
           case 'K': {number=10; break;}
           case 'L': {number=11; break;}
           case 'M': {number=12; break;}
           case 'N': {number=13; break;}
           case 'O': {number=14; break;}
           case 'P': {number=15; break;}
           case 'Q': {number=16; break;}
           case 'R': {number=17; break;}
           case 'S': {number=18; break;}
           case 'T': {number=19; break;}
           case 'U': {number=20; break;}
           case 'V': {number=21; break;}
           case 'W': {number=22; break;}
           case 'X': {number=23; break;}
           case 'Y': {number=24; break;}
           case 'Z': {number=25; break;}
           case 'a': {number=26; break;}
           case 'b': {number=27; break;}
           case 'c': {number=28; break;}
           case 'd': {number=29; break;}
           case 'e': {number=30; break;}
           case 'f': {number=31; break;}
           case 'g': {number=32; break;}
           case 'h': {number=33; break;}
           case 'i': {number=34; break;}
           case 'j': {number=35; break;}
           case 'k': {number=36; break;}
           case 'l': {number=37; break;}
           case 'm': {number=38; break;}
           case 'n': {number=39; break;}
           case 'o': {number=40; break;}
           case 'p': {number=41; break;}
           case 'q': {number=42; break;}
           case 'r': {number=43; break;}
           case 's': {number=44; break;}
           case 't': {number=45; break;}
           case 'u': {number=46; break;}
           case 'v': {number=47; break;}
           case 'w': {number=48; break;}
           case 'x': {number=49; break;}
           case 'y': {number=50; break;}
           case 'z': {number=51; break;}
           case '0': {number=52; break;}
           case '1': {number=53; break;}
           /**************/
            case '@': {number=54; break;}
           case  '#' : {number=55; break;}
           case  '%' :  {number=56; break;}
           case  '&' : {number=57; break;}
           case  '*':  {number=58; break;}
           case '(':{number=59; break;}
           case ')':{number=60; break;}
           case '-': {number=61; break;}
           case '=':{number=62; break;}
           case '<':{number=63; break;}
           case '>': {number=64; break;}
           case '?':{number=65; break;}
            //ต้องเขียนให้ครบ 255 ตัวอักษร
           //------------------------ 2
            case ' ': {number=66; break;}
           default: {number=66; break;}  

       }
       return number;
   }       

   public void mainSearch(String text) throws IOException{
      int i=0,timecount=0;
      int m=pattern.length();
      int t=1;
      System.out.println("-------- Searching --------------");
      while(i<=(text.length()-pattern.length())){
          System.out.println("--- ความพยายามครั้งที่ :"+t+"  i="+i);
          int j=m-1, last=m-1;
          long D=(1<<m)-1;
          System.out.println(Long.toBinaryString(D));
        while(D!=0){
            
            D=D&B[gotoChar(text.charAt((i+j)))];
            System.out.println("i+j:"+(i+j)+" B:"+(B[gotoChar(text.charAt((i+j)))])+" char:"+(text.charAt((i+j))));
            j--;
            timecount++;
            if( (D&(1<<(m-1)))!=0) {
               if (j>0) 
                  last=j;
               else{
                   System.out.println("match at:"+(i+m));
                   D=0;
               }
            }//end if            
            D=D<<1;
            System.out.println("Bit D:"+Long.toBinaryString(D)+"  last:"+last);
        }//end while  
          i+=last;
          t++;
      }
    //System.out.println("Time count:"+timecount);
    }
    //*****************************
     public static void main(String args[]) throws Exception{
      SearchPhrase1 a = new SearchPhrase1("aabcz");
      a.mainSearch("aabczefgaabczefgabcdg");
  }
}
