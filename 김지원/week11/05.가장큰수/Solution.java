import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        new Solution().solution(numbers);
    }

    public String solution(int[] numbers) {
        String[] strNums = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strNums[i] = String.valueOf(numbers[i]);
        }
        // 정렬 -> 내림 차순
        Arrays.sort(strNums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        StringBuilder answer = new StringBuilder();
        for (String str : strNums) {
            answer.append(str);
        }
        
        return answer.charAt(0) == '0' ? "0" : answer.toString();
    }
}