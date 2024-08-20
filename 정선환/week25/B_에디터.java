package week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.acmicpc.net/problem/1406
 * 에디터
 */
public class B_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Deque<Character> left = new LinkedList<>();
        Deque<Character> right = new LinkedList<>();

        for (char ch : s.toCharArray()) {
            left.push(ch);
        }

        while (M-- > 0) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "L":
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;
                case "D":
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;
                case "B":
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                case "P":
                    left.push(command[1].charAt(0));
                    break;
            }
        }

        while (!left.isEmpty()) {
            right.push(left.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb.toString());
    }
}
