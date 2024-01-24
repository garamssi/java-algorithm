import java.util.*;

class Solution {

    public static void main(String[] args) {
        String s = "  hello world  ";
        String rs = new Solution().reverseWords(s);
        System.out.println(rs);
    }

    public String reverseWords(String s) {
        Queue<Character> queue = new LinkedList<>();
        List<String> list = new ArrayList<>();

        String word = "";
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                queue.offer(c);
            } else {
                while (!queue.isEmpty()) {
                    word += queue.poll();
                }
            }
            if (!word.isEmpty()) {
                list.add(word);
                word = "";
            }
        }

        word = "";
        while (!queue.isEmpty()) {
            word += queue.poll();
        }

        if (!word.isEmpty()) {
            list.add(word);
        }

        Collections.reverse(list);
        return String.join(" ", list);
    }
}