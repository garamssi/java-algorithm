import java.util.*;

class Solution {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] solution = new Solution().solution(genres, plays);
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(String[] genres, int[] plays) {
        // 장르별 play 횟수
        Map<String, Integer> totalPlays = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
        }
        // 장르(play 횟수로 내림차순), 음악(play 횟수로 내림차순)
        Map<String, Queue<Music>> musicMap = new TreeMap<>(
                (o1, o2) -> totalPlays.get(o2) - totalPlays.get(o1));

        for (int i = 0; i < genres.length; i++) {
            if (!musicMap.containsKey(genres[i])) {
                Queue<Music> musics = new PriorityQueue<>();
                musics.offer(new Music(i, plays[i]));
                musicMap.put(genres[i], musics);
            } else {
                musicMap.get(genres[i]).offer(new Music(i, plays[i]));
            }
        }
        List<Integer> result = new ArrayList<>();
        for (String genre : musicMap.keySet()) {
            Queue<Music> musics = musicMap.get(genre);
            if (!musics.isEmpty()) {
                result.add(musics.poll().order);
            }
            if (!musics.isEmpty()) {
                result.add(musics.poll().order);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    static class Music implements Comparable<Music> {
        int order;
        int play;

        public Music(int order, int play) {
            this.order = order;
            this.play = play;
        }

        @Override
        public int compareTo(Music other) {
            return other.play - this.play;
        }
    }
}