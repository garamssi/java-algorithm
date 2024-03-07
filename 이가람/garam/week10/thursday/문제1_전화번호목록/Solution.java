package garam.week10.thursday.문제1_전화번호목록;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 * 전화번호 목록
 */
public class Solution {

    public static void main(String[] args) {

        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution(new String[]{"123", "456", "789"}));
        System.out.println(solution(new String[]{"12", "123", "1235", "567", "88"}));

    }

    public static boolean solution(String[] phone_book) {

        Map<String, Integer> map = new HashMap<>();

        // 모든 전화번호를 해시맵에 저장
        for(String phone : phone_book) {
            map.put(phone, 0);
        }

        // 각 전화번호를 확인하면서 접두어가 되는 번호가 있는지 확인
        for(String phone : phone_book) {
            for(int i = 1; i < phone.length(); i++) {
                if(map.containsKey(phone.substring(0, i))) {
                    return false;
                }
            }
        }

        // 중복되는 접두어가 없으므로 true 반환
        return true;
    }
}
