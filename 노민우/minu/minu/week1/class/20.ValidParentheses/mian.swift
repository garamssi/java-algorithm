//
//  stackParenthesis.swift
//  minu
//
//  Created by 노민우 on 1/8/24.
//

import Foundation

/*
 좀 더 연습 필요
 Example 1:

 Input: s = "()"
 Output: true
 Example 2:

 Input: s = "()[]{}"
 Output: true
 Example 3:

 Input: s = "(]"
 Output: false
 
 Constraints:

 1 <= s.length <= 10^4
 s consists of parentheses only '()[]{}'.
 
 */
class Solution {
    
    func isValid(_ s: String) -> Bool {
    var stack: [Character] = []
        
        for p in s {
            if p == "(" {
                stack.append(")")
            } else if p == "{" {
                stack.append("}")
            } else if p == "[" {
                stack.append("]")
            } else {
                if stack.isEmpty || stack.removeLast() != p {
                    return false
                }
            }
        }
        
        return true
    }
}

let solution = Solution()
solution.isValid("()[]{}")
