import java.util.*;

class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();

        Queue<Integer> radiantQ = new LinkedList<>();
        Queue<Integer> direQ = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char senator = senate.charAt(i);
            if (senator == 'R') {
                radiantQ.offer(i);
            } else {
                direQ.offer(i);
            }
        }

        while (!radiantQ.isEmpty() && !direQ.isEmpty()) {
            int ri = radiantQ.poll();
            int di = direQ.poll();

            if (ri < di) {
                radiantQ.offer(ri + n);
            } else {
                direQ.offer(di + n);
            }
        }

        return radiantQ.isEmpty() ? "Dire" : "Radiant";
    }
}