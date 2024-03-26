package garam.week12.tuesday_완전탐색.문제3_모음사전;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		solution("AAA");

	}

	public static int solution(String str) {
		List<String> words = new ArrayList<>(){};
//		 'A', 'E', 'I', 'O', 'U'
		words.add("A");
		words.add("E");
		words.add("I");
		words.add("O");
		words.add("U");

		StringBuilder result = new StringBuilder();
		int count = 0;
		dfs(result, str, words, count);

		return count;
	}

	private static void dfs(StringBuilder result, String target, List<String> words, int count) {
		if (result.equals(target)) {
			return;
		}

		for(String word : words){
			result.append(word);
			dfs(result, target, words, count+1);
		}
	}


}
