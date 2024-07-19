package week22;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/20920
 * 영단어 암기는 괴로워
 */
public class A_영단어암기는괴로워 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        while(n --> 0) {
            String word = bf.readLine();
            if(word.length() >= m) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> answerMap : list) {
            bw.write(answerMap.getKey()+ "\n");
        }

        bw.flush();
        bw.close();
    }
}


