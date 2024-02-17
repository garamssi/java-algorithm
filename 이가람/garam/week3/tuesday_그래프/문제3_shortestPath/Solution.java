package garam.week3.tuesday_그래프.문제3_shortestPath;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		int[][] grid = {
			  {1, 0, 1, 1, 1}
			, {1, 0, 1, 0, 1}
			, {1, 0, 1, 1, 1}
			, {1, 1, 1, 0, 1}
			, {0, 0, 0, 0, 1}
		};

		System.out.println(shortestPathBinaryMatrix(grid));
	}

	public static int shortestPathBinaryMatrix(int[][] grid) {
		int shortestDist = -1;
		int rowLength = grid.length;
		int colLength = grid[0].length;

		if(grid[0][0] != 1 || grid[rowLength - 1][colLength - 1] != 1) {
			return shortestDist;
		}

		boolean visited[][] = new boolean[rowLength][colLength];

		int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

		Queue<int[]> queue = new LinkedList<>();
		// 큐에 첫 번째 위치와 cnt 값을 추가합니다.
		queue.offer(new int[]{0, 0, 1});
		visited[0][0] = true;

		while(!queue.isEmpty()) {
			int[] curPos = queue.poll();
			int curRow = curPos[0];
			int curCol = curPos[1];
			int curLength = curPos[2];

			// 최종 목적지에 도착하면 값을 반환합니다.
			if(curRow == rowLength - 1 && curCol == colLength - 1) {
				shortestDist = curLength;
				return shortestDist;
			}
			// 동서남북으로 하나씩 방문합니다.
			for(int[] d : direction) {
				int nextRow = curRow + d[0];
				int nextCol = curCol + d[1];

				// 그리드의 범위를 넘지 않는 선에서 진행합니다.
				if(isInRange(nextRow, nextCol, rowLength, colLength)) {
					// 경로가 1이면서 방문하지 않았던 곳이면 진행합니다.
					if(grid[nextRow][nextCol] == 1 && !(visited[nextRow][nextCol])) {
						// 경로를 탐색할 곳을 큐에 넣습니다.
						queue.offer(new int[]{nextRow, nextCol, curLength + 1});
						// 방문한 곳은 true로 설정합니다.
						visited[nextRow][nextCol] = true;
					}
				}
			}

		}
		return shortestDist;
	}

	public static boolean isInRange(int r, int c, int rowLength, int colLength) {
		return (r >= 0 && r < rowLength) && (c >= 0 && c < colLength);
	}

}
