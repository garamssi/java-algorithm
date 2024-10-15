import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[] input = mapToBoolean(br.readLine());
        boolean[] target = mapToBoolean(br.readLine());

        int result = new Main().solution(n, input, target);
        bw.write(String.valueOf(result));
        br.close();
        bw.flush();
        bw.close();
    }

    static boolean[] mapToBoolean(String input) {
        boolean[] result = new boolean[input.length()];
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '1') {
                result[i] = true;
            }
        }
        return result;
    }

    private int solution(int n, boolean[] input, boolean[] target) {
        boolean[] on = input; // 0번째 스위치를 눌렀을 경우
        boolean[] off = Arrays.copyOf(on, on.length);
        on[0] = !on[0];
        on[1] = !on[1];

        int onCount = 1;
        int offCount = 0;

        // on
        for (int i = 1; i < n; i++) {
            if (on[i - 1] != target[i - 1]) {
                onCount++;
                revers(on, i, n);
            }
        }

        int count = -1;
        if (equalBoolean(on, target)) {
            count = onCount;
        }

        // off
        for (int i = 1; i < n; i++) {
            if (off[i - 1] != target[i - 1]) {
                offCount++;
                revers(off, i, n);
            }
        }

        if (equalBoolean(off, target)) {
            count = count != -1 ? Math.min(count, offCount) : offCount;
        }

        return count;
    }

    private boolean equalBoolean(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    private void revers(boolean[] input, int i, int n) {
        if (i == 0) {
            input[0] = !input[0];
            input[1] = !input[1];
        } else if (i == n - 1) {
            input[i] = !input[i];
            input[i - 1] = !input[i - 1];
        } else {
            input[i] = !input[i];
            input[i - 1] = !input[i - 1];
            input[i + 1] = !input[i + 1];
        }
    }
}