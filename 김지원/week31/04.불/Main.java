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

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        int result = new Main().solution(n, m, map);

        bw.write(result != -1 ? String.valueOf(result) : "IMPOSSIBLE");
        br.close();
        bw.flush();
        bw.close();
    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    private int solution(int n, int m, char[][] map) {
        Queue<Point> jQueue = new ArrayDeque<>();
        Queue<Point> fQueue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'J') {
                    jQueue.offer(new Point(i, j));
                }
                if (map[i][j] == 'F') {
                    fQueue.offer(new Point(i, j));
                }
            }
        }

        while (!jQueue.isEmpty() || !fQueue.isEmpty()) {
            // 불 이동
            int fSize = fQueue.size();
            for (int i = 0; i < fSize; i++) {
                Point cur = fQueue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                            (map[nx][ny] == '.' || map[nx][ny] == 'J')) {
                        fQueue.offer(new Point(nx, ny));
                        map[nx][ny] = 'F';
                    }
                }
            }

            // 지훈 이동
            int jSize = jQueue.size();
            for (int i = 0; i < jSize; i++) {
                Point cur = jQueue.poll();

                if (cur.x == 0 || cur.x == n - 1 ||
                        cur.y == 0 || cur.y == m - 1) {
                    return cur.time + 1;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                            map[nx][ny] == '.') {
                        jQueue.offer(new Point(nx, ny, cur.time + 1));
                        map[nx][ny] = 'J';
                    }
                }
            }
        }

        return -1;
    }

    static class Point {
        int x;
        int y;
        int time;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.time = 0;
        }

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}