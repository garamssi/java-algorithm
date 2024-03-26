package week12;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 * 피로도
 */
public class I_피로도 {
    public static void main(String[] args) {
//        int k = 80;
//        int[][] dungeons = {
//            // 최소 필요 피로도, 소모 필요도
//            {80,50}, // 1
//            {80,80}, // 3
//            {5,5} // 2
//        };

        int k = 4;
        int[][] dungeons = {
                // 최소 필요 피로도, 소모 필요도
                {4,3}, // 1
                {2,2}, // 3
                {2,2} // 2
        };


        // 80 50 30
        // 20 40 10
        //----------
        // 60 10 20

//        int[][] dungeons = {
//                // 최소 필요 피로도, 소모 필요도
//                {50,20}, // 30
//                {30,25}, // 5
//                {60,30}  // 30
//        };

        System.out.println(solution(k, dungeons));
    }

    static boolean[] visit;
    static int max = 0;

    public static int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        for(int i = 0; i < dungeons.length; i++) {
            if(k >= dungeons[i][0]) {
                dfs(i, k, dungeons, 1);
            }
        }
        return max;
    }

    private static void dfs(int index, int tired, int[][] dungeons, int count)  {
        visit[index] = true;
        tired -= dungeons[index][1];
        for(int i = 0; i < dungeons.length; i++) {
            if(!visit[i] && dungeons[i][0] <= tired) {
                dfs(i, tired, dungeons, count + 1);
            }
        }
        max = Math.max(count, max);
        visit[index] = false;
    }


//    public static int solution(int k, int[][] dungeons) {
//        int answer = 0;
//
//        Arrays.sort(dungeons, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                int a = o1[0] - o1[1];
//                int b = o2[0] - o2[1];
//                return b - a;
//            }
//        });
//
//        for (int[] dungeon : dungeons) {
//            if(k >= dungeon[0]) {
//                k -= dungeon[1];
//                answer ++;
//            }
//        }
//
//        return answer;
//    }

}
