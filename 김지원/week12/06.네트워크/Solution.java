import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        int result = new Solution().solution(n, computers);
        System.out.println(result);
    }
    private int[] parent;

    public int solution(int n, int[][] computers) {
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            findParent(i);
        }
        
        return Arrays.stream(parent).boxed().collect(Collectors.toSet()).size();
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