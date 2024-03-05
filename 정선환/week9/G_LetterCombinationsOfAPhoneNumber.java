package week9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=leetcode-75
 * 17. Letter Combinations of a Phone Number
 */
public class G_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }



    public static List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        Map<Character, List<String>> phone = new HashMap<>();
        phone.put('2', List.of("a", "b", "c"));
        phone.put('3', List.of("d", "e", "f"));
        phone.put('4', List.of("g", "h", "i"));
        phone.put('5', List.of("j", "k", "l"));
        phone.put('6', List.of("m", "n", "o"));
        phone.put('7', List.of("p", "q", "r", "s"));
        phone.put('8', List.of("t", "u", "v"));
        phone.put('9', List.of("w", "x", "y", "z"));

        return backtrack(phone, digits, 0, new ArrayList<>(), new StringBuilder());
    }

    private static List<String> backtrack(Map<Character, List<String>> phone, String digits, int index, List<String> numberStrings, StringBuilder sb) {
        if(index >= digits.length()) {
            numberStrings.add(sb.toString());
            return numberStrings;
        }

        char c = digits.charAt(index);
        List<String> letters = phone.get(c);

        for(String letter: letters) {
            sb.append(letter);
            backtrack(phone, digits, index + 1, numberStrings, sb);
            sb.delete(sb.length() - 1, sb.length());
        }

        return numberStrings;

    }

}
