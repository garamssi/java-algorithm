import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        String result = new Main().solution(n, nums);

        bw.write(result);
        br.close();
        bw.flush();
        bw.close();
    }

    public String solution(int n, int[] nums) {
        boolean[] visited = new boolean[n + 1];
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            dfs(i, i, nums, visited, result);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append("\n");
        }

        return sb.toString();
    }

    // 1 -> x -> 1 와 같이 사이클이 발생하는 수 찾기
    private void dfs(int v, int target, int[] nums, boolean[] visited, List<Integer> result) {
        if (visited[v] && v == target) {
            result.add(v);
            return;
        }

        if (!visited[v]) {
            visited[v] = true;
            dfs(nums[v], target, nums, visited, result);
            visited[v] = false;
        }
    }
}