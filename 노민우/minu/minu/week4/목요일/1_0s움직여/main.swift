//
//  main.swift
//  minu
//
//  Created by 노민우 on 1/26/24.
//

import Foundation
/*
 283. Move Zeroes
 
 Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 Note that you must do this in-place without making a copy of the array.

 정수 배열 nums가 주어지면 0이 아닌 요소의 상대적 순서를 유지하면서 모든 0을 끝으로 이동합니다.
배열의 복사본을 만들지 않고 이 작업을 내부에서 수행해야 합니다.

 Example 1:

 Input: nums = [0,1,0,3,12]
 Output: [1,3,12,0,0]
 Example 2:

 Input: nums = [0]
 Output: [0]
  

 Constraints:

 1 <= nums.length <= 10^4
 -2^31 <= nums[i] <= 2^31 - 1
 
 */
class Solution {
    func moveZeroes(_ nums: inout [Int]) {
        var lastZero = 0
        
        // [0, 1, 0, 3, 12]
        for current in 0..<nums.count {
            if nums[current] != 0 {
                nums.swapAt(current, lastZero) // 현재 요소와 마지막으로 0이아닌 요소를 찾은 위치를 교환
                lastZero += 1 // 0이 아닌 요소는 위치 업데이트
            }
            /* [0, 1, 0, 3, 12]
             for 1:current: 0 // if nums[0] != 0 out [0, 1, 0, 3, 12] 0 이므로 아무일 일어나지 않음
             for 2:current: 1 // if -> if nums[1] != 0 이므로 진입 lastZero = 0와 swapAt을 이용해 교환한다.
                                   1        0         swapAt(1, 0) // swapAt(요 안에듣 배열의 인덱스가 들어감.)
                    nums.swapAt(current, lastZero)에의해
             [0, 1, 0, 3, 12]
             -> [1, 0, 0, 3, 12] / lastZero = 1

             for 3:current 2// if -> if nums[2] != 0 out nums[2]는 0이므로 진입하지 않음.
                         
             for 4: current 3// if -> if nums[3] != 0 이므로 진입
                         swapAt(3, 1) // swapAt(요 안에듣 배열의 인덱스가 들어감.)
                    nums.swapAt(current, lastZero) 는 3 과 0 이므로
                    [1, 0, 0, 3, 12] -> [1, 3, 0, 0, 12] // / lastZero = 1 -> 2
             for 5: current 4// if -> if num[4] != 0 이므로 진입
                    swapAt(4, 2) // swapAt(요 안에듣 배열의 인덱스가 들어감.)
                    nums.swapAt(current, lastZero) 는 12 과 0 이므로
                    [1, 3, 0, 0, 12] -> [1, 3, 12, 0, 0] //lastZero = 2 -> 3
             */
        }
    }
}

let sol = Solution()
var nums = [0, 1, 0, 3, 12]
print(sol.moveZeroes(&nums))

