package week3;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 * 완주하지 못한 선수
 */
public class A_WhoDidNotFinishTheRace {
    public static void main(String[] args) {
//        String[] participant = new String[]{"leo", "kiki", "eden"};
//        String[] completion = new String[]{"eden", "kiki"};

//        String[] participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
//        String[] completion = new String[]{"josipa", "filipa", "marina", "nikola"};

        String[] participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] completion = new String[]{"stanko", "ana", "mislav"};

        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        // 참가자 명단을 Map
        Map<String, Integer> participantMap = new HashMap<>();
        for (String participantName : participant) {
            participantMap.put(participantName, participantMap.getOrDefault(participantName, 0) + 1);
        }

        // 완료자 명단 Loop
        for (String completionName : completion) {
            Integer sameNameCount = participantMap.get(completionName);
            if(sameNameCount == 1) {
                participantMap.remove(completionName);
            }
            if(sameNameCount >= 2) {
                ;
                participantMap.put(completionName, --sameNameCount);
            }
        }

        for (String key : participantMap.keySet()) {
            answer = key;
        }
        return answer;
    }
}
