package com.cq.interview.algorithm;

/**
 * @author caoqiang
 * @date 2020/12/10下午6:30
 */
public class ArrayStringsAreEqual {

    /**
     * 两个数组求和
     * @param word1
     * @param word2
     * @return
     */
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        //System.out.println(String.join("",word1));
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for(int i=0;i<word1.length;i++) {
            sb1.append(word1[i]);
        }

        for(int i=0;i<word2.length;i++) {
            sb2.append(word2[i]);
        }
        if(sb1.toString().equals(sb2.toString())) {
            return true;
        }
        return false;
    }

    /**
     * 翻转字符串
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords(String s, int n) {
        StringBuffer sb = new StringBuffer();
        sb.append(s.substring(n, s.length()));
        sb.append(s.substring(0,n));
        return sb.toString();
    }

    public static void main(String[] args) {
//        String[] word1 = {"a", "bc"};
//        String[] word2 = {"ab", "c"};
//        System.out.println(arrayStringsAreEqual(word1, word2));

        System.out.println(reverseLeftWords("abcdef",2));
    }
}
