package week17;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11723
 * 집합
 */
public class B_집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int commandSize = Integer.parseInt(br.readLine());
        Set<Integer> S = new HashSet<>();
        Set<Integer> allS = new HashSet<>();
        Set<Integer> emptyS = new HashSet<>();

        for(int i = 0; i < 20; i++) {
            allS.add(i + 1);
        }

        for(int i = 0; i < commandSize; i++) {
            String read = br.readLine();
            StringTokenizer st = new StringTokenizer(read);
            String command = st.nextToken();

            if(command.equals("add")) {
                S.add(Integer.parseInt(st.nextToken()));

            } else if(command.equals("check")) {
                if(S.contains(Integer.parseInt(st.nextToken()))) {
                    bw.write(1 + "\n");
                }else {
                    bw.write(0 + "\n");
                }

            } else if(command.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                if(S.contains(x)) {
                    S.remove(x);
                } else {
                    S.add(x);
                }
            } else if(command.equals("remove")) {
                S.remove(Integer.parseInt(st.nextToken()));

            } else if(command.equals("all")) {
                S = new HashSet<>(allS);

            } else if(command.equals("empty")) {
                S = new HashSet<>(emptyS);

            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
