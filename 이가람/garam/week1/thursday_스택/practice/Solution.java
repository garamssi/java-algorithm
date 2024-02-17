package garam.week1.thursday.practice;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(LongestConsecutiveSequence(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(LongestConsecutiveSequence(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    public static int LongestConsecutiveSequence(int[] nums) {

        Arrays.sort(nums);

        int maxCnt = 0;
        int cnt = 1;
        int beforeNum = nums[0];

        for(int i = 0; i < nums.length; i++) {
            if(beforeNum + 1 == nums[i]) {
                cnt++;
            } else {
                cnt = 1;
            }

            maxCnt = Math.max(maxCnt, cnt);
            beforeNum = nums[i];
        }

        return maxCnt;
    }


}
