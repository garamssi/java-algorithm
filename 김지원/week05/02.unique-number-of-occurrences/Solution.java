import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        /*
        Map<Integer, Integer> map = Arrays.stream(arr).boxed()
                .collect(Collectors.toMap(i -> i, i -> 1, Integer::sum));
        */

        return map.values().size() == new HashSet<>(map.values()).size();
    }
}