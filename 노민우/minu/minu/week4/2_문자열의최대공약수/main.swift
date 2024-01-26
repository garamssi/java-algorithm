//
//  mian.swift
//  minu
//
//  Created by 노민우 on 1/26/24.
//

import Foundation
/* GCD 문제
 For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).

 Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

 두 문자열 s와 t에 대해 s = t + ... + t인 경우에만 "t가 s를 나눕니다"라고 말합니다(즉, t가 자신과 한 번 이상 연결됨).
두 개의 문자열 str1과 str2가 주어지면 x가 str1과 str2를 모두 나누는 가장 큰 문자열 x를 반환합니다.
 
 Example 1:

 Input: str1 = "ABCABC", str2 = "ABC"
 Output: "ABC"
 Example 2:

 Input: str1 = "ABABAB", str2 = "ABAB"
 Output: "AB"
 Example 3:

 Input: str1 = "LEET", str2 = "CODE"
 Output: ""

 Constraints: O(logN)

 1 <= str1.length, str2.length <= 1000
 str1 and str2 consist of English uppercase letters.
 
 */
class Solution {
    func gcdOfStrings(_ str1: String, _ str2: String) -> String {
        
        // base case
        if str1 + str2 != str2 + str1 {
            return ""
        }
        // 최대 공약수 계산
        func gcd(_ a: Int, _ b: Int) -> Int {
            return b == 0 ? a : gcd(b, a % b)
        }
        
        let countGCD = gcd(str1.count, str2.count)
        return String(str1.prefix(countGCD))
        
        
    }
}

let sol = Solution()
// Example Usage
let result = sol.gcdOfStrings("ABABAB", "ABAB")
print(result)
