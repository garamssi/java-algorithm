package week30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1976
 * 여행 가자
 */
public class F_여행가자 {
    static ArrayList<Integer>[] maps;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        maps = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            maps[i] = new ArrayList<>();
        }

        for (int i = 1; i < N + 1; i++) {
            String[] connectArray = bf.readLine().split(" ");
            for (int j = 0; j < connectArray.length; j++) {
                int cityConnected = Integer.parseInt(connectArray[j]);
                if(cityConnected == 1) {
                    maps[i].add(j + 1);
                }
            }
        }

        String[] travelPath = bf.readLine().split(" ");
        for (int i = 0; i < travelPath.length - 1; i++) {
            if(!bfs(Integer.parseInt(travelPath[i]), Integer.parseInt(travelPath[i + 1]))) {
                System.out.println("NO");
                return ;
            }
        }

        System.out.println("YES");

    }

    private static boolean bfs(int start, int end) {
        Map<Integer, Boolean> visited = new HashMap<>();
        Queue<Integer> queue = new LinkedList();

        visited.put(start, true);
        queue.offer(start);

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            ArrayList<Integer> connectedCity = maps[curr];
            for (int city : connectedCity) {
                if(city == end) {
                    return true;
                }

                if(!visited.containsKey(city)) {
                    visited.put(city, true);
                    queue.offer(city);
                }
            }
        }

        return false;
    }
}
