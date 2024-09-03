import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] tops = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new Main().solution(n, tops);

        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public int[] solution(int n, int[] tops) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result, 0);

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && tops[i] >= tops[stack.peek()]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek() + 1;
            }

            stack.push(i);
        }

        return result;
    }
}