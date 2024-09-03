import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String start = br.readLine();
        String end = br.readLine();

        int result = new Main().solution(start, end);

        bw.write(String.valueOf(result));
        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean isMade = false;

    private int solution(String start, String end) {
        dfs(end, start);
        return isMade ? 1 : 0;
    }

    private void dfs(String after, String before) {
        if (after.length() < before.length()) {
            return;
        }

        if (after.equals(before)) {
            isMade = true;
            return;
        }

        if (after.endsWith("A")) {
            dfs(after.substring(0, after.length() - 1), before);
        }

        if (after.startsWith("B")) {
            dfs(revers(after.substring(1)), before);
        }
    }

    private String revers(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}