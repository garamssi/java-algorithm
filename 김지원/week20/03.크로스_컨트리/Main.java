import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main t = new Main();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            int[] ranking = new int[m];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                ranking[j] = Integer.parseInt(st.nextToken());
            }

            int first = t.solution(ranking);
            System.out.println(first);
        }
    }

    public int solution(int[] ranking) {
        Map<Integer, Integer> teamPlayerCount = new HashMap<>();
        for (int team : ranking) {
            teamPlayerCount.put(team, teamPlayerCount.getOrDefault(team, 0) + 1);
        }
        // 6명 이하 참가 팀 탈락
        Set<Integer> eliminatedTeams = new HashSet<>();
        for (Integer team : teamPlayerCount.keySet()) {
            if (teamPlayerCount.get(team) < 6) {
                eliminatedTeams.add(team);
            }
        }

        // 각 선수의 점수 계산
        int[] scores = new int[ranking.length];
        int rank = 1;
        for (int i = 0; i < ranking.length; i++) {
            if (eliminatedTeams.contains(ranking[i])) {
                scores[i] = 0;
            } else {
                scores[i] = rank++;
            }
        }

        // 각 팀의 점수 계산(+ 각 팀의 5등 점수 계산)
        Map<Integer, Integer> teamScores = new TreeMap<>();
        Map<Integer, Integer> teamPlayerCountForScore = new HashMap<>();
        Map<Integer, Integer> fivePlacePlayerScores = new HashMap<>();
        for (int i = 0; i < ranking.length; i++) {
            int team = ranking[i];
            teamPlayerCountForScore.put(team, teamPlayerCountForScore.getOrDefault(team, 0) + 1);

            if (teamPlayerCountForScore.getOrDefault(team, 0) <= 4) {
                teamScores.put(team, teamScores.getOrDefault(team, 0) + scores[i]);
            }

            if (teamPlayerCountForScore.getOrDefault(team, 0) == 5) {
                fivePlacePlayerScores.put(team, scores[i]);
            }
        }

        // 1등 팀 계산
        int minScore = Integer.MAX_VALUE;
        for (Integer score : teamScores.values()) {
            if (score != 0) {
                minScore = Math.min(minScore, score);
            }
        }

        // 1등 팀이 중복인 경우 -> 5번째 선수의 점수가 낮은 팀이 승리
        int minFivePlayerPlayerScore = Integer.MAX_VALUE;
        int firstPlaceTeam = 0;
        for (Integer team : teamScores.keySet()) {
            if (teamScores.get(team) == minScore) {
                if (fivePlacePlayerScores.get(team) < minFivePlayerPlayerScore) {
                    minFivePlayerPlayerScore = fivePlacePlayerScores.get(team);
                    firstPlaceTeam = team;
                }
            }
        }
        return firstPlaceTeam;
    }
}