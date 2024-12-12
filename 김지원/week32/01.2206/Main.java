import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        int result = new Main().solution(n, m, map);

        bw.write(String.valueOf(result));
        br.close();
        bw.flush();
        bw.close();
    }

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    private int solution(int n, int m, int[][] map) {
        // visited[i][j][0] 벽을 부수지 않고 탐색하는 경우의 방문여부
        // visited[i][j][1] 벽을 부수고 탐색 하는 경우의 방문여부
        boolean[][][] visited = new boolean[n][m][2];

        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(0, 0, 1, false));

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.x == n - 1 && now.y == m - 1) {
                return now.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 0) { // 벽이 아니면
                        if (!now.destroyed && !visited[nx][ny][0]) {
                            q.offer(new Point(nx, ny, now.cnt + 1, false));
                            visited[nx][ny][0] = true;
                        } else if (now.destroyed && !visited[nx][ny][1]) {
                            q.offer(new Point(nx, ny, now.cnt + 1, true));
                            visited[nx][ny][1] = true;
                        }
                    } else { // 벽이면
                        if (!now.destroyed && !visited[nx][ny][1]) {
                            q.offer(new Point(nx, ny, now.cnt + 1, true));
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

    static class Point {
        int x;
        int y;
        int cnt;
        boolean destroyed;

        public Point(int x, int y, int cnt, boolean destroyed) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.destroyed = destroyed;
        }
    }
}