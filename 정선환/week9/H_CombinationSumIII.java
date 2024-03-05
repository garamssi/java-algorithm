package week9;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/description/?envType=study-plan-v2&envId=leetcode-75
 * 216. Combination Sum III
 */
public class H_CombinationSumIII {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(1, curr, k, n, answer);
        return answer;
    }

    public static void backtrack(int start, List<Integer> curr, int k, int n, List<List<Integer>> answer) {
        if(curr.size() == k) {
            int sum = curr.stream().mapToInt(Integer::intValue).sum();
            if(sum == n) {
                answer.add(List.copyOf(curr));
            }
            return ;
        }

        for(int i = start; i <= 9; i++) {
            if(!curr.contains(i)) {
                curr.add(i);
                backtrack(i + 1, curr, k, n, answer);
                curr.remove(curr.size() - 1);
            }
        }
    }

}
