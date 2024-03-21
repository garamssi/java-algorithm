class Solution {
    private int count = 0;
    private int answer = 0;

    public int solution(String word) {
        char[] alpha = {'A', 'E', 'I', 'O', 'U'};
        dfs("", alpha, word);
        return answer - 1; // 빈문자열("")은 순번에서 제외
    }

    private void dfs(String made, char[] alpha, String word) {
        if (made.length() > 5) {
            return;
        }

        count++;
        if (made.equals(word)) {
            answer = count;
            return;
        }

        for (int i = 0; i < 5; i++) {
            dfs(made + alpha[i], alpha, word);
        }
    }
}