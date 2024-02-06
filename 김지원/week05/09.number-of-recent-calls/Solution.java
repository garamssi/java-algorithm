import java.util.*;

class RecentCounter {
    private final static int TIME_INTERVAL = 3000;

    Queue<Integer> history = new LinkedList<>();

    public RecentCounter() {
    }

    public int ping(int t) {
        history.offer(t);

        while (!history.isEmpty() && history.peek() < t - TIME_INTERVAL) {
            history.poll();
        }

        return history.size();
    }
}