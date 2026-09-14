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
public class Ex71 {

    public static void main(String args[]) {
        char T[] = new char[100];        
        String Text = "Word Processor Text";
        String s = "And";
        for(int i=0;i<Text.length();i++)
            T[i]=Text.charAt(i);        
        char Text1[] = InsertString(T, s, 15, Text.length());        
        System.out.println("Befor insert :" + Text+ " \nafter insert: " + convertChartoString(Text1));
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
    
    public static char[] InsertString(char T[], String S, int K, int L) {
//         String s1=Substring(T,0,K-3);
//         System.out.println(s1);
//         String s2=Substring(T,K-1,L);
//         System.out.println(s2);
//         String s3=Concatenation(Concatenation(s1,S),s2);
//         T=s3.toCharArray();
         //-----or------
         String s3=Concatenation(Concatenation(Substring(T,0,K-3),S),Substring(T,K-1,L));
         T=s3.toCharArray();
        return T;
    }
    
    public static String convertChartoString(char c[]){
        String st="";
        int k=0;
        for(k=0;k<c.length;k++){ 
            st=st+c[k];
        }
        return st;
    }
//    public static char[] InsertString1(char T[], String S, int K, int L) {
//        int J = L-1;
//        while (J >= K-1) {            
//            T[J+S.length()] = T[J];
//            J--;
//        }
//        System.out.println(T);
//        int c = 0;       
//        for (int m = K-1; m < K + S.length()-1; m++) {
//            T[m] = S.charAt(c);
//            c++;
//        }
//        return T;
//    }
}
