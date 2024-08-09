import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String[] operators = new String[n];
        for (int i = 0; i < n; i++) {
            operators[i] = br.readLine();
        }
        String result = new Main().solution(str, operators);
        bw.write(result);
        br.close();
        bw.flush();
        bw.close();
    }

    private String solution(String str, String[] operators) {
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (char ch : str.toCharArray()) {
            left.push(ch);
        }

        for (String operator : operators) {
            String[] op = operator.split(" ");
            if (op[0].equals("L")) {
                if (!left.isEmpty()) {
                    right.push(left.pop());
                }
            } else if (op[0].equals("D")) {
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }
            } else if (op[0].equals("B")) {
                if (!left.isEmpty()) {
                    left.pop();
                }
            } else {
                left.push(op[1].charAt(0));
            }
        }

        Stack<Character> reversedLeft = new Stack<>();
        while (!left.isEmpty()) {
            reversedLeft.push(left.pop());
        }

        StringBuilder result = new StringBuilder();
        while (!reversedLeft.isEmpty()) {
            result.append(reversedLeft.pop());
        }

        while (!right.isEmpty()) {
            result.append(right.pop());
        }

        return result.toString();
    }
}
