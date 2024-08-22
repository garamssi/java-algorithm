import java.io.*;
import java.util.LinkedList;
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
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new Main().solution(n, m, map);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    /*
     문제 풀이 방법
     - 도착 지점에서부터 모든 지점을 방문하며 거리를 업데이트한다.
     */
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    private int[][] solution(int n, int m, int[][] map) {
        int[][] result = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        // 도착 지점 찾기
        Point start = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    start = new Point(i, j);
                }
            }
        }

        // 모든 지점을 방문하며 거리를 업데이트한다.
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= n
                        || ny < 0 || ny >= m
                        || map[nx][ny] == 0
                        || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                result[nx][ny] = result[cur.x][cur.y] + 1;
                q.offer(new Point(nx, ny));
            }
        }

        // 원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치를 -1으로 처리
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (result[i][j] == 0 && map[i][j] == 1) {
                    result[i][j] = -1;
                }
            }
        }

        return result;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}