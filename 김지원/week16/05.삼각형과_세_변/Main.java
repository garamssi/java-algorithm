import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final String EQUILATERAL = "Equilateral";
    private static final String ISOSCELES = "Isosceles";
    private static final String SCALENE = "Scalene";
    private static final String INVALID = "Invalid";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main t = new Main();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            String result = t.solution(a, b, c);
            System.out.println(result);
        }
    }

    public String solution(int a, int b, int c) {
        if (!isTriangle(a, b, c)) {
            return INVALID;
        } else if (isEquilateral(a, b, c)) {
            return EQUILATERAL;
        } else if (isIsosceles(a, b, c)) {
            return ISOSCELES;
        } else {
            return SCALENE;
        }
    }

    private boolean isTriangle(int a, int b, int c) {
        return a + b > c && b + c > a && a + c > b;
    }

    private boolean isEquilateral(int a, int b, int c) {
        return a == b && b == c;
    }

    private boolean isIsosceles(int a, int b, int c) {
        return a == b || b == c || a == c;
    }
}