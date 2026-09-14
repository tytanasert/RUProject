package SM.KMP;

public class KMPAlgorithm {

    int kmpNext[];

    public void KMPSearch(String p, String T) {
        int m = p.length();
        int n = T.length();

        // create lps[] that will hold the longest 
        // prefix suffix values for pattern 
        kmpNext = new int[m];
        int j = 0; // index for pat[] 

        // Preprocess the pattern (calculate lps[] 
        // array) 
        //preProcessing(p, m, kmpNext); 
        preKMP(p);

        int i = 0; // index for txt[] 
        while (i < n) {
            if (p.charAt(j) == T.charAt(i)) {
                j++;
                i++;
            }
            if (j == m) {
                System.out.println("ค้นพบที่ตำแหน่ง: " + ((i-j)+1));
                j = kmpNext[j - 1];
            } // mismatch after j matches 
            else if (i < n && p.charAt(j) != T.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters, 
                // they will match anyway 
                if (j != 0) {
                    j = kmpNext[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
    }

    void preKMP(String p) {
        // length of the previous longest prefix suffix 
        int v = 0;
        int i = 1;
        kmpNext[0] = 0; // lps[0] is always 0 

        // the loop calculates lps[i] for i = 1 to M-1 
        while (i < p.length()) {
            if (p.charAt(i) == p.charAt(v)) {
                v++;
                kmpNext[i] = v;
                i++;
            } else // (pat[i] != pat[len]) 
            {
                // This is tricky. Consider the example. 
                // AAACAAAA and i = 7. The idea is similar 
                // to search step. 
                if (v != 0) {
                    v = kmpNext[v - 1];

                    // Also, note that we do not increment 
                    // i here 
                } else // if (len == 0) 
                {
                    kmpNext[i] = v;
                    i++;
                }
            }
        }
    }

}
