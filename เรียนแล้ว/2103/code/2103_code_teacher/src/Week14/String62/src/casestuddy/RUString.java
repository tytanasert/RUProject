/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casestuddy;

public class RUString {    
    public void TraverseString(char s[]) {
        int k = 0;
        while (k < s.length) {
            System.out.print(s[k]);
            k++;
        }
        System.out.println();
    }

    public String Substring(char S[], int begin, int end) {
        String st = "";
        int k = 0;
        while (k <= end) {
            if (k >= begin) {
                st = st + S[k];
            }
            k++;
        }
        return st;
    }

    public int Index(String S, String p) {
        int pos = -1;
        int s = S.length() - (p.length());
        int k = 0;
        //System.out.println(S.length());
        while (k <= s) {
            int i = 0;
            while ((p.charAt(i) == S.charAt(k + i))) {
                i++;
                //System.out.println(":-->"+S.charAt(i)+":"); 
                if (i == p.length() - 2) {
                    pos = k + 1;
                    return pos;
                }
            }
            k++;
        }
        return pos;
    }

    public String Concatenation(String S1, String S2) {
        int k = 0;
        while (k < S2.length()) {
            S1 = S1 + S2.charAt(k);
            k++;
        }
        return S1;
    }

    public int StringLength(String S) {
        int k = 0;
        int length = 0;
        while (k < S.length()) {
            length++;
            k++;
        }
        return length;
    }

    public char[] InsertString1(char T[], String S, int K, int L) {
        int J = L - 1;
        while (J >= K - 1) {
            T[J + S.length()] = T[J];
            J--;
        }
        System.out.println(T);
        int c = 0;
        for (int m = K - 1; m < K + S.length() - 1; m++) {
            T[m] = S.charAt(c);
            c++;
        }
        return T;
    }

    public char[] InsertString(char T[], String S, int K, int L) {
        String s3 = Concatenation(Concatenation(Substring(T, 0, K - 3), S), Substring(T, K - 1, L));
        T = s3.toCharArray();
        return T;
    }

    public String convertChartoString(char c[]) {
        String st = "";
        int k = 0;
        for (k = 0; k < c.length; k++) {
            st = st + c[k];
        }
        return st;
    }

    public char[] ReplaceString(char T[], String p, String q) {
        int K = Index(convertChartoString(T), p);
        System.out.println("K=" + K);
        while (K != -1) {
            T = Replace(T, p, q, K, T.length - 1);
            K = Index(convertChartoString(T), p);
            System.out.println(T);
            System.out.println("K=>" + K);
        }
        return T;
    }

    public char[] Replace(char T[], String p, String q, int K, int n) {
        String T1 = Substring(T, 0, K - 2);
        String T2 = Substring(T, K + (p.length() - 1), n);
        String t = Concatenation(T1, Concatenation(q, T2));
        System.out.println(T1 + "\n" + T2 + "\n" + t);
        T = copyStringtoChar(T, t);
        return T;
    }

    public char[] copyStringtoChar(char C[], String S) {
        // char C[] = new char[S.length()];
        for (int i = 0; i < S.length(); i++) {
            C[i] = S.charAt(i);
        }
        return C;
    }

    public char[] DeleteString(char T[], String p) {
        int K = Index(convertChartoString(T), p);
        System.out.println("K=" + K);
        while (K != -1) {
            T = Delete(T, p, K, T.length - 1, p.length());
            K = Index(convertChartoString(T), p);
            System.out.println(T);
            System.out.println("K=>" + K);
        }
        return T;
    }

    public char[] Delete(char T[], String p, int K, int n, int L) {
        String T1 = Substring(T, 0, K - 2);
        String T2 = Substring(T, K + L, n);
        String t = Concatenation(T1, T2);
        System.out.println(T1 + "\n" + T2 + "\n" + t);
        T = copyStringtoChar(T, t);
        return T;
    }

    public void BF(String T, String p) {
        for (int j = 0; j <= (T.length() - p.length()); j++) {
            int i = 0;
            while ((i < p.length()) && (T.charAt(j + i) == p.charAt(i))) {
                i++;

            }
            if (i >= p.length()) {
                System.out.println("found at:" + (j + 1));
            }
        }

    }

}
