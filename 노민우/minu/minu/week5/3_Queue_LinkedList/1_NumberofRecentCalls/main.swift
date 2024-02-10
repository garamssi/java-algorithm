//
//  main.swift
//  minu
//
//  Created by 노민우 on 2/6/24.
//

import Foundation
/*
 특정 기간 내의 최근 요청 수를 계산하는 RecentCounter 클래스가 있습니다.

 RecentCounter 클래스를 구현합니다.

 RecentCounter() 최근 요청이 없는 카운터를 초기화합니다.
 int ping(int t) 시간 t에 새 요청을 추가합니다. 여기서 t는 밀리초 단위의 시간을 나타내며 지난 3000밀리초 동안 발생한 요청 수(새 요청 포함)를 반환합니다. 구체적으로, 포함 범위 [t - 3000, t]에서 발생한 요청 수를 반환합니다.
 ping에 대한 모든 호출은 이전 호출보다 엄격하게 더 큰 t 값을 사용하는 것이 보장됩니다.

  

 예시 1:

 입력
 ["최근 카운터", "핑", "핑", "핑", "핑"]
 [[], [1], [100], [3001], [3002]]
 산출
 [널, 1, 2, 3, 3]

 설명
 RecentCounter RecentCounter = new RecentCounter();
 최근카운터.ping(1); // 요청 = [1], 범위는 [-2999,1], 1을 반환합니다.
 최근카운터.ping(100); // 요청 = [1, 100], 범위는 [-2900,100], 2를 반환합니다.
 최근카운터.ping(3001); // 요청 = [1, 100, 3001], 범위는 [1,3001], 3을 반환합니다.
 최근카운터.ping(3002); // 요청 = [1, 100, 3001, 3002], 범위는 [2,3002], 반환 3
  

 제약:

 1 <= 티 <= 109
 각 테스트 케이스는 t 값이 엄격하게 증가하는 ping을 호출합니다.
 Ping에는 최대 104개의 호출이 이루어집니다.
 */
class RecentCounter {

    init() {
        
    }
    
    func ping(_ t: Int) -> Int {
        
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * let obj = RecentCounter()
 * let ret_1: Int = obj.ping(t)
 */
