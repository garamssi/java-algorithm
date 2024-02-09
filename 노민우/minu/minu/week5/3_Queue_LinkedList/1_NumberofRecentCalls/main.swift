//
//  main.swift
//  minu
//
//  Created by 노민우 on 2/6/24.
//

import Foundation
/* 진짜 이해안되는문제..;;;
 특정 기간 내의 최근 요청 수를 계산하는 RecentCounter 클래스가 있습니다.

 RecentCounter 클래스를 구현합니다.

 RecentCounter() 최근 요청이 없는 카운터를 초기화합니다.
 int ping(int t) 시간 t에 새 요청을 추가합니다. 
 여기서 t는 밀리초 단위의 시간을 나타내며 지난 3000밀리초 동안 발생한 요청 수(새 요청 포함)를 반환합니다.
 구체적으로, 포함 범위 [t - 3000, t]에서 발생한 요청 수를 반환합니다.
 ping에 대한 모든 호출은 이전 호출보다 엄격하게 더 큰 t 값을 사용하는 것이 보장됩니다.

 예시 1:

 입력
 ["RecentCounter", "ping", "ping", "ping", "ping"]
 [[], [1], [100], [3001], [3002]]
 산출
 [ null, 1, 2, 3, 3]

 설명
 RecentCounter recentCounter = new RecentCounter();
 recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
 recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
 recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
 recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
 
 RecentCounter RecentCounter = new RecentCounter();
 최근카운터.ping(1); // 요청 = [1], 범위는 [-2999,1], 1을 반환합니다.
 최근카운터.ping(100); // 요청 = [1, 100], 범위는 [-2900,100], 2를 반환합니다.
 최근카운터.ping(3001); // 요청 = [1, 100, 3001], 범위는 [1,3001], 3을 반환합니다.
 최근카운터.ping(3002); // 요청 = [1, 100, 3001, 3002], 범위는 [2,3002], 반환 3
  
 제약:
O(NlogN)이하
 1 <= t <= 10^9
 각 테스트 케이스는 t 값이 엄격하게 증가하는 ping을 호출합니다.
 Ping에는 최대 104개의 호출이 이루어집니다.
 */
class RecentCounter {
    
    var pings: [Int] // "ping" 시간을 저장할 큐(배열 사용)

    init() {
        pings = [] // 초기화시 입력
    }
    
    func ping(_ t: Int) -> Int {
        pings.append(t) // 새 pint을 큐에 추가
        // 3000밀리초 이전의 ping을 제거
        while pings.first! < t - 3000 {
            pings.removeFirst()
        }
        return pings.count // 최근 3000밀리초 이내의 ping 개수를 반환
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * let obj = RecentCounter()
 * let ret_1: Int = obj.ping(t)
 */


let obj = RecentCounter()
print(obj.ping(1))    // Outputs: 1
print(obj.ping(100))  // Outputs: 2
print(obj.ping(3001)) // Outputs: 3
print(obj.ping(3002)) // Outputs: 3
