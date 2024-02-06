package week5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-recent-calls/?envType=study-plan-v2&envId=leetcode-75
 * 933. Number of Recent Calls
 */
public class G_NumberOfRecentCalls {
    public static void main(String[] args) {
        G_NumberOfRecentCalls recentCounter = new G_NumberOfRecentCalls();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
//        System.out.println(recentCounter.ping(3001));
//        System.out.println(recentCounter.ping(3002));
        System.out.println(recentCounter.ping(5000));

    }

    Queue<Integer> queue = new LinkedList<>();
    public G_NumberOfRecentCalls() {

    }

    public int ping(int t) {
        queue.offer(t);
        while(queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }

}
