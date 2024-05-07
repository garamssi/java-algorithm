package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.acmicpc.net/problem/1157
 * 단어 공부
 */
public class A_단어공부 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
    }

    public static String solution(String str) {
        if(str == null || str.isEmpty()) {
            return "?";
        }

        Map<Character, Integer> map = new HashMap<>();

        String strLowerCase = str.toLowerCase();
        for(Character c : strLowerCase.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<int[]> list = new ArrayList<>();
        for (Character c : map.keySet()) {
            list.add(new int[]{c, map.get(c)});
        }

        if(list.size() == 0) {
            return "";
        }

        list.sort((a, b) -> Integer.compare(b[1], a[1]));

        if(list.size() > 1 && list.get(0)[1] == list.get(1)[1]) {
            return "?";
        }

        char c = (char) list.get(0)[0];
        return String.valueOf(c).toUpperCase();
    }
}
