class Solution {

    int answer = 0;

    public int minReorder(int n, int[][] connections) {
        List<List<Node>> graph = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] con : connections) {
            graph.get(con[0]).add(new Node(con[1], 1));
            graph.get(con[1]).add(new Node(con[0], 0));
        }

        dfs(0, graph, visited);

        return answer;
    }

    private void dfs(int now, List<List<Node>> graph, Set<Integer> visited) {
        visited.add(now);

        for (Node next : graph.get(now)) {
            if (!visited.contains(next.to)) {
                if (next.dir == 1) {
                    answer++;
                }
                dfs(next.to, graph, visited);
            }
        }
    }

    // 1 => +, 0 => -
    class Node {
        int to;
        int dir;

        Node(int to, int dir) {
            this.to = to;
            this.dir = dir;
        }
    }
}