import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main t = new Main();
        String input = br.readLine();
        Character result = t.solution(input);
        System.out.println(result);
    }

    public Character solution(String word) {
        word = word.toUpperCase();
        Map<Character, Integer> letterCntMap = new HashMap<>();

        for (char letter : word.toCharArray()) {
            letterCntMap.put(letter, letterCntMap.getOrDefault(letter, 0) + 1);
        }

        char maxLetter = '?';
        int maxLetterCnt = 0;
        for (Character letter : letterCntMap.keySet()) {
            int letterCnt = letterCntMap.get(letter);
            if (letterCnt > maxLetterCnt) {
                maxLetter = letter;
                maxLetterCnt = letterCnt;
            } else if (letterCnt == maxLetterCnt) {
                maxLetter = '?';
            }
        }
        return maxLetter;
    }
}