package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1205
 * 등수 구하기
 */
public class A_등수구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();

        StringTokenizer st = new StringTokenizer(line, " ");
        int n = Integer.parseInt(st.nextToken());
        int myScore = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        List<Integer> rankList = new ArrayList<>();
        if(n > 0) {
            String rankListLine = bf.readLine();
            st = new StringTokenizer(rankListLine, " ");
            while(st.hasMoreElements()) {
                rankList.add(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(getMyRank(rankList, myScore, p));

    }

    private static int getMyRank(List<Integer> rankList, int myScore, int p) {
        int size = rankList.size();
        if(size == p && myScore <= rankList.get(size - 1)) {
            return -1;
        }

        rankList.add(myScore);
        Collections.sort(rankList, Collections.reverseOrder());

        int rank = 1;
        for (int score : rankList) {
            if (score <= myScore) {
                break;
            }
            rank++;
        }

        return rank;


    }

}
