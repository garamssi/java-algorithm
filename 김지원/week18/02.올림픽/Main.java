import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main t = new Main();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Score> scores = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            scores.add(new Score(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
        }

        int rank = t.solution(scores, k);
        System.out.println(rank);
    }

    public int solution(List<Score> scores, int k) {
        Collections.sort(scores);

        int rank = 1;
        if (scores.get(0).getNumber() == k) {
            return rank;
        }

        for (int i = 1; i < scores.size(); i++) {
            if (!scores.get(i - 1).equals(scores.get(i))) {
                rank = i + 1;
            }

            if (scores.get(i).getNumber() == k) {
                return rank;
            }
        }

        return rank;
    }

    public static class Score implements Comparable<Score> {
        private int number;
        private int gold;
        private int silver;
        private int bronze;

        public Score(int number, int gold, int silver, int bronze) {
            this.number = number;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public int getNumber() {
            return number;
        }

        @Override
        public int compareTo(Score other) {
            if (this.gold < other.gold) {
                return 1;
            }
            if (this.gold > other.gold) {
                return -1;
            }

            // gold 가 같은 경우
            if (this.silver < other.silver) {
                return 1;
            }

            if (this.silver > other.silver) {
                return -1;
            }

            // silver 가 같은 경우
            return other.bronze - this.bronze;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Score score = (Score) o;
            return gold == score.gold && silver == score.silver && bronze == score.bronze;
        }

        @Override
        public int hashCode() {
            return Objects.hash(gold, silver, bronze);
        }
    }
}