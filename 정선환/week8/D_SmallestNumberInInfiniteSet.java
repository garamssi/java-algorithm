package week8;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/smallest-number-in-infinite-set/description/?envType=study-plan-v2&envId=leetcode-75
 * 2336. Smallest Number in Infinite Set
 */
public class D_SmallestNumberInInfiniteSet {

    PriorityQueue<Integer> priorityQueue;
    int smallestValue = 0;

    public static void main(String[] args) {
        D_SmallestNumberInInfiniteSet inInfiniteSet = new D_SmallestNumberInInfiniteSet();
        inInfiniteSet.addBack(2);
        System.out.println(inInfiniteSet.popSmallest());
        System.out.println(inInfiniteSet.popSmallest());
        System.out.println(inInfiniteSet.popSmallest());
        inInfiniteSet.addBack(1);
        System.out.println(inInfiniteSet.popSmallest());
        System.out.println(inInfiniteSet.popSmallest());
        System.out.println(inInfiniteSet.popSmallest());
    }

    // 생성자
    public D_SmallestNumberInInfiniteSet() {
        priorityQueue = new PriorityQueue<>();
    }

    public int popSmallest() {
        addBack(++smallestValue);
        return priorityQueue.poll();
    }

    public void addBack(int num) {
        if(!priorityQueue.contains(num)) {
            priorityQueue.offer(num);
        }
    }



    /**
     * Your SmallestInfiniteSet object will be instantiated and called as such:
     * SmallestInfiniteSet obj = new SmallestInfiniteSet();
     * int param_1 = obj.popSmallest();
     * obj.addBack(num);
     */
}
