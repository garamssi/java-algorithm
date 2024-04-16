package garam.week15;

import java.util.*;
import java.util.stream.Collectors;

public class 폰켓몬 {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{3, 1, 2, 3}));
		System.out.println(solution(new int[]{3, 3, 3, 2, 2, 4}));
		System.out.println(solution(new int[]{3, 3, 3, 2, 2, 2}));
	}

	public static int solution(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}

		// 내가 가져갈 수 있는 포켓몬
		int own = nums.length / 2;

		if(own < 1) {
			return 0;
		}

		// 포켓몬 담기
		Map<Integer, Integer> map = new HashMap<>();
		for(int num : nums) {
			map.putIfAbsent(num, map.getOrDefault(num, 0) + num);
		}

		List<Integer> keys = map.keySet().stream().collect(Collectors.toList());

		// 키 사이즈가 많으면 내가 가져갈 수 있는 포켓몬 리턴
		if(keys.size() >= own)
			return own;

		// 내가 가져갈 수 있는 포켓몬보다 키가 적으면 키 사이즈로 리턴
		return keys.size();
	}
}
