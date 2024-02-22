class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        dfs(0, rooms, visited);

        return visited.size() == rooms.size();
    }

    private void dfs(int now, List<List<Integer>> rooms, Set<Integer> visited) {
        visited.add(now);

        for (Integer next : rooms.get(now)) {
            if (!visited.contains(next)) {
                dfs(next, rooms, visited);
            }
        }
    }
}
