import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());
            String result = new Main().solution(str, k);
            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    // 3. 어떤 문자를 정확히 K개를 포함하는 가장 짧은 연속 문자열의 길이를 구한다.
    // 4. 어떤 문자를 정확히 K개를 포함하고, 문자열의 첫 번째와 마지막 글자가 해당 문자로 같은 가장 긴 연속 문자열의 길이를 구한다.

    // => 어떤 문자 K개를 포함하는 문자열 중 첫 문자와 마지막 문자가 해당 문자인 경우
    private String solution(String str, int k) {
        if (k == 1) {
            return "1 1";
        }

        int[] letterCnt = new int[26];
        for (char c : str.toCharArray()) {
            letterCnt[c - 'a']++;
        }

        int min = Integer.MAX_VALUE;
        int max = -1;
        for (int i = 0; i < str.length(); i++) {
            if (letterCnt[str.charAt(i) - 'a'] < k) {
                continue;
            }

            int count = 1;
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                }
                if (count == k) {
                    min = Math.min(min, j - i + 1);
                    max = Math.max(max, j - i + 1);
                    break;
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            return "-1";
        } else {
            return min + " " + max;
        }
    }
}