package garam.week11.thursday_BFS_DFS.문제2_단어변환;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] wordList = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        int result = solution.solution("hit", "cog", wordList);
        System.out.println(result);
    }

    public int solution(String begin, String target, String[] words) {
        // words 배열을 Set으로 변환하여 중복을 제거
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        // target 단어가 words 안에 없다면 변환할 수 없으므로 0을 반환
        if (!wordSet.contains(target)) {
            return 0;
        }

        // BFS를 위한 큐를 초기화합니다. begin 단어를 큐에 추가
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);

        // 변환 횟수를 세기 위한 변수를 초기화
        int count = 0;

        // 큐가 비어있지 않는 동안 BFS를 수행
        while (!queue.isEmpty()) {
            // 현재 큐의 크기만큼 순회합니다. 이는 같은 레벨의 모든 노드를 처리
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 현재 단어를 큐에서 제거
                String currentWord = queue.poll();
                // 현재 단어가 target과 같다면 count를 반환
                if (currentWord.equals(target)) {
                    return count;
                }
                // 모든 문자 위치에 대해 다른 문자로 변경
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] wordChars = currentWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChars[j] = c;
                        String nextWord = String.valueOf(wordChars);
                        // 만약 변환된 단어가 wordSet에 있다면 큐에 추가하고 wordSet에서 제거
                        if (wordSet.contains(nextWord)) {
                            queue.add(nextWord);
                            wordSet.remove(nextWord);
                        }
                    }
                }
            }
            // 한 단계가 완료되면 count를 증가
            count++;
        }

        return 0;
    }

}
