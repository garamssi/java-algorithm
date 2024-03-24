class Solution {

    private int answer = 51;

    public int solution(String begin, String target, String[] words) {
        boolean[] used = new boolean[words.length];
        dfs(begin, 0, used, target, words);
        return answer > 50 ? 0 : answer;
    }

    private void dfs(String word, int count, boolean[] used, String target, String[] words) {
        if (word.equals(target)) {
            answer = Math.min(count, answer);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!used[i] && canTransform(word, words[i])) {
                used[i] = true;
                dfs(words[i], count + 1, used, target, words);
                used[i] = false;
            }
        }
    }

    public boolean canTransform(String from, String to) {
        int count = 0;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) != to.charAt(i)) {
                count += 1;
            }
        }
        return count == 1;
    }
}