package garam.week9.sunday_backtracking.문제1_letterCombinationsOfAphoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/?envType=study-plan-v2&envId=leetcode-75
 * inclusive 의 숫자가 포함된 문자열이 주어지면 2-9숫자가 나타낼 수 있는 가능한 모든 문자 조합을 반환합니다.
 * 어떤 순서로든 답변을 반환하세요.
 *
 * 전화 버튼과 마찬가지로 숫자를 문자로 매핑하는 방법은 다음과 같습니다.
 * 1은 어떤 문자에도 매핑되지 않습니다.
 */
public class Solution {
	public static void main(String[] args) {
		letterCombinations("23");
	}

	public static List<String> letterCombinations(String digits){
		List<String> result = new ArrayList<>();

		if(digits.length() == 0) {
			return result;
		}

		Map<Character, List<Character>> dic = new HashMap<>();
		dic.put('0', List.of());
		dic.put('1', List.of());
		dic.put('2', List.of('a', 'b', 'c'));
		dic.put('3', List.of('d', 'e', 'f'));
		dic.put('4', List.of('g', 'h', 'i'));
		dic.put('5', List.of('j', 'k', 'l'));
		dic.put('6', List.of('m', 'n', 'o'));
		dic.put('7', List.of('p', 'q', 'r', 's'));
		dic.put('8', List.of('t', 'u', 'v'));
		dic.put('9', List.of('w','x', 'y', 'z'));

		dfs(result, dic, digits, 0, new StringBuilder());
		return result;

	}

	private static void dfs(List<String> result, Map<Character, List<Character>> dic, String digits, int index, StringBuilder path) {
		if( path.length() == digits.length() ) {
			result.add(String.valueOf(path));
			return;
		}

		for(Character c : dic.get(digits.charAt(index))) {
			dfs(result,dic, digits, index + 1, new StringBuilder(path).append(c));
		}
	}

}
