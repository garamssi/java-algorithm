package week19;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/4659
 * 비밀번호 발음하기
 */
public class A_비밀번호발음하기 {
    public static void main(String[] args) throws IOException {
        String input;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while((input = br.readLine()) != null) {
            if("end".equals(input)) {
                br.close();
                bw.flush();
                bw.close();

                return ;
            }

            bw.write(solution(input));
        }
    }

    public static String solution(String input) {
        String answer = "<" + input + "> ";

        if(isCondition(input)) {
            return answer + "is acceptable. \n";
        }

        return answer + "is not acceptable. \n";
    }

    private static boolean isCondition(String input) {
        // 1. 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
        if(!input.contains("a") && !input.contains("e") && !input.contains("i") && !input.contains("o") && !input.contains("u")) {
            return false;
        }

        // 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
        int vowelCount = 0;
        int consonantCount = 0;
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCount++;
                consonantCount = 0;
            }else {
                consonantCount++;
                vowelCount = 0;
            }

            if(vowelCount == 3 || consonantCount == 3) {
                return false;
            }
        }


        // 3. 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
        String saveC = null;
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(saveC == null) {
                saveC = String.valueOf(c);
                continue;
            }

            if(saveC.equals(String.valueOf(c)) && (c != 'e' && c != 'o')) {
                return false;
            }

            saveC = String.valueOf(c);
        }

        return true;
    }
}
