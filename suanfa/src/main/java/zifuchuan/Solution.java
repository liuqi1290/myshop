package zifuchuan;

import java.net.MalformedURLException;
import java.net.URL;

public class Solution {
    /* 给你一个文本串 T ，一个非空模板串 S ，问 S 在 T 中出现了多少次
     数据范围： 1≤len(S)≤500000,1≤len(T)≤1000000要求：空间复杂度 O(len(S))，时间复杂度 O(len(S)+len(T))*/
    public int kmp(String T, String S) {
        int[] next = getNext(S);
        int j = 0;
        for (int i = 0; i < T.length(); i++) {
            while (j > 0 && T.charAt(i) != S.charAt(j)) {
                j = next[j - 1];
            }
            if (T.charAt(i) == S.charAt(j)) {
                j++;
            }
            if (j == S.length()) {
                return 1;
            }

        }

        return j;
    }

    /*
     * 求next数组
     * @param s
     * @return
     *
     */
    private int[] getNext(String s) {
        //定义一个next数组，
        int[] next = new int[s.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }

            next[i] = j;
        }

        return next;
    }

    public static void main(String[] args) throws MalformedURLException {
        URL u =new URL("http://www.r.com");
        System.out.println(u);
    }
}
