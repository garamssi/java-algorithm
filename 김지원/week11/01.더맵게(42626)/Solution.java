import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> pq = new PriorityQueue<>();
        
        for (int sc : scoville) {
            pq.offer(sc);
        }
        
        int cnt = 0;
        while (pq.size() >= 2 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            
            int mix = first + second * 2;
            pq.offer(mix);
            cnt++;
        }
        
        if (pq.peek() < K) {
            return -1;
        }
        
        return cnt;
    
    }
}