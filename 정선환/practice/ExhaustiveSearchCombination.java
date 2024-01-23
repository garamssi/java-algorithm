package practice;

import java.util.ArrayList;
import java.util.List;

public class ExhaustiveSearchCombination {
    static List<Integer> nums = new ArrayList<>();
    static List<List<Integer>> answer = new ArrayList<>();

    public static void main(String[] args) {
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        permute(nums);
        System.out.println(answer);
    }

    public static void permute(List<Integer> curr) {
        backtrack(new ArrayList<>(), 0, 2);

    }

    public static void backtrack(List<Integer> curr, int start, int k) {
        if(curr.size() == k) {
            answer.add(List.copyOf(curr));
            return ;
        }

        for (int i = start; i < nums.size(); i++) {
            if(!curr.contains(nums.get(i))) {
                curr.add(nums.get(i));
                backtrack(curr, start + 1, k);
                curr.remove(curr.size() - 1);
            }
        }
    }


}
