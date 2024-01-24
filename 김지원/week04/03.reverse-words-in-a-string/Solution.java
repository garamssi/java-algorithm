import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        String s = "  hello world  ";
        String rs = new Solution().reverseWords(s);
        System.out.println(rs);
    }

    public String reverseWords(String s) {
        List<String> wordList = new ArrayList<>();

        String word = "";
        for (char ch : s.toCharArray()) {
            if (ch != ' ') {
                word += ch;
            } else {
                if (!word.isEmpty()) {
                    wordList.add(word);
                    word = "";
                }
            }
        }

        if (!word.isEmpty()) {
            wordList.add(word);
        }

        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}