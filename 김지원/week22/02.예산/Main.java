import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] budgets = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
        }
        int totalBudget = Integer.parseInt(br.readLine());

        int result = new Main().solution(budgets, totalBudget);

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    private int solution(int[] budgets, int totalBudget) {
        int left = 1;
        int right = Arrays.stream(budgets).max().getAsInt();

        int maxBudgetLimit = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isAllowed(mid, budgets, totalBudget)) {
                maxBudgetLimit = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return maxBudgetLimit;
    }

    private boolean isAllowed(int budgetLimit, int[] budgets, int totalBudget) {
        int sum = 0;
        for (int budget : budgets) {
            sum += Math.min(budget, budgetLimit);
        }
        return sum <= totalBudget;
    }
}