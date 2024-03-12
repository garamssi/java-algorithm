package week10;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 * 의상
 */
public class E_의상 {
    public static void main(String[] args) {
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"yellow_hat", "headgear"},

                {"blue_sunglasses", "eyewear"},
                {"blue_sunglasses", "eyewear"},

                {"green_turban", "headgear2"},
                {"green_turban", "headgear2"},

//                {"green_turban", "headgear3"},
//                {"green_turban", "headgear4"},
//                {"green_turban", "headgear4"},
        };

//        String[][] clothes = {
//                {"yellow_hat", "headgear"}
//        };

//        String[][] clothes = {
//                {"crow_mask", "face"},
//                {"blue_sunglasses", "face"},
//                {"smoky_makeup", "face"}
//        };
        System.out.println(solution(clothes));
    }


    public static int solution(String[][] clothes) {
        int length = clothes.length;

        // 한개 이하 옷은 갯수 만큼 리턴
        if(length <= 1) {
            return length;
        }

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < length; i++) {
            String key = clothes[i][1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int answer = 1;

        // +1 , -1 해야하는 이유 해설
        // 해설) https://school.programmers.co.kr/questions/46417
        for (int value : map.values()) {
            answer *= (value + 1);
        }

        return answer - 1;
    }


}
