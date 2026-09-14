/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SM.KMP;

public class KMPApp1 {
 public static void main(String args[]) throws Exception{
         KMPAlgorithm1 kmp = new KMPAlgorithm1();
         kmp.KMPSearch("aabcz", "aabczefgaabczefgabcdg");
         //kmp.KMPSearch("aaa", "aaaaaabczefgaaabczefgaaaabcdg");
  }   
}
