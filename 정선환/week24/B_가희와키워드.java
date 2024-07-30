package week24;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/22233
 * 가희와 키워드
 */
public class B_가희와키워드 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer line1 = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(line1.nextToken());
        int M = Integer.parseInt(line1.nextToken());

        Map<String, Integer> keywordMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String keyword = bf.readLine();
            keywordMap.put(keyword, 0);
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer useKeyword = new StringTokenizer(bf.readLine(), ",");

            while(useKeyword.hasMoreTokens()) {
                String keyword = useKeyword.nextToken();
                keywordMap.put(keyword, keywordMap.getOrDefault(keywordMap, 0) + 1);
            }

            int count = (int) keywordMap.values().stream().filter(value -> value == 0).count();
            bw.write(count + "\n");
        }

        bf.close();
        bw.flush();
        bw.close();


    }
}
