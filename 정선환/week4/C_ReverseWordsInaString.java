package week4;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 * 151. Reverse Words in a String
 */
public class C_ReverseWordsInaString {
    public static void main(String[] args) {
//        System.out.println(reverseWords("the sky is blue"));
//        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        String answer = "";
        String[] stringArray = s.strip().replaceAll("\\s+", " ").split(" ");
        for(int i = stringArray.length - 1; i >= 0; i--) {
            if(i == 0) {
                answer += stringArray[i];
                continue;
            }
            answer += stringArray[i] + " ";
        }
        return answer;
    }
}
