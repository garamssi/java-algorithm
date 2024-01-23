package practice;

import java.util.ArrayList;
import java.util.List;

public class ExhaustiveSearchPermutation {
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
        backtrack(new ArrayList<>());

    }

    public static void backtrack(List<Integer> curr) {
        if(curr.size() == nums.size()) {
            answer.add(List.copyOf(curr));
            return ;
        }

        for (int num : nums) {
            System.out.println("num = " + num);
            if(!curr.contains(num)) {
                curr.add(num);
                backtrack(curr);
                curr.remove(curr.size() - 1);
            }
        }
    }


}
