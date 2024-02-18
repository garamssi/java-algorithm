class Solution {
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>();
        int cnt = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited.contains(i)) {
                cnt++;
                dfs(i, isConnected, visited);
            }
        }

        return cnt;
    }

    private void dfs(int now, int[][] isConnected, Set<Integer> visited) {
        visited.add(now);

        for (int next = 0; next < isConnected[0].length; next++) {
            if (isConnected[now][next] == 1 && !visited.contains(next)) {
                dfs(next, isConnected, visited);
            }
        }
    }
}