import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1          -> 1
2~7(6개)    -> 2 
8~19(12개)  -> 3
20~37(18개) -> 4
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main t = new Main();
        int n = Integer.parseInt(br.readLine());
        int result = t.solution(n);
        System.out.println(result);
    }

    public int solution(int n) {
        int max = 1;
        int cnt = 1;
        while (n > max) {
            max += 6 * cnt;
            cnt++;
        }
        return cnt;
    }
}