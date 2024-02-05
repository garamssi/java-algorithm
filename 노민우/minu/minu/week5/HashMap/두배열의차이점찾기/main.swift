//
//  main.swift
//  minu
//
//  Created by 노민우 on 2/5/24.
//

import Foundation
/*
 두 개의 0 인덱스 정수 배열 nums1 및 nums2가 주어지면 크기 2의 목록 답변을 반환합니다. 여기서:

 답변[0]은 nums2에 없는 nums1의 모든 고유 정수 목록입니다.
 답변[1]은 nums1에 없는 nums2의 모든 고유 정수 목록입니다.
 목록의 정수는 어떤 순서로든 반환될 수 있습니다.

  

 예시 1:

 입력: nums1 = [1,2,3], nums2 = [2,4,6]
 출력: [[1,3],[4,6]]
 설명:
 nums1의 경우 nums1[1] = 2는 nums2의 인덱스 0에 존재하지만 nums1[0] = 1 및 nums1[2] = 3은 nums2에 존재하지 않습니다. 따라서 답은 [0] = [1,3]입니다.
 nums2의 경우 nums2[0] = 2는 nums1의 인덱스 1에 있지만 nums2[1] = 4 및 nums2[2] = 6은 nums2에 없습니다. 그러므로 답[1] = [4,6]이 됩니다.
 예 2:

 입력: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
 출력: [[3],[]]
 설명:
 nums1의 경우 nums1[2] 및 nums1[3]은 nums2에 없습니다. nums1[2] == nums1[3]이므로 해당 값은 한 번만 포함되며 답은[0] = [3]입니다.
 nums2의 모든 정수는 nums1에 존재합니다. 그러므로 답[1] = []이 됩니다.
  

 제약:

 1 <= 숫자1.길이, 숫자2.길이 <= 1000
 -1000 <= 숫자1[i], 숫자2[i] <= 1000
 */
class Solution {
    func findDifference(_ nums1: [Int], _ nums2: [Int]) -> [[Int]] {
        let set1 = Set(nums1)
        let set2 = Set(nums2)
        
        let result1 = set1.filter { !set2.contains($0) }
        let result2 = set2.filter { !set1.contains($0) }
        
        return [Array(result1), Array(result2)]
    }
}

let solution = Solution()

let nums1 = [1, 2, 3]
let nums2 = [2, 4, 6]
print(solution.findDifference(nums1, nums2))
