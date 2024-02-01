import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        List<Integer> list1 = set1.stream().filter(it -> !set2.contains(it)).toList();
        List<Integer> list2 = set2.stream().filter(it -> !set1.contains(it)).toList();

        return List.of(list1, list2);
    }
}