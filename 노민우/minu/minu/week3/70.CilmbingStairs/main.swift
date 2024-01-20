//
//  main.swift
//  minu
//
//  Created by 노민우 on 1/20/24.
//

import Foundation

var memo = [Int: Int]()

func climbStairsTopDown(_ n: Int) -> Int {
    if n <= 2 { 
        return n
    }
    
    if let result = memo[n] {
        return result
    }
    memo[n] = climbStairsTopDown(n - 1) + climbStairsTopDown(n - 2)
    return memo[n]!
}
