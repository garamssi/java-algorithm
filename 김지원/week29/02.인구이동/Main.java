import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int l;
    static int r;
    static int[][] map;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = new Main().solution();

        bw.write(String.valueOf(result));
        br.close();
        bw.flush();
        bw.close();
    }

    private int solution() {
        int moveCnt = 0;
        while (true) {
            boolean[][] visited = new boolean[n][n];
            boolean move = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        List<Node> alliance = bfs(i, j, visited);
                        if (alliance.size() > 1) {
                            movePopulation(alliance);
                            move = true;
                        }
                    }
                }
            }

            if (!move) {
                return moveCnt;
            }
            moveCnt++;
        }
    }

    private List<Node> bfs(int x, int y, boolean[][] visited) {
        Queue<Node> queue = new ArrayDeque<>();
        List<Node> alliance = new ArrayList<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;
        alliance.add(new Node(x, y));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < n &&
                        ny >= 0 && ny < n &&
                        !visited[nx][ny]) {
                    int diff = Math.abs(map[nx][ny] - map[cur.x][cur.y]);

                    if (diff >= l && diff <= r) {
                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny));
                        alliance.add(new Node(nx, ny));
                    }
                }
            }
        }
        return alliance;
    }

    private void movePopulation(List<Node> alliance) {
        int avg = (int) alliance.stream()
                .map(node -> map[node.x][node.y])
                .mapToInt(i -> i)
                .average()
                .getAsDouble();

        for (Node node : alliance) {
            map[node.x][node.y] = avg;
        }
    }


    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}