package garam.week14;

import java.util.*;

public class 문제3_방의개수 {
    public static void main(String[] args) {
        solution(new int[]{6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0});
    }

    public static int solution(int[] arrows) {
        // 방향에 따른 x, y의 변화량
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

        Set<String> visitedPoints = new HashSet<>();
        Set<String> visitedEdges = new HashSet<>();
        int roomCount = 0;

        // 시작점 초기화
        int x = 0;
        int y = 0;
        visitedPoints.add(x + "," + y);

        for (int i = 0; i < arrows.length; i++) {
            for (int j = 0; j < 2; j++) { // 대각선 교차를 포함하여 각 경로를 2번씩 탐색
                int nx = x + dx[arrows[i]];
                int ny = y + dy[arrows[i]];
                String nextPoint = nx + "," + ny;
                String edge1 = x + "," + y + "-" + nx + "," + ny; // 현재 위치에서 다음 위치로 가는 경로
                String edge2 = nx + "," + ny + "-" + x + "," + y; // 다음 위치에서 현재 위치로 되돌아오는 경로

                // 이미 방문한 점에 다시 도달했지만, 새로운 경로를 통해 도달한 경우 방이 형성됨
                if (visitedPoints.contains(nextPoint) && !visitedEdges.contains(edge1)) {
                    roomCount++;
                }

                // 점과 경로 방문 처리
                visitedPoints.add(nextPoint);
                visitedEdges.add(edge1);
                visitedEdges.add(edge2);

                // 현재 위치 업데이트
                x = nx;
                y = ny;
            }
        }

        return roomCount;
    }
}
