package Integrative;
public class IntegrativeMMPAPP {
    public static void main(String args[])throws Exception{
        String P[] = {"aab", "aabc", "aade"};
        String T="aabcccdgaadeeef";
        RUMultipleMatching mmp = new RUMultipleMatching();
        System.out.println("--- ค้นโดย Aho-Corasick Algorithm ---");
        mmp.AhoSearch(P, T);
      /*  System.out.println("--- ค้นโดย SetHorspool Algorithm ---");
        mmp.HorspoolSearch(P, T);
        System.out.println("--- ค้นโดย Inverted List Algorithm ---");
        mmp.InvertedListSearch(P, T); */      
    }   
}
