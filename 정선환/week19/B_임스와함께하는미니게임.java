package week19;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/25757
 * 임스와 함께하는 미니게임
 */
public class B_임스와함께하는미니게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
        int n = Integer.parseInt(stringTokenizer.nextToken());
        String game = stringTokenizer.nextToken();


        // 플레이어들 중복 제거
        HashSet<String> playerSet = new HashSet<>();
        while(n --> 0) {
            String player = br.readLine();
            playerSet.add(player);
        }

        int playerSize = playerSet.size();
        int playerCount = getPlayerCount(game);

        System.out.println(playerSize / (playerCount - 1));

    }

    // 게임 인원 수
    private static int getPlayerCount(String game) {
        if("Y".equals(game)) {
            return 2;
        }
        if("F".equals(game)) {
            return 3;
        }
        if("O".equals(game)) {
            return 4;
        }
        return 0;
    }


}
