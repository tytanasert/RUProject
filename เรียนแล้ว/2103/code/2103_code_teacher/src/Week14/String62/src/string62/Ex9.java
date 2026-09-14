/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string62;

/**
 *
 * @author PC
 */
public class Ex9 {

    public static void main(String args[]) {
        char T[] = new char[100];        
        String Text = "Word Test Text Test Processing Test";
        String q = "exam";
        String p="Test";
        for(int i=0;i<Text.length();i++)
            T[i]=Text.charAt(i);        
        char Text1[] = DeleteString(T, p);        
        System.out.println("Befor deletion :" + Text+ " \nAfter deletion: " + convertChartoString(Text1));
    }
    public static char[] DeleteString(char T[], String p){
        int K=Index(convertChartoString(T), p);
        System.out.println("K="+K);
        while(K!=-1){
            T=Delete(T,p, K, T.length-1, p.length());
            K=Index(convertChartoString(T), p);
            System.out.println(T);
            System.out.println("K=>"+K);
        }
        return T;
    }
    
    public static char[] Delete(char T[],String p, int K, int n,int L){
        String T1 = Substring(T, 0, K-2);
        String T2 = Substring(T, K+L, n);
        String t  = Concatenation(T1, T2);
        System.out.println(T1+"\n"+T2+"\n"+t);
        T=copyStringtoChar(T,t);
        return T;
    }
    public static char[] copyStringtoChar(char C[],String S){
       // char C[] = new char[S.length()];
        for(int i=0;i<S.length();i++)
            C[i]=S.charAt(i);
        return C;
    }
    
    public static int Index(String S, String p){ 
        int pos=-1;
        int s=S.length()-(p.length());        
        int k=0;
        System.out.println(S.length());
        while(k<=s){
            int i=0;
            while ((p.charAt(i) == S.charAt(k+i))) {              
                  i++; 
                  //System.out.println(":-->"+S.charAt(i)+":"); 
              if(i==p.length()-1){
                pos=k+1; return pos;
              }                  
            }
              k++;
            }
        return pos;
        }

    public static String Substring(char S[], int begin, int end){        
        String st="";
        int k=0;
        while(k<=end){
            if (k>=begin){
                st=st+S[k];
            }
            k++;
        }
        return st;
    }
    
    public static String Concatenation(String S1, String S2){        
        int k=0;
        while(k<S2.length()){
            S1 = S1+S2.charAt(k);
            k++;
        }            
     return S1;
    }
        
    public static String convertChartoString(char c[]){
        String st="";
        int k=0;
        for(k=0;k<c.length;k++){ 
            st=st+c[k];
        }
        return st;
    }
}
