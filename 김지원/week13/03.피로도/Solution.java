class Solution {
    int maxClear;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return maxClear;
    }

    public void dfs(int clear, int k, int[][] dungeons) {
        maxClear = Math.max(maxClear, clear);

        for (int i = 0; i < dungeons.length; i++) {
            // 던전 방문
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(clear + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
    }
}