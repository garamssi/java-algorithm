//
//  739.DailyTemperatures .swift
//  minu
//
//  Created by 노민우 on 1/9/24.
//

import Foundation

//
//  main.swift
//  minu
//
//  Created by 노민우 on 1/3/24.
//

// 복습하기 어려움
class Solution {
    func dailyTemperatures(_ temperatures: [Int]) -> [Int] {
        
        var answer = [Int](repeating: 0, count: temperatures.count)
        var stack: [(Int,Int)] = []
        
        for (curDay, curTemp) in temperatures.enumerated() {

            while let last = stack.last, last.1 < curTemp {
                let prevDay = last.0
                answer[prevDay] = curDay - prevDay
                stack.removeLast()
            }
            stack.append((curDay, curTemp))
        }
        
        return answer
        
    }
}

let re = Solution()
re.dailyTemperatures([73,74,75,71,69,72,76,73])
