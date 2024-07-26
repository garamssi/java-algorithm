import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String standard = br.readLine();

        String[] comparisonWords = new String[n - 1];
        for (int i = 0; i < n - 1; i++) {
            comparisonWords[i] = br.readLine();
        }

        int result = new Main().solution(standard, comparisonWords);

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    private int solution(String standardWord, String[] comparisonWords) {
        int answer = 0;
        for (String comparisonWord : comparisonWords) {
            if (isSimilar(standardWord, comparisonWord)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isSimilar(String first, String second) {
        // 길이차가 1이 넘으면 비슷한 단어가 아니다
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        // 길이가 짧은 단어가 first에 오도록 배치 
        if (first.length() > second.length()) {
            String temp = first;
            first = second;
            second = temp;
        }

        List<Character> firstList = toList(first);
        List<Character> secondList = toList(second);
        
        // 두 단어의 길이 같을 때 -> 포함하는 문자가 같거나, 하나가 다를 때 비슷한 단어
        if (firstList.size() == secondList.size()) {
            diff(firstList, secondList);
            return firstList.size() <= 1;
        } else {
        // 두 단어의 길이가 1 차이 날때 -> 포함하는 문자가 하나 다를 때 비슷한 단어
            diff(firstList, secondList);
            return firstList.isEmpty();
        }
    }

    private List<Character> toList(String first) {
        List<Character> firstList = new ArrayList<>();
        for (int i = 0; i < first.length(); i++) {
            firstList.add(first.charAt(i));
        }
        return firstList;
    }

    private void diff(List<Character> firstList, List<Character> secondList) {
        for (Character c : secondList) {
            firstList.remove(c);
        }
    }
}