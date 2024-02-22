package week7;

/**
 * https://leetcode.com/problems/number-of-provinces/description/?envType=study-plan-v2&envId=leetcode-75
 * 547. Number of Provinces
 */
public class D_NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {
                {1,1,0},
                {0,1,0},
                {0,0,1}
        };

        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        boolean[] visited = new boolean[length];

        int province = 0;
        for(int i = 0; i < length; i++) {
            if(!visited[i]) {
                dfs(isConnected, visited, i);
                province++;
            }
        }

        return province;
    }

    private static void dfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true;

        int[] cities = isConnected[i];
        for(int j = 0; j < cities.length; j++) {
            int city = cities[j];
            if(city == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }

}
