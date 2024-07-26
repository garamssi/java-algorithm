import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int teamCnt = Integer.parseInt(st.nextToken());
            int questionCnt = Integer.parseInt(st.nextToken());
            int myTeamId = Integer.parseInt(st.nextToken());
            int logEntryCnt = Integer.parseInt(st.nextToken());

            int[][] logEntries = new int[logEntryCnt][3];
            for (int i = 0; i < logEntryCnt; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                logEntries[i][0] = Integer.parseInt(st.nextToken());
                logEntries[i][1] = Integer.parseInt(st.nextToken());
                logEntries[i][2] = Integer.parseInt(st.nextToken());
            }
            int rank = new Main().solution(teamCnt, questionCnt, myTeamId, logEntryCnt, logEntries);
            sb.append(rank).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private int solution(int teamCnt, int questionCnt, int myTeamId, int logEntryCnt, int[][] logEntries) {
        myTeamId -= 1;
        // (q1Score, q2Score, q3Score ....)
        int[][] teamQuestionScore = new int[teamCnt][questionCnt];

        for (int[] logEntry : logEntries) {
            teamQuestionScore[logEntry[0] - 1][logEntry[1] - 1] = Math.max(teamQuestionScore[logEntry[0] - 1][logEntry[1] - 1], logEntry[2]);
        }
        // (teamId, score, 풀이 제출 횟수, 마지막 제출 시간)
        int[][] teamTotalScores = new int[teamCnt][4];
        for (int i = 0; i < teamCnt; i++) {
            teamTotalScores[i][0] = i;
            int sum = 0;
            for (int j = 0; j < questionCnt; j++) {
                sum += teamQuestionScore[i][j];
            }
            teamTotalScores[i][1] = sum;
        }

        for (int i = 0; i < logEntryCnt; i++) {
            int curTeamId = logEntries[i][0] - 1;
            teamTotalScores[curTeamId][2] += 1;
            teamTotalScores[curTeamId][3] = i;
        }

        Arrays.sort(teamTotalScores, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int higherScore = o2[1] - o1[1];
                if (higherScore != 0) {
                    return higherScore;
                }
                int lowerSubmissions = o1[2] - o2[2];
                if (lowerSubmissions != 0) {
                    return lowerSubmissions;
                }
                // faster submission time
                return o1[3] - o2[3];
            }
        });

        int rank = 1;
        for (int[] temScore : teamTotalScores) {
            if (temScore[0] == myTeamId) {
                return rank;
            }
            rank++;
        }

        return 0;
    }
}