package week15;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 * 폰캣몬
 */
public class B_폰켓몬 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,1,2,3}));
    }

    public static int solution(int[] nums) {
        int answer = nums.length / 2;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 1) + 1);
        }

        if(map.size() < answer) {
            answer = map.size();
        }

        return answer;
    }
}
