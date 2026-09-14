/*
 * SearchPhrase.java
 *
 * Created on 29 �ԧ�Ҥ� 2547, 22:18 �.
 * Last update 29 �ѹ��¹ 2547,10.20 �.
 */

package SM.BoyerMoore;
import java.io.*;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Vector;

/**
 *
 * @author  user
 */
public class SearchPhrase {       
//   public char []text;  

   String pattern;
   
    public SearchPhrase(String str) {
      pattern = str;    
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
             case ' ': {number=66; break;}
           default: {number=66; break;}

       }
       return number;
   }       
 
    public void preBmBc(String x, int m, int bmBc[]){
      int i;
     // System.out.println("PreBmBc begin");
      for(i=0;i<67;++i) bmBc[i]=m;
      //System.out.println("PreBmBc begin 1");
       for(i=0;i<=m-1;++i) {
           bmBc[gotoChar(x.charAt(i))]=m-i-1;
        //    System.out.println("PreBmBc begin 2");
        // System.out.println("i:"+i+":"+bmBc[gotoChar(x.charAt(i))]);
       }
       System.out.println("\nbmBc Table:");
       for(i=0;i<bmBc.length;i++){
            System.out.print(bmBc[i]+" ");
        }
    } 
    public void suffixes(String x, int m, int suff[]){
        int f=0,g=0,i=0;
        suff[m-1]=m;
        g=m-1;
        for(i=m-2;i>=0;--i){
           if(i>g&&suff[i+m-1-f]<i-g)
               suff[i]=suff[i+m-1-f];
           else{
             if(i<g) g=i;
             f=i;
             while((g>=0)&&(x.charAt(g)==x.charAt(g+m-1-f)))
                 --g;
             suff[i]=f-g;
             
           }
        }
        System.out.println("\nsuff Table:");
       for(i=0;i<suff.length;i++){
            System.out.print(suff[i]+" ");
        }
    }
    
    public void preBmGs(String x, int m,int bmGs[]){
        int i,j,suff[]=new int[x.length()];
        suffixes(x,m,suff);
        for(i=0;i<m;++i)
            bmGs[i]=m;
        j=0;
        for(i=m-1;i>=-1;--i)
            if(i==-1||suff[i]==i+1)
                for(;j<m-1-i;++j)
                    if(bmGs[j]==m)
                        bmGs[j]=m-1-i;
        for(i=0;i<=m-2;++i)
            bmGs[m-1-suff[i]]=m-1-i;
      //  System.out.println("proBmGs OK");
      System.out.println("\nbmGs Table:");
       for(i=0;i<bmGs.length;i++){
            System.out.print(bmGs[i]+" ");
        }
    }
    
    public long BM(String x, int m, String y,int n){
        int i,j,bmGs[]=new int[x.length()], bmBc[]=new int[67];
        //preprocessing
        preBmGs(x,m,bmGs);
        preBmBc(x,m,bmBc);
        int timecount=0;
        //***Seraching***
        long tb=System.nanoTime();
        j=0;
        while(j<=(n-m)){
            //System.out.println("j Search:"+j+":"+y.charAt(j)+"n-m:"+(n-m));
            for(i=m-1;i>=0&&x.charAt(i)==y.charAt(i+j);--i){timecount++;};
                if(i<0){
                    System.out.println("match at:"+(j+m));
                    j+=bmGs[0];
                }
                else{
                   // j+=MAX(bmGs[i],bmBc[gotoChar(y.charAt(i+j))])-m+1+i;
                    int k=MAX(bmGs[i],bmBc[gotoChar(y.charAt(i+j))])-m+1+i;
                    if(k==0||k<0) j++;
                    else j+=k;
                  //  System.out.println("MAX Return :"+k);
                    timecount++;
                }
               // System.out.println("Affer for:"+j+" n-m:"+(n-m));
        }//end while
        System.out.println("Time count:"+timecount);
        long te=System.nanoTime();
       // System.out.println("time:"+(te-tb));
        return te-tb;
    }
    public int MAX(int x, int y){
        if(x>=y) return x;
        else
            return y;
    }
    public long mainSearch(String text) throws IOException{                        
              return BM(pattern,pattern.length(), text, text.length());

    }
//        public static void main(String args[]) throws Exception{
//         SearchPhrase a = new SearchPhrase("aaaa");
//         a.mainSearch("aaaaaaaabcdeabcdaaaabcd");
//  }
}
