import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new HashMap<>());
            graph.get(flight[0]).put(flight[1], flight[2]);
        }

        Queue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(1)));
        pq.add(Arrays.asList(src, 0, 0));

        // 타임 아웃을 방지하기 위해 한번 방문한 경로는 저장해두는 맵 선언
        Map<Integer, Integer> visited = new HashMap<>();

        while (!pq.isEmpty()) {
            List<Integer> cur = pq.poll();
            int u = cur.get(0);
            int price_u = cur.get(1);
            int k_visited = cur.get(2);

            if (u == dst) {
                return price_u;
            }

            visited.put(u, k_visited);

            if (k_visited <= k) {
                k_visited += 1;

                if (graph.containsKey(u)) {
                    for (Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) {
                        if (!visited.containsKey(v.getKey()) || k_visited < visited.get(v.getKey())) {
                            int alt = price_u + v.getValue();
                            pq.add(Arrays.asList(v.getKey(), alt, k_visited));
                        }
                    }
                }
            }
        }
        return -1;
    }
}