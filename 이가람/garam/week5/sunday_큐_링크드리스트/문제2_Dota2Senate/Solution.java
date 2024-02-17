package garam.week5.sunday_큐_링크드리스트.문제2_Dota2Senate;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/dota2-senate/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Dota2의 세계에는 Radiant와 Dire라는 두 가지 파티가 있습니다.
 *
 * Dota2 상원은 두 정당의 상원의원으로 구성됩니다. 이제 상원은 Dota2 게임의 변화를 결정하려고 합니다. 이 변경 사항에 대한 투표는 라운드 기반 절차입니다.
 * 각 라운드에서 각 상원의원은 다음 두 가지 권리 중 하나를 행사할 수 있습니다.
 *
 * 한 상원의원의 권리 금지: 상원의원은 이번 라운드와 다음 라운드에서 다른 상원의원이 자신의 모든 권리를 잃게 만들 수 있습니다.
 * 승리 발표: 이 상원의원이 여전히 투표권을 갖고 있는 상원의원이 모두 같은 정당 출신임을 확인한 경우, 그는 승리를 발표하고 게임 변경을 결정할 수 있습니다.
 * senate각 상원의원의 소속 정당을 나타내는 문자열이 제공됩니다 . Radiant 파티와 Dire 파티를 대표하는 캐릭터 'R'입니다 . 'D'그런 다음 상원 의원이 있으면 n주어진 문자열의 크기는 n.
 *
 * 라운드 기반 절차는 주어진 순서대로 첫 번째 상원의원부터 마지막 ​​상원의원까지 시작됩니다. 이 절차는 투표가 끝날 때까지 지속됩니다. 권리를 잃은 상원의원은 모두 절차 과정에서 제외됩니다.
 *
 * 모든 상원의원이 충분히 똑똑하고 자신의 정당을 위해 최선의 전략을 사용할 것이라고 가정해 보십시오. 어느 쪽이 최종적으로 승리를 선언할지 예측하고 도타2의 판도를 바꿔보세요. 출력은 "Radiant"또는 이어야 합니다 "Dire".
 */
public class Solution {
	public static void main(String[] args) {
		predictPartyVictory("RD");
		predictPartyVictory("RDD");
	}

	public static String predictPartyVictory(String senate) {
		Queue<Integer> rad = new LinkedList<>(), dir = new LinkedList<>();
		int n = senate.length();
		// Add all senators to respect queue with index
		for (int i = 0; i < n; i++){
			if (senate.charAt(i) == 'R'){
				rad.add(i);
			} else {
				dir.add(i);
			}
		}

		// Use increasing n to keep track of position
		while (!rad.isEmpty() && !dir.isEmpty()){
			// Only "winner" stays in their queue
			if (rad.peek() < dir.peek()){
				rad.add(n++);
			} else {
				dir.add(n++);
			}
			rad.poll();
			dir.poll();
		}

		return (rad.isEmpty()) ? ("Dire") : ("Radiant");
	}


}
