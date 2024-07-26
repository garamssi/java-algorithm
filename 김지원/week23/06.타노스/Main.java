import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String result = new Main().solution(br.readLine().toCharArray());

        bw.write(result);
        bw.flush();
        br.close();
        bw.close();
    }

    private String solution(char[] str) {
        int numZero = 0;
        int numOne = 0;

        for (char ch : str) {
            if (ch == '0') {
                numZero++;
            } else {
                numOne++;
            }
        }

        // 제거해야 할 0, 1
        numOne = numOne / 2;
        numZero = numZero / 2;

        // 앞에서 부터 1 제거
        for (int i = 0; i < str.length; i++) {
            if (numOne > 0 && str[i] == '1') {
                str[i] = ' ';
                numOne--;
            }

            if (numOne == 0) {
                break;
            }
        }

        // 뒤에서 부터 0 제거
        for (int i = str.length - 1; i >= 0; i--) {
            if (numZero > 0 && str[i] == '0') {
                str[i] = ' ';
                numZero--;
            }

            if (numZero == 0) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : str) {
            if (ch != ' ') {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}