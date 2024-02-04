package garam.week5.thursday.문제3_DecodeString;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/decode-string/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class Solution {
    public static void main(String[] args) {
//        System.out.println(decodeString("3[a]2[bc]")); // "aaabcbc"
        System.out.println(decodeString("10[a2[c]]")); // "accaccacc"
//        System.out.println(decodeString("2[abc]3[cd]ef")); // abcabccdcdcdef"

    }

    public static String decodeString(String s) {

        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<StringBuilder> strBuild = new ArrayDeque<>();
        StringBuilder str = new StringBuilder();
//        StringBuilder digits = new StringBuilder();

        int num = 0;

        // 문자열 개수만큼 반복
        for (char c : s.toCharArray()) {

            // 숫자라면.
//            Character.isDigit(c); -> 느림;
            if (c >= '0' && c <= '9') {
//                digits.append(c);
                num = num * 10 + c - '0'; // 어려움,

//                System.out.println(num);
//                System.out.println(Integer.parseInt(digits.toString()));

            } else if (c == '[') { // 문자열 반복 시작
                strBuild.push(str);
                str = new StringBuilder();
                numStack.push(num); // 숫자로 반복해야하니까 스택에 넣음,
//                numStack.push(Integer.parseInt(digits.toString())); // 숫자로 반복해야하니까 스택에 넣음,

                num = 0; // 초기화
//                digits = new StringBuilder(); // 초기화

            } else if (c == ']') { // 끝,
                StringBuilder temp = str; // 현재 기준 문자
                str = strBuild.pop(); // 이전 문자 가져오기
                int count = numStack.pop();
                // "aaa".repeat(10);
                // str.append(temp.toString().repeat(num));
                while (count-- > 0) {
                    str.append(temp); // 이전 문자 기준에서 카운트만큼 현재 기준 문자 반복해서 추가
                }
            } else {
                // 문자 값,
                str.append(c);
            }
        }

        return str.toString();
    }
}
