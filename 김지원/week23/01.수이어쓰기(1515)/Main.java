import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        int result = new Main().solution(input);

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    private int solution(String str) {
        int p = 0;
        for (int num = 1; ; num++) {
            String numStr = String.valueOf(num);
            for (char digit : numStr.toCharArray()) {
                if (str.charAt(p) == digit) {
                    p++;
                }

                if (p == str.length()) {
                    return num;
                }
            }
        }
    }
}