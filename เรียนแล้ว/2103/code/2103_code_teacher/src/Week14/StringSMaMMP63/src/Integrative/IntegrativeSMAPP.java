package Integrative;
public class IntegrativeSMAPP {
   public static void main(String args[]){
       String p = "aabcz";
       String T = "aabczefgaabczefgabcdg";
       RUSingleMatching sm = new RUSingleMatching();
       System.out.println("--- ค้นโดย BNDM Algorithm ---");
       sm.BNDMSearch(p, T);
     /*  System.out.println("--- ค้นโดย Boyer Moore Algorithm ---");
       sm.BMSearch(p, T);
       System.out.println("--- ค้นโดย KMP Algorithm ---");
       sm.KMPMSearch(p, T);
       System.out.println("--- ค้นโดย Karp-Rabin Algorithm ---");
       sm.KRSearch(p, T);
       System.out.println("--- ค้นโดย PPFHash Algorithm ---");
       sm.PPFHSearch(p, T);
       System.out.println("--- ค้นโดย Quick Seach Algorithm ---");
       sm.QSSearch(p, T);
       System.out.println("--- ค้นโดย Shift OR Algorithm ---");
       sm.ShiftORSearch(p, T); */          
   }        
}
