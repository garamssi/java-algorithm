package garam.week8.tursday_Heap_PriorityQueue.문제1_SmallestNumberInInfiniteSet;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {



    public static void main(String[] args) {

//        [null,null,1,2,3,null,1,4,5]

        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2); // 2는 이미 집합에 있으므로 변화 없음

        System.out.println(smallestInfiniteSet.popSmallest()); // 1 반환하고 집합에서 제거
        System.out.println(smallestInfiniteSet.popSmallest()); // 2 반환하고 집합에서 제거

        System.out.println(smallestInfiniteSet.popSmallest()); // 3 반환하고 집합에서 제거

        smallestInfiniteSet.addBack(1); // 1을 집합에 다시 추가

        System.out.println(smallestInfiniteSet.popSmallest()); // 1 반환하고 집합에서 제거
        System.out.println(smallestInfiniteSet.popSmallest()); // 4 반환하고 집합에서 제거
        System.out.println(smallestInfiniteSet.popSmallest()); // 5 반환하고 집합에서 제거

    }

    static class SmallestInfiniteSet {

        private PriorityQueue<Integer> queue;

        private int smallest = 0;

        public SmallestInfiniteSet() {
            queue = new PriorityQueue<>();
        }

        public void addBack(int num) {
            if (!queue.contains(num)) {
                queue.offer(num); // 힙에 숫자 추가
            }
        }

        public int popSmallest() {
            addBack(++smallest);
            return queue.poll();
        }
    }
}
