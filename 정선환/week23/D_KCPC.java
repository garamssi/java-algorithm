package week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/3758
 * KCPC
 */
public class D_KCPC {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // 테스트 데이터 개수

        while(T --> 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int n = Integer.parseInt(st.nextToken()); // 팀의 개수
            int k = Integer.parseInt(st.nextToken()); // 문제의 개수
            String t = st.nextToken(); // 나의 팀 ID
            int m = Integer.parseInt(st.nextToken()); // 로그 엔트리 개수

            Map<String, Team> teamMap = new HashMap<>();
            for (int index = 0; index < m; index++) {
                st = new StringTokenizer(bf.readLine(), " ");
                String i = st.nextToken(); // 팀 ID
                String j = st.nextToken(); // 문제 번호
                int s = Integer.parseInt(st.nextToken()); // 획득한 점수

                Team team = teamMap.getOrDefault(i, new Team(i));
                team.updateScore(j, s);
                team.updateSubmitCount();
                team.updateSubmitTime(index + 1);

                teamMap.put(i, team);
            }

            List<Team> teamList = new ArrayList<>(teamMap.values());
            teamList.sort((a, b) -> {
                if(b.getTotalScore() != a.getTotalScore()) {
                    return b.getTotalScore() - a.getTotalScore();
                }else {
                    if(a.getSubmitCount() != b.getSubmitCount()) {
                        return a.getSubmitCount() - b.getSubmitCount();
                    }else {
                        return a.getSubmitTime() - b.getSubmitTime();
                    }
                }
            });

            int rank = 1;
            for (Team team : teamList) {
                if (team.getId().equals(t)) {
                    break;
                }
                rank++;
            }

            System.out.println(rank);
        }
    }


    static class Team {
        private String id;
        private Map<String, Integer> scoreMap = new HashMap<>();
        private int submitCount;
        private int submitTime;

        public Team(String id) {
            this.id = id;
        }

        public void updateScore(String problem, int score) {
            scoreMap.put(problem, Math.max(scoreMap.getOrDefault(problem, 0), score));
        }

        public void updateSubmitCount() {
            submitCount++;
        }

        public void updateSubmitTime(int time) {
            submitTime = time;
        }

        public String getId() {
            return id;
        }

        public int getTotalScore() {
            return scoreMap.values().stream().mapToInt(Integer::intValue).sum();
        }

        public int getSubmitCount() {
            return submitCount;
        }

        public int getSubmitTime() {
            return submitTime;
        }

    }
}
