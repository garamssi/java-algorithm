package garam.week1.thursday.문제5_hot;

import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        System.out.println(hot(new int[]{1, 2, 3, 9, 10, 12}, 7));

    }

    public static int hot(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s : scoville) {
            pq.add(s);
        }

        int answer = 1;
        while (pq.size() >= 2) {
            pq.add(pq.poll() + (pq.poll() * 2));

            if (pq.peek() >= K) {
                return answer;
            }

            answer++;
        }

        return -1;
    }
}
