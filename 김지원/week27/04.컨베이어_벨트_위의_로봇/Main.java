import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int beltLen = 2 * n;
        int[] durability = new int[beltLen];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < beltLen; i++) {
            durability[i] = Integer.parseInt(st.nextToken());
        }

        int result = new Main().solution(durability, k);

        bw.write(String.valueOf(result));
        br.close();
        bw.flush();
        bw.close();
    }

    private int solution(int[] durability, int k) {
        int step = 0;
        Belt belt = new Belt(durability, k);

        while (!belt.checkExit()) {
            step++;
            belt.doStep();
        }
        return step;
    }

    static class Belt {
        private int start;
        private int end;
        private int len;
        private boolean[] robot;
        private int[] durability;
        private int k;

        public Belt(int[] durability, int k) {
            this.durability = durability;
            len = durability.length;
            robot = new boolean[len];
            start = 0;
            end = (len / 2) - 1;
            this.k = k;
        }

        public void doStep() {
            rotate();
            move();
            upRobot();
        }

        public boolean checkExit() {
            int zeroCnt = 0;
            for (int i = 0; i < len; i++) {
                if (durability[i] == 0) {
                    zeroCnt++;
                }
            }
            return zeroCnt >= k;
        }

        private void rotate() {
            start = prePoint(start);
            end = prePoint(end);
            downRobot();
        }

        private void move() {
            int to = end;
            int from = prePoint(end);

            while (start != to) {
                if (!robot[to] && robot[from] && durability[to] > 0) {
                    robot[from] = false;
                    robot[to] = true;
                    durability[to]--;
                    downRobot();
                }
                to = prePoint(to);
                from = prePoint(from);
            }
        }

        private void upRobot() {
            if (durability[start] == 0) {
                return;
            }

            if (robot[start]) {
                return;
            }

            robot[start] = true;
            durability[start]--;
        }

        private void downRobot() {
            if (robot[end]) {
                robot[end] = false;
            }
        }

        private int prePoint(int point) {
            return (point + len - 1) % len;
        }
    }
}