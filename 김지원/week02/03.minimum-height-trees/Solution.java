class Solution {

    // 최소 높이를 구성하는 트리의 루트는 가장 가운데 있는 값
    // 리프 노드를 하나씩 제거해 나가면서 남아있는 값을 찾는다.
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        // edges를 기반으로 graph를 구성
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // 양방향 그래프로 구성
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // 예외 처리
        if (n == 1) {
            return List.of(0);
        }
        
        // 노드의 개수가 2개 이하 일때까지 leaf 노드를 찾아서 제거
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                int neighbor = graph.get(leaf).get(0);
                // graph.get(neighbor).remove((Object) leaf); // -> remove 함수가 remove(Object o), remove(int index)이므로 리스트 원소에 따라 적절하게 선택하여 사용하여 한다.
                graph.get(neighbor).remove(graph.get(neighbor).indexOf(leaf));
                if (graph.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }
}

/*
line 36, 37 에서 remove 함수가 리스트의 모든 원소를 조회하므로 특정 상황에서는 O(n)이 될 수 있다.
예를 들어 아래와 같은 트리가 주어졌을때...
          1
        / | \
       2  3  4
리스트를 이용한 풀이의 시간복잡도는 O(n^2) 이 될 수도 있다.

그래서 remove() 함수의 시간 복잡도 O(1) 인 Set을 이용하여 풀면 위의 상황과 관계없이 O(n) 시간복잡도에 풀 수 있다.
*/ 
class Solution2 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.putIfAbsent(edge[1], new HashSet<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();

        if (n == 1) {
            return List.of(0);
        }

        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                int neighbor = graph.get(leaf).stream().findFirst().get();
                graph.get(neighbor).remove(leaf);
                if (graph.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }
}


