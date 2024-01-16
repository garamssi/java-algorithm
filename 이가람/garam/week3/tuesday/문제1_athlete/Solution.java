package garam.week3.tuesday.문제1_athlete;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 * */
public class Solution {

	public static void main(String[] args) {

		System.out.println(canNotFinish(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
		System.out.println(canNotFinish(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
		System.out.println(canNotFinish(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));

	}

	public static String canNotFinish(String[] participant, String[] completion) {
		Map<String, Integer> map = new HashMap<>();

		for(String p : participant) {
			if(map.containsKey(p)) {
				map.put(p, map.get(p) + 1);
			} else {
				map.put(p, 1);
			}
		}

		for(String c : completion) {
			if(map.containsKey(c)) {
				int cnt = map.get(c);
				if(cnt == 1) {
					map.remove(c);
				} else {
					map.put(c, cnt - 1);
				}
			}
		}

		List<String> keys = new ArrayList<>(map.keySet());


		return keys.get(0);
	}
}
