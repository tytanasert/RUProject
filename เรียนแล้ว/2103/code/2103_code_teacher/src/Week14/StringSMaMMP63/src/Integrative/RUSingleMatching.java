package Integrative;
import SM.*;
public class RUSingleMatching {
   private SM.BNDM.BNDMAlgorithm bndm = new SM.BNDM.BNDMAlgorithm();
   private SM.BoyerMoore.BMAlgorithm bm = new SM.BoyerMoore.BMAlgorithm();
   private SM.KMP.KMPAlgorithm kmp = new SM.KMP.KMPAlgorithm();
   private SM.KR.KRAlgorithm kr = new SM.KR.KRAlgorithm();
   private SM.PFIVL.PPFHashAlgorithm pph = new SM.PFIVL.PPFHashAlgorithm();
   private SM.QS.QSAlgorithm qs = new SM.QS.QSAlgorithm();
   private SM.ShiftOR.ShiftORAlgorithm sor = new SM.ShiftOR.ShiftORAlgorithm();
   public void BNDMSearch(String p, String T){
       bndm.BNDMSearch(p, T);
   }
   public void BMSearch(String p, String T){
       bm.BMSearch(p, T);
   }
      public void KMPMSearch(String p, String T){
       kmp.KMPSearch(p, T);
   }
   public void KRSearch(String p, String T){
       kr.KRSearch(p, T);
   }
   
   public void PPFHSearch(String p, String T){
       pph.PPFHashSearch(p, T);
   }
   public void QSSearch(String p, String T){
       qs.QSSearch(p, T);
   }
   public void ShiftORSearch(String p, String T){
       sor.ShiftORSearch(p, T);
   }   
}
