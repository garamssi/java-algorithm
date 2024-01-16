package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        int numCourses = 2;
//        int[][] prerequisites = {{2, 1}, {1, 2}};

        int numCourses = 3;
        int[][] prerequisites = {{1, 0}, {2, 1}};

        Solution solution = new Solution();
        boolean rs = solution.canFinish(numCourses, prerequisites);
        System.out.println(rs);
    }
}

class Solution {

    public static void main(String[] args) {
        
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> finishToTakeMap = new HashMap<>();

        for (int[] pre : prerequisites) {
            finishToTakeMap.putIfAbsent(pre[0], new ArrayList<>());
            // 처리해야 하는 코스 추가
            finishToTakeMap.get(pre[0]).add(pre[1]);
        }

        // 처리 해야하는 노드를 저장하는 변수
        List<Integer> takes = new ArrayList<>();

        // 처리한 노드를 저장하는 변수
        List<Integer> taken = new ArrayList<>();


        for (Integer finish : finishToTakeMap.keySet()) {
            if (!dfs(finishToTakeMap, finish, takes, taken)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> finishToTakeMap, Integer finish, List<Integer> takes, List<Integer> taken) {
        // 완료해야 하는 노드가 처리해야하는 노드에 이미 포함되어 있다면
        // 그래프가 순환 구조이므로 false 리턴
        if (takes.contains(finish)) {
            return false;
        }

        // 이미 처리한 노드라면 true 리턴
        if (taken.contains(finish)) {
            return true;
        }
        // 완료해야 하는 코스에 값이 있다면
        if (finishToTakeMap.containsKey(finish)) {
            // 처리해야 하는 노드에 현재 완료해야 하는 노드 추가
            takes.add(finish);
            for (Integer take : finishToTakeMap.get(finish)) {
                if (!dfs(finishToTakeMap, take, takes, taken)) {
                    return false;
                }
            }
            // 탐색 후에는 처리했으므로 노드에서 제거
            takes.remove(finish);

            // 이미 처리한 노드 추가
            taken.add(finish);
        }

        return true;
    }
}