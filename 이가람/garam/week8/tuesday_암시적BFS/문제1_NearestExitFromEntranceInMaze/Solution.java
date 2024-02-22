package garam.week8.tuesday_암시적BFS.문제1_NearestExitFromEntranceInMaze;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/?envType=study-plan-v2&envId=leetcode-75
 * 빈 셀( 로 표시됨 )과 벽( 으로 표시됨 )이 있는 m x n행렬 maze( 0-인덱스 ) 이 제공됩니다 .
 * 또한 미로의 가 주어지는데 , 여기서 는 처음에 서 있는 셀의 행과 열을 나타냅니다.'.''+'entranceentrance = [entrancerow, entrancecol]
 * <p>
 * 한 단계에서 한 셀을 위쪽 , 아래쪽 , 왼쪽 또는 오른쪽 으로 이동할 수 있습니다 .
 * 벽이 있는 감방 안으로 들어갈 수 없고, 미로 밖으로 나갈 수도 없습니다.
 * 당신의 목표는 에서 가장 가까운 출구를 찾는 것입니다 entrance.
 * 이탈 은 경계 에 있는 빈 셀로 정의됩니다 . 출구로 간주되지 않습니다 .
 * <p>
 * mazeentrance 에서 가장 가까운 출구까지 또는 그러한 경로가 존재하지 않는 경우 최단 경로의 걸음 수를 반환 합니다 .
 * <p>
 * entrance-1
 */
public class Solution {

    public static void main(String[] args) {
        /**
         * [["+","+",".","+"],[".",".",".","+"],["+","+", "+","."]]
         *
         *   + + . +
         *   . . . +
         *   + + + .
         */
        nearestExit(new char[][]{{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}}, new int[]{1, 2});
    }

    public static int nearestExit(char[][] maze, int[] entrance) {


        int[][] shifts = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        maze[entrance[0]][entrance[1]] = '+';

        //Space: O(N)
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{entrance[0], entrance[1], 0});

        //Time: O(N);
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            //up down left right
            for(int[] shift : shifts) {
                int x = node[0] + shift[0], y = node[1] + shift[1];

                if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == '.'){
                    if (x == 0 || y == 0 || x == maze.length - 1 || y == maze[0].length - 1)
                        return node[2] + 1;
                    else {
                        maze[x][y] = '+';
                        queue.add(new int[]{x, y, node[2] + 1});
                    }
                }
            }
        }
        return -1;
    }


}
