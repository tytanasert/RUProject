/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Char;

/**
 *
 * @author PC
 */
public class SingleChar {
    public static void main(String args[]){
        char a='A';
        char b='B';
        char st[]=new char[20];
        st="dafafa".toCharArray();
        st[0]=a;
        st[1]=b;
        System.out.println(st);
        String s="avacc aaa bbb ccc ccc bbb";
        System.out.println(s.matches("avacc aaa bbb ccc ccc bbb"));
        System.out.println(s.contains("bbb"));
        System.out.println(s.indexOf("ccc"));
    }
    
}
