import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        int max = times[times.length - 1];

        return binarySearch(times, n, max);
    }

    private long binarySearch(int[] times, int n, int max) {
        long start = 1;
        long end = (long) n * max;
        long answer = Long.MAX_VALUE;
        long mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            if (isPassed(times, n, mid)) {
                answer = Math.min(answer, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }

    /**
     * 제한된 시간(allowedTime)에 모든 사람이 입국 심사를 받을 수 있는 지 검사
     *
     * @param times       심사관 한 명당 걸리는 시간
     * @param n           입국 심사를 기다리는 사람의 수
     * @param allowedTime 입국 심사에 허용된 시간
     * @return 모든 사람이 입국 심사를 받을 수 있으면 ture 그렇지 않으면 false
     * @example <pre>
     * allowedTime: 10, times: [2, 3, 4], n = 8
     * 내부 연산된 passedPerson : 10 (10/2 + 10/3 + 10/4 = 5 + 3 + 2)
     * passedPerson >= n 이므로 true
     * </pre>
     */
    private boolean isPassed(int[] times, int n, long allowedTime) {
        long passedPerson = 0;

        for (int time : times) {
            passedPerson += allowedTime / time;
        }

        return passedPerson >= n;
    }
}