/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caseStudy;
//import Integrative.*;
import MMP.*;
/**
 *
 * @author Dell
 */
public class RUMultipleMatching {
   private MMP.AC.AhoCorasickAlgorithm AHO = new  MMP.AC.AhoCorasickAlgorithm();
   private MMP.HP.HPAlgorithm HP = new MMP.HP.HPAlgorithm();
   private MMP.IVL.IVLAlgorithm IVL = new MMP.IVL.IVLAlgorithm();
   public void AhoSearch(String P[], String T) throws Exception{
       AHO.AhoCorasickSearch(P, T);
   }
   public void HorspoolSearch(String P[], String T) throws Exception{
       HP.HPSearch(P, T);
   }
   public void InvertedListSearch(String P[], String T) throws Exception{
       IVL.IVLSearch(P, T);
   }
}
