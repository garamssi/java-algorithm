package garam.week2.thursday.letterCombinationsOfAPhoneNumber;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number


import java.util.*;

public class Solution {

    public static void main(String[] args) {
        List<String> strings = lettersCombines("24");
        System.out.println(Arrays.toString(strings.toArray()));
    }

    public static List<String> lettersCombines(String digits){
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
