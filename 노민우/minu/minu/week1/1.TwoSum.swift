//
//  1.TwoSum.swift
//  minu
//
//  Created by 노민우 on 1/4/24.
//

import Foundation

/*
 - **접근 방법: 해시 테이블 사용**
     
     이 문제를 해결하는 가장 효율적인 방법은 해시 테이블(스위프트에서는 딕셔너리)을 사용하여 보완 값과 그 인덱스를 저장하는 것입니다. 보완 값이란 **`target - x`**로 계산됩니다. 배열을 순회하면서 각 요소에 대해:
     
     - 그 요소의 보완 값을 계산합니다.
     - 해시 테이블에서 이 보완 값이 이미 있는지 확인합니다.
     - 만약 있다면, 그들은 타겟에 더해지는 한 쌍을 찾은 것입니다.
     - 그렇지 않다면, 현재 숫자와 그 인덱스를 해시 테이블에 추가하고 계속합니다.
 */
func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
    var numToIndex = [Int: Int]() // 숫자와 그 인덱스를 저장하기 위한 딕셔너리

    for (currentIndex, num) in nums.enumerated() {
        let complement = target - num // 보완 값 계산

        // 딕셔너리에서 보완 값의 존재 여부 확인
        if let complementIndex = numToIndex[complement] {
            return [complementIndex, currentIndex] // 보완 값과 현재 숫자의 인덱스 반환
        }

        // 현재 숫자와 그 인덱스를 딕셔너리에 저장
        numToIndex[num] = currentIndex
    }

    // 솔루션이 없는 경우 빈 배열 반환
    // 주의: 문제의 조건에 따르면 이 경우는 발생하지 않습니다
    return []
}
