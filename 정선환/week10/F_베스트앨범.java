package week10;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42579
 * 베스트 앨범
 */
public class F_베스트앨범 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop", "piano"};
        int[] plays = {500, 600, 150, 800, 2500, 2000}; // 2500, 2000, 800, 600, 500, 150

        System.out.println(solution(genres, plays));
    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, List<int[]>> map = new HashMap<>();
//        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            int[] sing = new int[2];
            sing[0] = i;
            sing[1] = play;

            List<int[]> list = map.getOrDefault(genre, new ArrayList<>());
            list.add(sing);

            list.sort((o1, o2) -> o2[1] - o1[1]);
            map.put(genre, list);
        }

        List<Integer> answer = new ArrayList<>();
        for (List<int[]> list : map.values()) {
            for(int i = 0; i < 2; i++) {
                int index = list.get(i)[0];
                answer.add(index);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

//    public static int[] solution(String[] genres, int[] plays) {
//
//        Map<String, PriorityQueue<int[]>> map = new HashMap<>();
//        for(int i = 0; i < genres.length; i++) {
//            String genre = genres[i];
//            int play = plays[i];
//
//            int[] sing = new int[2];
//            sing[0] = i;
//            sing[1] = play;
//
//            PriorityQueue<int[]> priorityQueue = map.getOrDefault(genre, new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]));
//            priorityQueue.offer(sing);
//
//            map.put(genre, priorityQueue);
//        }
//
//        for (PriorityQueue<int[]> value : map.values()) {
//            int[] peek = value.peek();
//        }
//
//        return null;
//    }

}
