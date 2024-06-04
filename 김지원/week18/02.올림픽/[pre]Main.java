import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main t = new Main();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] scores = new int[n][4];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = t.solution(scores, k);
        System.out.println(result);
    }

    public int solution(int[][] scores, int k) {
        // sort
        Arrays.sort(scores, compareCondition());

        int rank = 1;
        if (scores[0][0] == k) {
            return rank;
        }

        for (int i = 1; i < scores.length; i++) {
            if (!equals(scores, i - 1, i)) {
                rank = i + 1;
            }

            if (k == scores[i][0]) {
                return rank;
            }
        }

        return rank;
    }

    private boolean equals(int[][] scores, int i, int j) {
        return scores[i][1] == scores[j][1]
                && scores[i][2] == scores[j][2]
                && scores[i][3] == scores[j][3];
    }

    private Comparator<int[]> compareCondition() {
        return (o1, o2) -> {
            if (o1[1] < o2[1]) {
                return 1;
            }

            if (o1[1] > o2[1]) {
                return -1;
            }

            // o1[1] == o2[1]
            if (o1[2] < o2[2]) {
                return 1;
            }

            if (o1[2] > o2[2]) {
                return -1;
            }

            // o1[2] == o2[2]
            return o2[3] - o1[3];
        };
    }
}