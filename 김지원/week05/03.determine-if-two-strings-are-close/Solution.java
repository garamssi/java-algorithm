import java.util.*;

/*
두개의 단어가 "close"한 문자인가?

operation1: 기존 문자 중 두 개의 문자를 서로 교환한다.
- "close" 하려면, 같은 종류의 문자들을 가져야된다. word1 = abc, word2=bca

operation2: 기존 한 문자와 같은 모든 문자를, 다른 한 문자와 같은 모든 문자들과 교환한다.
- "close" 하려면, 문자들의 개수 빈도가 같아야 한다.
 word1 => aaabbc {a=3, b=2, c=1}
 word2 => bbbaac {a=2, b=3, c=1}
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean rs = solution.closeStrings("cabbba", "abbccc");
        System.out.println(rs);
    }

    public boolean closeStrings(String word1, String word2) {
        // 단어의 길이가 다르면 false
        if (word1.length() != word2.length()) {
            return false;
        }

        // (문자, 빈도) Map 을 만든다.
        Map<Character, Integer> word1Map = new HashMap<>();
        for (char ch : word1.toCharArray()) {
            word1Map.put(ch, word1Map.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> word2Map = new HashMap<>();
        for (char ch : word2.toCharArray()) {
            word2Map.put(ch, word2Map.getOrDefault(ch, 0) + 1);
        }

        // 동일한 문자들의 집합인지 확인
        for (Character ch : word1Map.keySet()) {
            if (!word2Map.containsKey(ch)) {
                return false;
            }
        }
        for (Character ch : word2Map.keySet()) {
            if (!word1Map.containsKey(ch)) {
                return false;
            }
        }

        // 문자의 빈도가 같은지 계산
        List<Integer> frq1 = new ArrayList<>(word1Map.values());
        ArrayList<Integer> frq2 = new ArrayList<>(word2Map.values());
        Collections.sort(frq1);
        Collections.sort(frq2);

        return frq1.equals(frq2);
    }

    public boolean closeStrings2(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int alphabetSize = 26;
        int[] word1Arr = new int[alphabetSize];
        int[] word2Arr = new int[alphabetSize];

        for (int i = 0; i < word1.length(); i++) {
            word1Arr[word1.charAt(i) - 'a']++;
            word2Arr[word2.charAt(i) - 'a']++;
        }

        // 같은 종류의 문자를 가지는 조건을 위반하면 false
        for (int i = 0; i < alphabetSize; i++) {
            if (word1Arr[i] > 0 && word2Arr[i] == 0) {
                return false;
            }
            if (word2Arr[i] > 0 && word1Arr[i] == 0) {
                return false;
            }

//            if(((word1Arr[i] == 0) != (word2Arr[i] == 0))){
//                return false;
//            }
        }

        // 문자의 빈도가 같은지 계산
        Arrays.sort(word1Arr);
        Arrays.sort(word2Arr);
        return Arrays.equals(word1Arr, word2Arr);
    }
}