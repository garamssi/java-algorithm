//
//  main.swift
//  minu
//
//  Created by 노민우 on 1/3/24.
//

import Foundation

class Solution {
    func maxProfit(_ prices: [Int]) -> Int {
        // 최소값과 최대 이익을 저장할 변수를 초기화합니다.
        var minPrice = Int.max
        var maxProfit = 0
        
        // 주식 가격 배열을 순회합니다.
        for price in prices {
            // 현재 가격이 지금까지의 최소 가격보다 작다면, 최소 가격을 갱신합니다.
            if price < minPrice {
                minPrice = price
            } else if price - minPrice > maxProfit { // 현재 가격에서 최소 가격을 뺀 값이 현재까지의 최대 이익보다 크다면, 최대 이익을 갱신합니다.
                maxProfit = price - minPrice
            }
        }
        
        // 계산된 최대 이익을 반환합니다.
        return maxProfit
    }
}

let re = Solution()
print(re.maxProfit([7,1,5,3,6,4]))
