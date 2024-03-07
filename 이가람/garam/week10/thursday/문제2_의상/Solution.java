package garam.week10.thursday.문제2_의상;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 *
 * 의상
 */
public class Solution {

    public static void main(String[] args) {
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
//        String[][] clothes = {
//                {"crow_mask", "face"},
//                {"blue_sunglasses", "face"},
//                {"smoky_makeup", "face"}
//        };
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();

        // 모든 옷을 종류별로 카운트
        for (String[] item : clothes) {
            String type = item[1];
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }

        // 조합의 수를 계산
        int combinations = 1;
        for (int count : clothesMap.values()) {

            // 안입었을 경우도 있으니 + 1
            combinations *= count + 1;
        }

        // 아무것도 선택하지 않는 경우를 제외
        return combinations - 1;
    }

}
