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

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // 1.자주 나오는 단어일수록 앞에 배치
                int frequencyComparison = o2.getValue().compareTo(o1.getValue());

                if (frequencyComparison != 0) {
                    return frequencyComparison;
                }

                // 2.해당 단어의 길이가 길수록 앞에 배치
                int lengthComparison = Integer.compare(o2.getKey().length(), o1.getKey().length());
                if (lengthComparison != 0) {
                    return lengthComparison;
                }

                // 3.알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for (Map.Entry<String, Integer> answerMap : list) {
            bw.write(answerMap.getKey()+ "\n");
        }

        bw.flush();
        bw.close();
    }
}


