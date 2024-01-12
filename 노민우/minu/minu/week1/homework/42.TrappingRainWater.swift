//
//  42.TrappingRainWater.swift
//  minu
//
//  Created by 노민우 on 1/8/24.
//

import Foundation

class Solution {
    func trap(_ height: [Int]) -> Int {
        var volume = 0
        var left = 0
        var right = height.count - 1
        var leftMax = height[left]
        var rightMax = height[right]
        while left < right {
            leftMax = max(leftMax, height[left])
            rightMax = max(rightMax, height[right])
            
            if leftMax < rightMax {
                
                volume += leftMax - height[left]
                left += 1
            } else {
                
                volume += rightMax - height[right]
                right -= 1
            }
        }
        return volume // 총 정체된 물의 양을 반환
    }
    var height = [1,1,0,2,1,0,1,3,2,1,2,1]
    print(trap(height))
}
