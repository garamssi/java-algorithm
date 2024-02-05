//
//  main.swift
//  minu
//
//  Created by 노민우 on 2/5/24.
//

import Foundation
/*
 정수 arr 배열이 주어지면 배열의 각 값의 발생 횟수가 고유하면 true를 반환하고, 
 그렇지 않으면 false를 반환합니다.

 예시 1:

 입력: arr = [1,2,2,1,1,3]
 출력: true
 설명: 값 1에는 3회 발생, 2에는 2회, 3에는 1회 발생합니다. 두 값의 발생 횟수는 동일하지 않습니다.
 
 예 2:

 입력: arr = [1,2]
 출력: false
 예시 3:

 입력: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 출력: true
  

 제약:

 1 <= 배열 길이 <= 1000
 -1000 <= 도착[i] <= 1000
 */

//class Solution {
//    func uniqueOccurrences(_ arr: [Int]) -> Bool {
//        var occurrenceDict = [Int: Int]()
//        
//        for num in arr {
//            if let count = occurrenceDict[num] {
//                occurrenceDict[num] = count + 1
//            } else {
//                occurrenceDict[num] = 1
//            }
//        }
//
//        var occurrenceSet = Set<Int>()
//        for (_, count) in occurrenceDict {
//            if occurrenceSet.contains(count) {
//                return false
//            } else {
//                occurrenceSet.insert(count)
//            }
//        }
//
//        return true
//    }
//}

class Solution {
    func uniqueOccurrences(_ arr: [Int]) -> Bool {
        func uniqueOccurrences(_ arr: [Int]) -> Bool {
            var occurrences = [Int: Int]()

            for num in arr {
                occurrences[num, default: 0] += 1
            }

            let counts = Set(occurrences.values)
            return occurrences.values.count == counts.count
        }
    }
}

let arr = [1, 2, 2, 1, 1, 3]
let result = uniqueOccurrences(arr)
print(result)


let sol = Solution()
print(sol.uniqueOccurrences([1, 2, 2, 1, 1, 3])
