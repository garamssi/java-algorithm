import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String explosion = br.readLine();

        String result = new Main().solution(str, explosion);
        bw.write(result.isEmpty() ? "FRULA" : result);
        br.close();
        bw.flush();
        bw.close();
    }

    private String solution(String str, String explosion) {
        Deque<Character> deque = new ArrayDeque<>();

        int el = explosion.length();

        for (char ch : str.toCharArray()) {
            if (ch == explosion.charAt(el - 1) && deque.size() >= el - 1) {
                StringBuilder temp = new StringBuilder();
                temp.append(ch);
                for (int i = 0; i < el - 1; i++) {
                    temp.append(deque.removeLast());
                }
                String reveredTemp = temp.reverse().toString();
                if (!reveredTemp.equals(explosion)) {
                    for (char c : reveredTemp.toCharArray()) {
                        deque.addLast(c);
                    }
                }
            } else {
                deque.addLast(ch);
            }
        }

        StringBuilder answer = new StringBuilder();
        while (!deque.isEmpty()) {
            answer.append(deque.removeFirst());
        }

        return answer.toString();
    }

}