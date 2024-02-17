package garam.week1.thursday.문제4_kclosest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        System.out.println(kclosest(new int[][]{{3,3},{6,-1}, {-2,4}}, 2));
    }

    public static int[][] kclosest(int[][] points, int k) {

        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparing(a -> a.distance));

        for(int[] point : points) {

            long distance =(long) point[0] * point[0] + (long) point[1] + point[1];

            pq.add(new Point(distance, point));
        }

        int[][] results = new int[k][];
        for(int i=0; i<k; i++) {
            results[i] = pq.poll().point;
        }

        return results;
    }

    public static class Point{
        long distance;
        int[] point;

        public Point(long distance, int[] point){
            this.distance = distance;
            this.point = point;
        }
    }
}
