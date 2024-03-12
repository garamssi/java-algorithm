import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> typeMap = new HashMap<>();

        for (String[] cloth : clothes) {
            typeMap.put(cloth[1], typeMap.getOrDefault(cloth[1], 0) + 1);
        }

        int combination = 1;
        for (String item : typeMap.keySet()) {
            combination *= (typeMap.get(item) + 1);
        }

        // 모든 조합에서 아무것도 착용하지 않는 방법(1가지)를 제거
        return combination - 1;
    }
}