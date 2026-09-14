
package SM.BoyerMoore;
public class BMAlgorithm {       
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

       }
       return number;
   }       
 
    public void preBmBc(String p, int m, int bmBc[]){
      int i;

      for(i=0;i<52;++i) bmBc[i]=m;
       for(i=0;i<=m-1;++i) {
           bmBc[gotoChar(p.charAt(i))]=m-i-1;
       }
    } 
    public void suffixes(String p, int m, int suff[]){
        int f=0,g=0,i=0;
        suff[m-1]=m;
        g=m-1;
        for(i=m-2;i>=0;--i){
           if(i>g&&suff[i+m-1-f]<i-g)
               suff[i]=suff[i+m-1-f];
           else{
             if(i<g) g=i;
             f=i;
             while((g>=0)&&(p.charAt(g)==p.charAt(g+m-1-f)))
                 --g;
             suff[i]=f-g;
             
           }
        }
    }
    
    public void preBmGs(String p, int m,int bmGs[]){
        int i,j,suff[]=new int[p.length()];
        suffixes(p,m,suff);
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
    }
    
    public void BMSearch(String p, String T){
        int i,j,bmGs[]=new int[p.length()], bmBc[]=new int[52];
        int m = p.length();
        int n=T.length();
        //preprocessing
        preBmGs(p,m,bmGs);
        preBmBc(p,m,bmBc);
        //***Seraching***
        long tb=System.nanoTime();
        j=0;
        while(j<=n-m){
            for(i=m-1;i>=0&&p.charAt(i)==T.charAt(i+j);--i); 
                if(i<0){
                    //System.out.println("match at:"+(j+m)); OR //Last Character
                    System.out.println("ค้นพบที่ตำแหน่ง:"+(j+1)); //first character
                    j+=bmGs[0];
                }
                else{
                    j+=MAX(bmGs[i],bmBc[gotoChar(T.charAt(i+j))])-m+1+i;
                }
        }//end while
    }
    public int MAX(int x, int y){
        if(x>=y) return x;
        else
            return y;
    }    
}
