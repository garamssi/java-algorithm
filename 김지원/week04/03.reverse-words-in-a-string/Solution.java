import java.util.*;

class Solution {

    public static void main(String[] args) {
        String s = "  hello world  ";
        String rs = new Solution().reverseWords(s);
        System.out.println(rs);
    }

    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();

        String word = "";
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                word += c;
            } else {
                if (!word.isEmpty()) {
                    list.add(word);
                    word = "";
                }
            }
        }

        if (!word.isEmpty()) {
            list.add(word);
        }

        Collections.reverse(list);
        return String.join(" ", list);
    }
}