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
public class Ex7 {

    public static void main(String args[]) {
        char T[] = new char[100];        
        String Text = "Word Processor Text";
        String s = "And";
        for(int i=0;i<Text.length();i++)
            T[i]=Text.charAt(i);        
        char Text1[] = InsertString1(T, s, 15, Text.length());        
        System.out.println("Befor insert :" + Text+ " \nafter insert: " + convertChartoString(Text1));
    }    
    public static String convertChartoString(char c[]){
        String st="";
        int k=0;
        for(k=0;k<c.length;k++){ 
            st=st+c[k];
        }
        return st;
    }
    public static char[] InsertString1(char T[], String S, int K, int L) {
        int J = L-1;
        while (J >= K-1) {            
            T[J+S.length()] = T[J];
            J--;
        }
        System.out.println(T);
        int c = 0;       
        for (int m = K-1; m < K + S.length()-1; m++) {
            T[m] = S.charAt(c);
            c++;
        }
        return T;
    }
}
