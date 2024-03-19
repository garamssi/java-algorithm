import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] cn = {3, 0, 6, 1, 5};
        int rs = new Solution().solution(cn);
        System.out.println(rs);
    }

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations); // 정렬

        for (int hIndex = 1; hIndex <= citations.length; hIndex++) { 
            if (citations[citations.length - hIndex] >= hIndex) {
                answer = hIndex;
            }
        }
        return answer;
    }
}