package garam.week2.thursday.문제3_travel;



import java.util.*;

/**
 * 주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.
 * 항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 * https://school.programmers.co.kr/learn/courses/30/lessons/43164
 * */
public class Solution {

    public static void main(String[] args) {
        String[] graph1 = graph(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        System.out.println(Arrays.toString(graph1));

//        String[] graph2 = graph(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});
//        System.out.println(Arrays.toString(graph2));
    }

    public static String[] graph(String[][] tickets) {

        // 그래프를 만듭니다.
        Map<String, PriorityQueue<String>> map = makeGraph(tickets);


        LinkedList<String> answer = new LinkedList<>();
        Deque<String> stack = new ArrayDeque<>();

        // 문제 조건에서 무조건 INC 시작.
        stack.push("ICN");
        while (!stack.isEmpty()){

            /**
             * 키가 있으면서 우선순위큐가 비어있지 않으면 실행
             * 키값으로 찾아 우선순위큐에 있던 티켓을 모두 스택에 넣는다.
             * */
            while (map.containsKey(stack.getFirst()) && !map.get(stack.getFirst()).isEmpty() ) {
                // 스택에 넣을 때 큐에 값을 제거하면서 반환한다.
                stack.push(map.get(stack.getFirst()).poll());
            }

            answer.add(0, stack.pop());
        }

        return answer.toArray(new String[0]);
    }

    public static Map<String, PriorityQueue<String>> makeGraph( String[][] tickets ){

        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for(String[] ticket : tickets){
            map.putIfAbsent(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).add(ticket[1]);


        }

        return map;
    }
}
