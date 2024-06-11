import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        new Main().solution(n, map);
    }

    public void solution(int n, char[][] map) {
        int[] heart = findHeartLocation(n, map);

        int leftArmLength = findLeftLength(map, heart);
        int rightArmLength = findRightArmLength(n, map, heart);
        int waistLength = findWaistLength(n, map, heart);
        int leftLegLength = findLeftLegLength(n, map, heart, waistLength);
        int rightLegLength = findRightLegLength(n, map, heart, waistLength);

        System.out.printf("%d %d\n", heart[0] + 1, heart[1] + 1);
        System.out.printf("%d %d %d %d %d\n", leftArmLength, rightArmLength, waistLength, leftLegLength, rightLegLength);
    }

    private int[] findHeartLocation(int n, char[][] map) {
        int[] heart = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isHeart(n, map, i, j)) {
                    heart[0] = i;
                    heart[1] = j;
                }
            }
        }
        return heart;
    }

    private int findRightLegLength(int n, char[][] map, int[] heart, int waistLength) {
        int startX;
        int startY;
        int rightLegLength = 0;
        startX = heart[0] + waistLength + 1;
        startY = heart[1] + 1;
        while (startX < n && map[startX][startY] == '*') {
            rightLegLength++;
            startX++;
        }
        return rightLegLength;
    }

    private int findLeftLegLength(int n, char[][] map, int[] heart, int waistLength) {
        int startY;
        int startX;
        int leftLegLength = 0;
        startX = heart[0] + waistLength + 1;
        startY = heart[1] - 1;
        while (startX < n && map[startX][startY] == '*') {
            leftLegLength++;
            startX++;
        }
        return leftLegLength;
    }

    private int findWaistLength(int n, char[][] map, int[] heart) {
        int startY;
        int startX;
        int waistLength = 0;
        startX = heart[0] + 1;
        startY = heart[1];
        while (startX < n && map[startX][startY] == '*') {
            waistLength++;
            startX++;
        }
        return waistLength;
    }

    private int findRightArmLength(int n, char[][] map, int[] heart) {
        int startX;
        int startY;
        int rightArmLength = 0;
        startX = heart[0];
        startY = heart[1] + 1;
        while (startY < n && map[startX][startY] == '*') {
            rightArmLength++;
            startY++;
        }
        return rightArmLength;
    }

    private int findLeftLength(char[][] map, int[] heart) {
        int startY;
        int startX;
        int leftArmLength = 0;
        startX = heart[0];
        startY = heart[1] - 1;
        while (startY >= 0 && map[startX][startY] == '*') {
            leftArmLength++;
            startY--;
        }
        return leftArmLength;
    }

    private boolean isHeart(int n, char[][] map, int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        if (map[x][y] != '*') {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            // 네 방향으로 이동 할 수 없다면 heart 가 아니다.
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                return false;
            }

            if (map[nx][ny] != '*') {
                return false;
            }
        }
        return true;
    }
}