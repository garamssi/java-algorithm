package week18;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/8979
 * 올림픽
 */
public class B_올림픽 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(line, " ");

        int count = Integer.parseInt(stringTokenizer.nextToken());
        int targetNation = Integer.parseInt(stringTokenizer.nextToken());

        List<int[]> medalList = new ArrayList<>();
        while(count-- > 0) {
            line = br.readLine();

            StringTokenizer rankStringTokenizers = new StringTokenizer(line, " ");
            int nation = Integer.parseInt(rankStringTokenizers.nextToken());
            int gold = Integer.parseInt(rankStringTokenizers.nextToken());
            int silver = Integer.parseInt(rankStringTokenizers.nextToken());
            int bronze = Integer.parseInt(rankStringTokenizers.nextToken());

            medalList.add(new int[]{nation, gold, silver, bronze});
        }

        // 등수 정렬
        medalList.sort((o1, o2) -> {
            if(o1[1] == o2[1]) {
                if(o1[2] == o2[2]) {
                    return o2[3] - o1[3];
                }
                return o2[2] - o1[2];
            }
            return o2[1] - o1[1];
        });

        if(medalList.get(0)[0] == targetNation) {
            System.out.println(1);
            return;
        }

        // 정답 추출
        int rank = 1;
        for(int i = 1; i < medalList.size(); i++) {
            int[] target = medalList.get(i);
            int[] before = medalList.get(i - 1);

            if(!(target[1] == before[1] && target[2] == before[2] && target[3] == before[3])) {
                rank = i + 1;
            }

            if(medalList.get(i)[0] == targetNation) {
                System.out.println(rank);
                return;
            }
        }
        System.out.println(rank);
    }
}
