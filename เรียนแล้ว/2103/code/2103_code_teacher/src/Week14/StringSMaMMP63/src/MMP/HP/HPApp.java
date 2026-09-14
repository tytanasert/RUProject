
package MMP.HP;
public class HPApp {
    public static void main(String args[])throws Exception{
        String P[]={"aab","aabc","aade"};
        String T="aabcccdgaadeeef";
        HPAlgorithm hp = new HPAlgorithm();
        hp.HPSearch(P, T);  
    }
}
