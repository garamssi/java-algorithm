package garam.week10.tuesday_스택.같은숫자는싫어;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906?language=java
 * 같은 숫자는 싫어
 */
public class Solution {
    public static void main(String[] args) {
        int[] solution = solution(new int[]{1, 1, 3, 3, 0, 1, 1});
        System.out.println(solution);
    }

    public static int[] solution(int[] arr) {

        if(arr.length == 0) {
            return new int[]{};
        }

        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (list.get(list.size()-1) != arr[i]) {
                list.add(arr[i]);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }


}
