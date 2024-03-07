package garam.week10.thursday.문제3.베스트앨범;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42579
 * 베스트앨범
 */
public class Solution {

    public static void main(String[] args) {

        System.out.println(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}));
    }

    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genrePlayCount = new HashMap<>();
        HashMap<String, PriorityQueue<Integer>> genreIndexQueue = new HashMap<>();

        // 장르별 총 재생 횟수와 우선순위 큐 초기화
        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);

            /**
             * plays[a] == plays[b]는 두 곡의 재생 횟수가 같은 경우를 확인
             * 이 경우, 노래의 인덱스가 낮은 것이 더 우선순위가 높음(a - b)
             * plays[b] - plays[a]는 재생 횟수가 다른 경우, 더 많이 재생된 노래가 더 높은 우선순위
             */
            genreIndexQueue.putIfAbsent(genres[i], new PriorityQueue<>(
                    (a, b) -> plays[a] == plays[b] ? a - b : plays[b] - plays[a]));

            genreIndexQueue.get(genres[i]).offer(i);
        }

        // 총 재생 횟수로 장르 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());

        /**
         * genrePlayCount.get(b) - genrePlayCount.get(a)는 두 장르 a와 b의 총 재생 횟수를 가져와서 b의 재생 횟수에서 a의 재생 횟수를 빼는 연산을 수행
         * 이 결과가 양수라면 b가 a보다 더 높은 순위를 갖게 되어 내림차순으로 정렬
         */
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));

        // 장르별로 가장 많이 재생된 두 곡의 인덱스를 저장할 리스트
        List<Integer> answerList = new ArrayList<>();
        for (String genre : sortedGenres) {
            PriorityQueue<Integer> queue = genreIndexQueue.get(genre);
            int count = 0;
            while (!queue.isEmpty() && count < 2) {
                answerList.add(queue.poll());
                count++;
            }
        }

        // 리스트를 배열로 변환
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}
