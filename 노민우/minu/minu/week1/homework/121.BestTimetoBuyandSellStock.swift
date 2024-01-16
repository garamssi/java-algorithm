//
//  BestTimetoBuyandSellStock.swift
//  minu
//
//  Created by 노민우 on 1/16/24.
//

import Foundation

/*
 가격[i]이 i번째 날의 특정 주식 가격인 배열 가격이 제공됩니다.
 특정 주식을 구매할 하루를 선택하고 해당 주식을 판매할 미래의 다른 날을 선택하여 수익을 극대화하려고 합니다.
 이 거래에서 얻을 수 있는 최대 이익을 반환합니다. 이익을 얻을 수 없으면 0을 반환합니다.

 입력: 가격 = [7,1,5,3,6,4]
 출력: 5
 설명: 2일차 매수(가격 = 1), 5일차 매도(가격 = 6), 이익 = 6-1 = 5.
 판매하기 전에 구매해야 하기 때문에 2일차에 구매하고 1일차에 판매하는 것은 허용되지 않습니다.
 
 Input: prices = [7,6,4,3,1]
 Output: 0
 Explanation: In this case, no transactions are done and the max profit = 0.
 이 경우 거래가 이루어지지 않으며 최대 이익 = 0입니다.
 
 Constraints:

 1 <= prices.length <= 10^5
 0 <= prices[i] <= 10^4
 */

// 1. 복잡도를 생각 안하고할 수 있는풀이.
//class Solution {
//    func maxProfit(_ prices: [Int]) -> Int {
//        var maxProfit = 0 //최대 이익
//
//        // 구매 시점을 순회하며, 처음 부터 끝까지 확인한다.
//        for i in 0..<prices.count {
//            for j in (i+1)..<prices.count {
//                // 판매시전의 가격에서 구배시점의 가격을 뺀 값 중 가장 큰 값을 찾과정을 저장
//                maxProfit = max(maxProfit, prices[i] - prices[j])
//            }
//        }
//        return maxProfit
//    }
//}

/* 10^5 이면 O(n^2)을 넘기때문에 O(NlogN)이나 O(N) or O(logN)이하로로 풀어야한다.
Array는 O(N)이하로 만들기 어렵기때문에 O(N)으로 푼다.

입력가 [7,1,5,3,6,4]
7 |*
6 | \           --*--
5 |  \       *   / \
4 |   \     / \ /   *
3 |    \   /   *
2 |     \ / ---------->
1 |    --*--
0 |
  0      1  2  3  4  5
 
 인덱스 1은 저점, 저정 이후로 인덱스 4가 고점을 가르킨다.
 여기서 현재값을 가르키는 포인트가 우측으로 이동하면서 이전 상태의 저점을 기준으로
 가격 차이를 계산하고, 만약 가격이 클 경우 최대값을 계속 교체해나가는 형태로 O(n) 풀이가 가능할것 같다.
 */

class Solution {
    func maxProfit(_ prices: [Int]) -> Int {
        var maxProfit = 0 //최대 이익(Profit)
        var minPrices = prices[0] //저점 물가(prices)
        // 구매 시점을 순회하며, 처음 부터 끝까지 확인한다.
        
        // 현재 가격을 순회하면서 이익을 계산한다.
        for price in prices {
            // 지금까지의 최저 가격
            minPrices = min(minPrices, price)
            
            // 현재가격과 최저가격의 차이가 가장 큰거
            maxProfit = max(maxProfit, price - maxProfit)
        }
        return maxProfit
    }
}
