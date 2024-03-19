import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] cn = {3, 0, 6, 1, 5};
        // {0, 1, 3, 5, 6}
        int rs = new Solution().solution(cn);
        System.out.println(rs);
    }

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 1; i <= citations.length; i++) {
            if (citations[citations.length - i] >= i) {
                answer = i;
            }
        }
        return answer;
    }
}