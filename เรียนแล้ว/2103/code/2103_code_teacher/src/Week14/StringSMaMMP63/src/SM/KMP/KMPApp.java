/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SM.KMP;

public class KMPApp {
 public static void main(String args[]) throws Exception{
         KMPAlgorithm kmp = new KMPAlgorithm();
         kmp.KMPSearch("aabcz", "aabczefgaabczefgabcdg");
  }   
}
