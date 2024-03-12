package week10;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 * 전화번호 목록
 */
public class D_전화번호목록 {
    public static void main(String[] args) {
//        String[] phone_book = {"119", "97674223", "195524421"};
//        String[] phone_book = {"123", "456", "12345"};
        String[] phone_book = {"97674223", "119", "1195524421"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        for(String phone: phone_book) {
            map.put(phone, 1);
        }

        for(String phone: phone_book) {
            StringBuilder sb = new StringBuilder();
            for (char c : phone.toCharArray()) {
                sb.append(c);

                if(phone.length() == sb.length()) {
                    continue;
                }
                if(map.containsKey(sb.toString())) {
                    return false;
                }
            }
        }

        return true;
    }
}
