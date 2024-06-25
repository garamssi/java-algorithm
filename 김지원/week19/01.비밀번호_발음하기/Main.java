import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String ACCEPTABLE_FORMAT = "<%s> is acceptable.";
    private static final String UNACCEPTABLE_FORMAT = "<%s> is not acceptable.";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main t = new Main();

        String password = null;
        while (!(password = br.readLine()).equals("end")) {
            t.solution(password);
        }
    }

    public void solution(String password) {
        boolean isAcceptable = con1(password) && con2(password) && con3(password);
        if (isAcceptable) {
            System.out.println(String.format(ACCEPTABLE_FORMAT, password));
        } else {
            System.out.println(String.format(UNACCEPTABLE_FORMAT, password));
        }
    }

    // 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
    private boolean con1(String password) {
        boolean a = false;
        boolean e = false;
        boolean i = false;
        boolean o = false;
        boolean u = false;

        for (char letter : password.toCharArray()) {
            if (letter == 'a') {
                a = true;
            }

            if (letter == 'e') {
                e = true;
            }

            if (letter == 'i') {
                i = true;
            }

            if (letter == 'o') {
                o = true;
            }

            if (letter == 'u') {
                u = true;
            }
        }

        return a || e || i || o || u;
    }

    // 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
    private boolean con2(String password) {
        char pre = ' ';
        int seqCnt = 0;

        for (char letter : password.toCharArray()) {
            if ((isVowel(pre) && isVowel(letter)) || (isConsonant(pre) && isConsonant(letter))) {
                seqCnt++;
            } else {
                seqCnt = 1;
            }
            if (seqCnt == 3) {
                return false;
            }
            pre = letter;
        }
        return true;
    }

    // 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
    private boolean con3(String password) {
        char pre = ' ';
        for (char letter : password.toCharArray()) {
            if (pre == letter && !(pre == 'e') && !(pre == 'o')) {
                return false;
            }
            pre = letter;
        }
        return true;
    }

    private boolean isVowel(char letter) {
        return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u';
    }

    private boolean isConsonant(char pre) {
        return !isVowel(pre);
    }
}