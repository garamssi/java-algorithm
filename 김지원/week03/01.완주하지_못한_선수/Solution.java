import java.util.*;

class Solution {

    public String solution(String[] participant, String[] completion) {
        // 동명 이인이 있을 수 있기 때문에 (이름, 사람수) 형태의 Map을 생성
        Map<String, Integer> participants = new HashMap<>();

        for (String person : participant) {
            participants.put(person, participants.getOrDefault(person, 0) + 1);
        }

        for (String person : completion) {
            participants.put(person, participants.get(person) - 1);
        }

        for (String person : participants.keySet()) {
            if (participants.get(person) > 0) {
                return person;
            }
        }
        return "";
    }
}