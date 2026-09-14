
package MMP.AC;

public class AhoCorasickApp {
    public static void main(String args[])throws Exception{
        String s[]={"aab","aabc","aade"};
        String text="aabcccdgaadeeef";
        AhoCorasickAlgorithm ac = new AhoCorasickAlgorithm();
        ac.AhoCorasickSearch(s, text);  
    }
}
