class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(1, k, n, new ArrayList<>(), answer);
        return answer;
    }

    private void dfs(int cur, int k, int n, List<Integer> expected, List<List<Integer>> answer) {
        if (sum(expected) > n) {
            return;
        }
        
        if (expected.size() == k) {
            if (sum(expected) == n) {
                answer.add(new ArrayList<>(expected));
            }
            return;
        }

        for (int i = cur; i <= 9; i++) {
            expected.add(i);
            dfs(i + 1, k, n, expected, answer);
            expected.remove(expected.size() - 1);
        }
    }

    private int sum(List<Integer> list) {
        int sum = 0;
        for (Integer ele : list) {
            sum += ele;
        }
        return sum;
    }
}