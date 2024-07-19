package week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.acmicpc.net/problem/2164
 * 카드2
 */
public class B_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while(queue.size() > 1) {
            shuffle(queue);
        }

        System.out.println(queue.peek());

    }

    private static void shuffle(Deque<Integer> stack) {
        stack.poll();

        if(stack.size() > 1) {
            stack.offer(stack.poll());
        }
    }

}
