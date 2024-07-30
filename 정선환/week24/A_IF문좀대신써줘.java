package week24;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/19637
 * IF문 좀 대신 써줘
 */
public class A_IF문좀대신써줘 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer line1Tokenizer = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(line1Tokenizer.nextToken());
        int M = Integer.parseInt(line1Tokenizer.nextToken());


        // 전투력 세팅
        List<Style> styles = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer nTokenizer = new StringTokenizer(bf.readLine(), " ");
            String title = nTokenizer.nextToken();
            int power = Integer.parseInt(nTokenizer.nextToken());
            styles.add(new Style(title, power));
        }

        // 전투력 오름차순
        styles.sort(Comparator.comparing(Style::getPower));

        // 칭호 찾기
        for (int i = 0; i < M; i++) {
            int characterPower = Integer.parseInt(bf.readLine());
            String characterTitle = searchStyle(styles, characterPower);
            bw.write(characterTitle + "\n");
        }

        bf.close();
        bw.flush();
        bw.close();

    }

    private static String searchStyle(List<Style> styles, int characterPower) {
        int left = 0;
        int right = styles.size() - 1;

        while(right - left > 1) {
            int mid = (left + right) / 2;
            int midPower = styles.get(mid).getPower();

            if(midPower < characterPower) {
                left = mid;

            }else if(midPower >= characterPower){
                right = mid;

            }else {
                return styles.get(mid).getTitle();
            }
        }

        if(characterPower <= styles.get(left).getPower()) {
            return styles.get(left).getTitle();

        }else if(characterPower > styles.get(left).getPower() && characterPower <= styles.get(right).getPower()) {
            return styles.get(right).getTitle();

        }else {
            return "";
        }
    }

    static class Style {
        private String title;
        private int power;

        public Style(String title, int power) {
            this.title = title;
            this.power = power;
        }

        public String getTitle() {
            return title;
        }

        public int getPower() {
            return power;
        }
    }
}
