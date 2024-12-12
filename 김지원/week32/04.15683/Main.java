import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
        int answer = new Main().solution(n, m, map);
        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }

    int answer = Integer.MAX_VALUE;
    int[][][] direction = {
            {{}},
            {{0}, {1}, {2}, {3}},
            {{0, 1}, {2, 3}},
            {{0, 2}, {0, 3}, {1, 2}, {1, 3}},
            {{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}},
            {{0, 1, 2, 3}}
    };
    int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int solution(int n, int m, int[][] map) {
        List<Cctv> cctvs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvs.add(new Cctv(i, j, map[i][j]));
                }
            }
        }
        dfs(0, cctvs, n, m, map);

        return answer;
    }

    private void dfs(int idx, List<Cctv> cctvs, int n, int m, int[][] map) {
        if (idx == cctvs.size()) {
            answer = Math.min(answer, calInvisiblePointCnt(n, m, map));
            return;
        }

        Cctv cctv = cctvs.get(idx);
        List<Point> visible = new ArrayList<>();

        for (int[] dirs : direction[cctv.kind]) {
            for (int dir : dirs) {
                int x = cctv.p.x;
                int y = cctv.p.y;
                while (true) {
                    x += move[dir][0];
                    y += move[dir][1];

                    if (x < 0 || x >= n || y < 0 || y >= m || map[x][y] == 6) {
                        break;
                    }

                    if (map[x][y] == 0) {
                        map[x][y] = -1;
                        visible.add(new Point(x, y));
                    }
                }
            }
            dfs(idx + 1, cctvs, n, m, map);
            for (Point point : visible) {
                map[point.x][point.y] = 0;
            }
        }
    }

    private int calInvisiblePointCnt(int n, int m, int[][] map) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Cctv {
        Point p;
        int kind;

        public Cctv(int x, int y, int kind) {
            this.kind = kind;
            p = new Point(x, y);
        }
    }
}