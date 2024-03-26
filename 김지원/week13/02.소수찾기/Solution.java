import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> primeNumbers = new HashSet<>();
    int answer = 0;
    boolean[] used;

    public int solution(String numbers) {
        used = new boolean[numbers.length()];

        dfs(0, 0, numbers);
        return answer;
    }

    private void dfs(int usedCount, int madeNumber, String numbers) {
        if (usedCount != 0 && !primeNumbers.contains(madeNumber) && isPrimeNumber(madeNumber)) {
            primeNumbers.add(madeNumber);
            answer++;
        }

        if (usedCount >= numbers.length()) {
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                int num = madeNumber * 10 + numbers.charAt(i) - '0';
                dfs(usedCount + 1, num, numbers);
                used[i] = false;
            }
        }
    }

    private boolean isPrimeNumber(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}