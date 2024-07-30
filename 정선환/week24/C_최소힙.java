package week24;

import java.io.*;
import java.util.PriorityQueue;

/**
 * https://www.acmicpc.net/problem/1927
 * 최소 힙
 */
public class C_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bf.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        while(n --> 0) {
            int x = Integer.parseInt(bf.readLine());
            if(x == 0) {
                int answer = 0;
                if(priorityQueue.peek() != null) {
                    answer = priorityQueue.poll();
                }
                bw.write(answer + "\n");
            }else {
                priorityQueue.add(x);
            }
        }

        bf.close();
        bw.flush();
        bw.close();;
    }
}
