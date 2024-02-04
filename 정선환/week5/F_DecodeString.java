package week5;

import java.util.ArrayDeque;
import java.util.Deque;

public class F_DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
//        System.out.println(decodeString("3[a2[c]]"));
    }

    public static String decodeString(String s) {
        return decode(s);
    }

    public static String decode(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        int multiple = 1;

        int length = s.length();
        for(int i = length - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                multiple = Character.getNumericValue(c);
                for(int j = 0; j < multiple; j++) {
                    String text = sb.toString();
                    answer.append(text);
                }

                sb = new StringBuilder();

            }else if(c == ']') {
                continue;
            }else if(c == '['){
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }else {
                stack.push(c);
            }
        }
        return answer.toString();
    }

//    public static String decode(String s) {
//        StringBuilder sb = new StringBuilder();
//        int multiple = 1;
//        for (char c : s.toCharArray()) {
//            if(Character.isDigit(c)) {
//                multiple = Character.getNumericValue(c);
//
//            }else if(c == '[') {
//                int openParenthesesIndex = s.indexOf(String.valueOf(c));
//                String parenthesesText = s.substring(openParenthesesIndex + 1);
//                String text = decode(parenthesesText);
//
//                StringBuilder sb2 = new StringBuilder();
//                for(int i = 0; i < multiple; i++) {
//                    sb2.append(text);
//                }
//                sb.append(sb2);
//
//            }else if(c == ']') {
//                StringBuilder sb2 = new StringBuilder();
//                for(int i = 0; i < multiple; i++) {
//                    sb2.append(sb);
//                }
//                return sb2.toString();
//
//            }else {
//                sb.append(c);
//            }
//        }
//
//        return sb.toString();
//    }
}
