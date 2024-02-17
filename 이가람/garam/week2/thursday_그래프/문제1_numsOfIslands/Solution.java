package garam.week2.thursday_그래프.문제1_numsOfIslands;

// https://leetcode.com/problems/nums-of-islands
public class Solution {

    public static void main(String[] args) {

        int[][] grid = {
                  {1, 1, 1, 1, 0}
                , {1, 1, 0, 1, 0}
                , {1, 1, 0, 0, 0}
                , {0, 0, 0, 0, 1}
        };

        System.out.println(numsOfIslands(grid));


    }

    public static int numsOfIslands(int[][] grid) {

        if (grid == null ) {
            return 0;
        }

        int cnt = 0;

        for(int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 1) {
                    dfs(i, j, grid);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void dfs(int i, int j, int[][] grid){
        if( i < 0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        dfs(i, j - 1, grid);
        dfs(i, j + 1, grid);
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
    }
}
