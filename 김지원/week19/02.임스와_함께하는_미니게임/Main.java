import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main t = new Main();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);

        List<String> names = new ArrayList<>();

        while (!(n-- == 0)) {
            names.add(br.readLine());
        }

        System.out.println(t.solution(names, game));
    }

    public int solution(List<String> names, char game) {
        HashMap<Character, Integer> playersPerGame = new HashMap<>();
        playersPerGame.put('Y', 2);
        playersPerGame.put('F', 3);
        playersPerGame.put('O', 4);

        Set<String> distinctNames = new HashSet<>(names);

        return distinctNames.size() / (playersPerGame.get(game) - 1);
    }
}