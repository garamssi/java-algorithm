package garam.week8.tuesday_암시적BFS.문제2_RottingOranges;

import java.util.*;

/**
 * m x n 크기의 그리드가 주어지며, 각 셀은 세 가지 값 중 하나를 가질 수 있습니다:
 *
 * 0은 빈 셀을 나타냅니다.
 * 1은 신선한 오렌지를 나타냅니다.
 * 2는 썩은 오렌지를 나타냅니다.
 * 매 분마다, 썩은 오렌지와 사방으로 인접한 모든 신선한 오렌지는 썩게 됩니다.
 *
 * 더 이상 신선한 오렌지가 없을 때까지 경과해야 하는 최소 분을 반환하십시오. 만약 모든 신선한 오렌지가 썩을 수 없다면 -1을 반환하십시오.
 *
 * 예시 1:
 *
 * 입력: 그리드 = [[2,1,1],[1,1,0],[0,1,1]]
 * 출력: 4
 * 설명: 그리드에 표시된 대로, 신선한 오렌지가 썩는 데 4분이 걸립니다.
 */
public class Solution {
    public static void main(String[] args) {
//        [[2,1,1],[1,1,0],[0,1,1]]

        orangesRotting(new int[][]{{2,1,1}, {1,1,0}, {0,1,1}});
    }

    public static int orangesRotting(int[][] grid) {

        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        /**
         * 썩은 오렌지는 큐에 넣고
         * 신선한 오렌지의 수를 센다.
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) return 0; // 신선한 오렌지가 없다면 0을 반환한다.

        int minutesPassed = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // BFS 실행
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int[] dir : directions) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];

                    // 신선한 오렌지가 아니면 스킵,
                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] != 1) continue;

                    grid[x][y] = 2;
                    queue.add(new int[]{x, y});
                    freshOranges--;
                }
            }
            if (!queue.isEmpty()) minutesPassed++; // 큐가 비어있지 않다면 시간을 증가시킨다. -> 한 넓이당 1씩 증가
        }

        // 신선한 오렌지가 남아 있다면 -1을 반환한다.
        return freshOranges == 0 ? minutesPassed : -1;
    }
}
