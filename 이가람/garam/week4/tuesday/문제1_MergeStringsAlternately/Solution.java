package garam.week4.tuesday.문제1_MergeStringsAlternately;


/**
 * https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75
 * word1, word2를 교차로 문자 하나씩 합쳐서 병합합니다.
 * ex) "abc", "def" -> "adbecf"
 * */
public class Solution {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));
    }

    public static String mergeAlternately(String word1, String word2){

        if (word1.isEmpty() || word2.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        // for 문의을 range 값으로 정하기 위해 Max를 찾는다.
        int range = Math.max(word1.length(), word2.length());

        for (int i=0; i<range; i++ ) {
            String a = "";
            String b = "";

            if(i < word1.length() ) {
                a = String.valueOf(word1.charAt(i));
            }

            if(i < word2.length() ) {
                b = String.valueOf(word2.charAt(i));
            }

            result.append(a);
            result.append(b);
        }

        return result.toString();

    }

}
