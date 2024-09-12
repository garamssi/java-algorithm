import java.io.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        String game;
        while (!Objects.equals(game = br.readLine(), "end")) {
            boolean result = new Main().solution(game);
            if (result) {
                sb.append("valid").append("\n");
            } else {
                sb.append("invalid").append("\n");
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    private boolean solution(String game) {
        int xCnt = 0;
        int oCnt = 0;

        for (char ch : game.toCharArray()) {
            if (ch == 'X') {
                xCnt++;
            }
            if (ch == 'O') {
                oCnt++;
            }
        }

        if (xCnt == oCnt + 1) {
            // X의  bingo 여부와 상관없이, 게임이 성립
            // 판이 가득 찼을 때, X가 이기거나, 비기는 경우
            if (xCnt + oCnt == 9 && !bingo(game, 'O')) {
                return true;
            } else {
                // X 가 이기는 경우
                return bingo(game, 'X') && !bingo(game, 'O');
            }
        } else if (xCnt == oCnt) {
            // O 가 이기는 경우
            return bingo(game, 'O') && !bingo(game, 'X');
        } else {
            return false;
        }
    }

    private boolean bingo(String game, char ch) {
        // 가로
        for (int i = 0; i < 9; i += 3) {
            if (game.charAt(i) == ch && game.charAt(i + 1) == ch && game.charAt(i + 2) == ch) {
                return true;
            }
        }
        // 세로
        for (int i = 0; i < 3; i++) {
            if (game.charAt(i) == ch && game.charAt(i + 3) == ch && game.charAt(i + 6) == ch) {
                return true;
            }
        }
        // 대각선
        if (game.charAt(0) == ch && game.charAt(4) == ch && game.charAt(8) == ch) {
            return true;
        }
        return game.charAt(2) == ch && game.charAt(4) == ch && game.charAt(6) == ch;
    }
}