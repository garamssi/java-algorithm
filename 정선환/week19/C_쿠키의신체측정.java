package week19;

import java.io.*;

/**
 * https://www.acmicpc.net/problem/20125
 * 쿠키의 신체 측정
 */
public class C_쿠키의신체측정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        // 머리 좌표
        Coordinate head = null;

        int x = 1;
        int loop1 = n;
        while(loop1 --> 0) {
            head = findHead(x, br.readLine());
            if(head != null) {
                break;
            }
            x++;
        }

        // 심장 좌표
        Coordinate heart = findHeart(head);
        bw.write(heart.getX() + " " + heart.getY());

        // 왼쪽 팔 길이
        String armsLine = br.readLine();
        int leftArmCount = getLeftArmCount(armsLine, heart);

        // 오른쪽 팔 길이
        int rightArmCount = getRightArmCount(armsLine, heart, n);

        // 허리
        int waistCount = 0;
        for(int i = heart.getX(); i < n; i++) {
            String line = br.readLine();
            char c = line.charAt(heart.getY() - 1);
            if(c != '*') {
                break;
            }
            waistCount++;
        }

        // 왼쪽 다리 길이
        int leftLegCount = 1;
        for(int i = heart.getX() + waistCount; i < n; i++) {
            String line = br.readLine();
            char c = line.charAt(heart.getY() - 1);
            if(c != '*') {
                break;
            }
            leftLegCount++;
        }

    }





    // 머리 좌표
    private static Coordinate findHead(int headX, String line) {
        int headY = line.indexOf("*") + 1;
        if(headY <= 0) {
            return null;
        }

        // 머리 X,Y 좌표
        return new Coordinate(headX, headY);
    }

    // 심장 좌표
    private static Coordinate findHeart(Coordinate head) {
        return new Coordinate(head.getX() + 1, head.getY());
    }

    // 왼쪽 팔 길이
    private static int getLeftArmCount(String line, Coordinate heart) {
        int leftArmCount = 0;
        for(int i = heart.getY() - 2; i > 0; i--) {
            char c = line.charAt(i);
            if(c != '*') {
                return leftArmCount;
            }
            leftArmCount++;
        }
        return leftArmCount;
    }

    // 오른쪽 팔 길이
    private static int getRightArmCount(String line, Coordinate heart, int n) {
        int rightArmCount = 0;
        for(int i = heart.getY(); i < n; i++) {
            char c = line.charAt(i);
            if(c != '*') {
                return rightArmCount;
            }
            rightArmCount++;
        }
        return rightArmCount;
    }

    // 허리 길이
    private static int getWaistCount(String line, Coordinate heart, int n) {
        int waistCount = 0;
        for(int i = heart.getX(); i < n; i++) {
            char c = line.charAt(heart.getY() - 1);
            if(c != '*') {
                return waistCount;
            }
            waistCount++;
        }
        return waistCount;
    }

    // 다리 길이
    private static int getLegCount(BufferedReader br, Coordinate heart, int waistCount, int n) throws IOException {
        int legCount = 0;
        for(int i = heart.getX() + waistCount; i < n; i++) {
            String line = br.readLine();
            char c = line.charAt(heart.getY() - 1);
            if(c != '*') {
                return legCount;
            }
            legCount++;
        }
        return legCount;
    }

    // 좌표 클래스
    static class Coordinate {
        private int x;
        private int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

}
