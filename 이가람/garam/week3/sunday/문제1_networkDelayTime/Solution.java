package garam.week3.sunday.문제1_networkDelayTime;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2);
	}

	public static int networkDelayTime(int[][] times, int n, int k) {

		List<List<Pair>> graph = new ArrayList<>(n+1);

		for(int i = 0;i<n+1;i++){
			graph.add(new ArrayList<Pair>());
		}

		for (int[] time: times){
			int u = time[0];
			int v = time[1];
			int w = time[2];
			graph.get(u).add(new Pair(w, v));
		}

		int[] dis = new int[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[k] = 0;
		PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>((p1, p2)->Integer.compare(p1.left,p2.left));
		priorityQueue.offer(new Pair(0, k));

		while (!priorityQueue.isEmpty()) {
			Pair<Integer, Integer> curPair = priorityQueue.poll();
			int u = curPair.getRight();
			for (Pair<Integer, Integer> p : graph.get(u)){
				int w = p.getLeft();
				int v = p.getRight();
				if (dis[u] + w < dis[v]){
					priorityQueue.offer(new Pair(dis[u] + w, v));
					dis[v] = dis[u] + w;
				}
			}
		}

		int answer = 0;
		for(int i = 1; i <= n; i++){
			if(dis[i] == Integer.MAX_VALUE){
				return -1;
			}
			answer = Math.max(answer, dis[i]);
		}

		return answer;
	}
}
