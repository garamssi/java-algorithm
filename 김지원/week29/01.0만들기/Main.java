import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String result = new Main().solution(n);
            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    private String solution(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, 1, new ArrayList<>(), result);

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        for (String cur : result) {
            sb.append(cur).append("\n");
        }
        return sb.toString();
    }

    private void dfs(int n, int cur, List<String> op, List<String> result) {
        if (cur == n) {
            calculate(n, op, result);
            return;
        }

        op.add("+");
        dfs(n, cur + 1, op, result);
        op.remove(op.size() - 1);

        op.add("-");
        dfs(n, cur + 1, op, result);
        op.remove(op.size() - 1);

        op.add(" ");
        dfs(n, cur + 1, op, result);
        op.remove(op.size() - 1);
    }

    private void calculate(int n, List<String> op, List<String> result) {
        String curResult = "1";
        Deque<Integer> nums = new ArrayDeque<>(); // 계산 할 숫자 저장
        nums.addLast(1);

        List<String> removedOp = new ArrayList<>(); // 공백을 제거한 연산자
        for (int i = 2; i <= n; i++) {
            String curOp = op.get(i - 2);
            if (!curOp.equals(" ")) {
                removedOp.add(curOp);
                nums.addLast(i);
            } else {
                int curNum = !nums.isEmpty() ? nums.pollLast() : 0;
                nums.addLast(curNum * 10 + i);
            }
            curResult = curResult + curOp + i;
        }

        int sum = !nums.isEmpty() ? nums.pollFirst() : 0;
        for (String curOp : removedOp) {
            int nexNum = !nums.isEmpty() ? nums.pollFirst() : 0;
            if (curOp.equals("+")) {
                sum += nexNum;
            } else {
                sum -= nexNum;
            }
        }

        if (sum == 0) {
            result.add(curResult);
        }
    }
}