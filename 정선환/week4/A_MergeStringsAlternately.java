package week4;

/**
 * https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75
 * 1768. Merge Strings Alternately
 */
public class A_MergeStringsAlternately {
    public static void main(String[] args) {
//        System.out.println(mergeAlternately("abc", "pqr"));
        System.out.println(mergeAlternately("  a   b   c", "    p   q   r"));
    }

    public static String mergeAlternately(String word1, String word2) {
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();
        int word1length = word1Array.length;
        int word2length = word2Array.length;

        int end = Math.max(word1length, word2length);

        String answer = "";
        for(int i = 0; i < end; i++) {
            if(i < word1length) {
                answer += word1Array[i];
            }
            if(i < word2length) {
                answer += word2Array[i];
            }
        }

        return answer;
    }
}
