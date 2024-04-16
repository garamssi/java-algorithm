import java.util.HashSet;
import java.util.Set;

class Solution {
    /**
     * @param nums nums는 폰켓몬의 종류 번호가 담긴 배열
     * @return 선택할 수 있는 폰켓몬 종류 최대 개수
     */
    public int solution(int[] nums) {
        Set<Integer> kind = new HashSet<>();
        for (int num : nums) {
            kind.add(num);
        }

        /*
        if (kind.size() > nums.length / 2) {
            return nums.length / 2;
        } else {
            return kind.size();
        }
         */
        return Math.min(kind.size(), nums.length / 2);
    }
}