import java.util.Arrays;

// 크루스칼 알고리즘 ->  최소 신장 트리 구하기
// 신장트리 -> 하나의 그래프에서 모든 노드를 포함하면서 사이클이 존재하지 않는 부분 그래프
class Solution {

    private int[] parent;

    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        // 이동 비용이 작은 순서로 정렬
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        int totalCost = 0;
        for (int[] cost : costs) {
            if (findParent(cost[0]) != findParent(cost[1])) {
                union(cost[0], cost[1]);
                totalCost += cost[2];
            }
        }
        return totalCost;
    }

    private int findParent(int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    private void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}