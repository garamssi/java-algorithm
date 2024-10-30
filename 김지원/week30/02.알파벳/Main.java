import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        int result = new Main().solution(map, n, m);
        bw.write(String.valueOf(result));
        br.close();
        bw.flush();
        bw.close();
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = 0;

    private int solution(char[][] map, int n, int m) {
        boolean[] visited = new boolean[26];
        dfs(0, 0, 1, map, n, m, visited);
        return answer;
    }

    private void dfs(int x, int y, int cnt, char[][] map, int n, int m, boolean[] visited) {
        visited[map[x][y] - 'A'] = true;
        answer = Math.max(answer, cnt);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n &&
                    ny >= 0 && ny < m &&
                    !visited[map[nx][ny] - 'A']) {
                dfs(nx, ny, cnt + 1, map, n, m, visited);
                visited[map[nx][ny] - 'A'] = false;
            }
        }
    }
}
