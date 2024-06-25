import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main t = new Main();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int myScore = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if (n == 0) {
            System.out.println(1);
            return;
        }

        int[] scores = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        int result = t.solution(n, p, myScore, scores);
        System.out.println(result);
    }

    public int solution(int n, int p, int myScore, int[] scores) {
        TreeMap<Integer, Integer> totalScores = new TreeMap<>((o1, o2) -> o2 - o1);
        for (int score : scores) {
            totalScores.put(score, totalScores.getOrDefault(score, 0) + 1);
        }
        totalScores.put(myScore, totalScores.getOrDefault(myScore, 0) + 1);

        int rank = 1;
        int peopleCnt = 0;
        for (Integer score : totalScores.keySet()) {
            peopleCnt += totalScores.get(score);
            if (peopleCnt > p) {
                return -1;
            }
            if (score == myScore) {
                return rank;
            }
            rank += totalScores.get(score);
        }
        return rank;
    }
}