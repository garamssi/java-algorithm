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

        List<String> titles = new ArrayList<>();
        List<Integer> upperScores = new ArrayList<>();

        int preUpperScore = -1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String title = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            // 중복 칭호 제거
            if (preUpperScore != score) {
                titles.add(title);
                upperScores.add(score);
            }
            preUpperScore = score;
        }

        int[] scores = new int[m];
        for (int i = 0; i < m; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        String result = new Main().solution(titles, upperScores, scores);

        bw.write(result);
        bw.flush();
        br.close();
        bw.close();
    }

    private String solution(List<String> titles, List<Integer> upperScores, int[] scores) {
        StringBuilder sb = new StringBuilder();

        for (int score : scores) {
            String title = getTitle(titles, upperScores, score);
            sb.append(title).append('\n');
        }

        return sb.toString();
    }

    private String getTitle(List<String> titles, List<Integer> upperScores, int score) {
        int left = 0;
        int right = upperScores.size() - 1;
        int answerIdx = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (score <= upperScores.get(mid)) {
                answerIdx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return titles.get(answerIdx);
    }
}