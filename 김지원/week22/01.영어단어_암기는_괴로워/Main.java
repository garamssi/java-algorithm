import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        String result = new Main().solution(n, m, words);

        bw.write(result);
        bw.flush();
        br.close();
        bw.close();
    }

    private String solution(int n, int m, String[] words) {
        List<String> wordList = new ArrayList<>();
        for (String word : words) {
            if (word.length() >= m) {
                wordList.add(word);
            }
        }

        Comparator<String> comparator = getComparator(wordList);

        TreeSet<String> wordSet = new TreeSet<>(comparator);
        wordSet.addAll(wordList);

        StringBuilder sb = new StringBuilder();
        for (String word : wordSet) {
            sb.append(word).append("\n");
        }

        return sb.toString();
    }

    /*
    비교 조건
    1. 자주 나오는 단어일수록 앞에 배치한다.
    2. 해당 단어의 길이가 길수록 앞에 배치한다.
    3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
     */
    private Comparator<String> getComparator(List<String> wordList) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : wordList) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        Comparator<String> comparator = (o1, o2) -> {
            if (wordCountMap.get(o2) > wordCountMap.get(o1)) {
                return 1;
            }
            if (wordCountMap.get(o2) == wordCountMap.get(o1)) {
                if (o2.length() > o1.length()) {
                    return 1;
                } else if (o2.length() == o1.length()) {
                    return o1.compareTo(o2);
                } else {
                    return -1;
                }
            }
            return -1;
        };
        return comparator;
    }
}