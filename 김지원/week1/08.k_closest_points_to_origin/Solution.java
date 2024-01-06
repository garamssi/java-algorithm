import java.util.PriorityQueue;

// 우선 순위 큐를 이용한 풀이
// 시간복잡도: nlog(n)
class Solution {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int[] point : points) {
            pq.offer(new Point(point[0], point[1]));
        }

        int[][] answer = new int[k][2];

        for (int i = 0; i < k; i++) {
            Point point = pq.poll();
            answer[i][0] = point.x;
            answer[i][1] = point.y;
        }

        return answer;
    }

    public static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private int calDistance() {
            return x * x + y * y;
        }

        @Override
        public int compareTo(Point o) {
            return this.calDistance() - o.calDistance();
        }
    }
}