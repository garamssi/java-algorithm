package hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static Set<Integer> numSet = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main t = new Main();
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String operator = st.nextToken();
            int num = 0;
            if (!operator.equals("all") && !operator.equals("empty")) {
                num = Integer.parseInt(st.nextToken());
            }
            t.solution(operator, num);
        }
        System.out.println(sb.toString());
    }

    public void solution(String operator, int num) {
        switch (operator) {
            case "add":
                add(num);
                break;
            case "remove":
                remove(num);
                break;
            case "check": {
                check(num);
                break;
            }
            case "toggle": {
                toggle(num);
                break;
            }
            case "all": {
                all();
                break;
            }
            case "empty":
                empty();
                break;
        }
    }

    private void empty() {
        numSet.clear();
    }

    private void all() {
        for (int i = 1; i <= 20; i++) {
            numSet.add(i);
        }
    }

    private void toggle(int num) {
        if (numSet.contains(num)) {
            numSet.remove(num);
        } else {
            numSet.add(num);
        }
    }

    private void check(int num) {
        if (numSet.contains(num)) {
            sb.append("1\n");
        } else {
            sb.append("0\n");
        }
    }

    private void remove(int num) {
        numSet.remove(num);
    }

    private void add(int num) {
        numSet.add(num);
    }
}