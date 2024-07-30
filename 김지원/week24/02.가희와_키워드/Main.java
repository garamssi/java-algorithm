import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> keywords = new HashSet<>();
        for (int i = 0; i < n; i++) {
            keywords.add(br.readLine());
        }

        String[] posts = new String[m];
        for (int i = 0; i < m; i++) {
            posts[i] = br.readLine();
        }

        String result = new Main().solution(keywords, posts);

        bw.write(result);
        bw.flush();
        br.close();
        bw.close();
    }

    private String solution(Set<String> keywords, String[] posts) {
        StringBuilder sb = new StringBuilder();
        
        for (String post : posts) {
            for (String keyword : post.split(",")) {
                keywords.remove(keyword);
            }
            sb.append(keywords.size()).append('\n');
        }
        return sb.toString();
    }
}