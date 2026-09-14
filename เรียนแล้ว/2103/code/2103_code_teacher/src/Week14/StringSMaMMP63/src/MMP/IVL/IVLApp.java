package MMP.IVL;
import MMP.HP.*;
public class IVLApp {
    public static void main(String args[])throws Exception{
        String P[]={"aab","aabc","aade"};
        String T="aabcccdgaadeeef";
        IVLAlgorithm ivl = new IVLAlgorithm();
        ivl.IVLSearch(P, T);  
    }
}
