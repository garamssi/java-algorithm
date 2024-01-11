import java.util.PriorityQueue;

// 우선 순위 큐를 이용한 풀이
// 시간복잡도: nlog(n)
class Solution {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scovillePq = new PriorityQueue<>();

        for (int sco : scoville) {
            scovillePq.offer(sco);
        }
        
        while (scovillePq.size() >= 2 && scovillePq.peek() < K) {
            int first = scovillePq.poll();
            int second = scovillePq.poll();
            int mix = first + second * 2;
            scovillePq.offer(mix);
        }

        if (!scovillePq.isEmpty() && scovillePq.peek() >= K) {
            return scoville.length - scovillePq.size();
        }
        return -1;
    }
}