import java.util.*;

class Solution {
    
    Map<String, PriorityQueue<String>> fromToMap;
    List<String> answer = new ArrayList<>();

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        String[] solution = new Solution().solution(tickets);
        System.out.println(Arrays.toString(solution));
    }

    public String[] solution(String[][] tickets) {
        fromToMap = new HashMap<>();

        for (String[] ticket : tickets) {
            fromToMap.putIfAbsent(ticket[0], new PriorityQueue<>());
            fromToMap.get(ticket[0]).add(ticket[1]);
        }

//        dfs("ICN");
//        Collections.reverse(result);

        stack("ICN");
        return answer.toArray(new String[0]);
    }

    public void stack(String first) {
        Deque<String> stack = new ArrayDeque<>();
        stack.push(first);

        while (!stack.isEmpty()) {
            while (fromToMap.containsKey(stack.getFirst()) && !fromToMap.get(stack.getFirst()).isEmpty()) {
                stack.push(fromToMap.get(stack.getFirst()).poll());
            }

            answer.add(0, stack.pop());
        }
    }

    private void dfs(String from) {
        while (fromToMap.get(from) != null && !fromToMap.get(from).isEmpty()) {
            dfs(fromToMap.get(from).poll());
        }

        answer.add(from);
    }
}