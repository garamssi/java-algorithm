package garam.test;

import java.util.*;

public class TestClass {

	public static void main(String[] args) {
//		Deque<String> deque = new ArrayDeque<>();
//		deque.add("a");
//		deque.add("b");
//		deque.push("1");
//		System.out.println(deque.pop());
//		System.out.println(deque.peek());
//		System.out.println(deque.toString());

//		Map<Character, Boolean> seen = new HashMap<>();
//		seen.put('a', false);
//		seen.put('a', true);
//		System.out.println(seen.toString());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(1);
		pq.add(2);
		pq.add(3);

		System.out.println(pq.poll() + " : " + pq.poll());
		System.out.println(pq.toString());
	}
}
