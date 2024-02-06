//
//  main.swift
//  minu
//
//  Created by 노민우 on 1/27/24.
//

import Foundation
/*
 두 개의 문자열 s와 t가 주어지면 s가 t의 하위 수열이면 true를 반환하고 그렇지 않으면 false를 반환합니다.

 문자열의 하위 시퀀스는 나머지 문자의 상대적 위치를 방해하지 않고 일부 문자를 삭제하여(아무 것도 아닐 수 있음) 원래 문자열에서 형성된 새 문자열입니다.
 (즉, "ace"는 "abcde"의 하위 수열이지만 "aec"는 그렇지 않습니다.)
 순서를 유지한채로 가져와야함.
 
 Example 1:

 Input: s = "abc", t = "ahbgdc"
 Output: true
 Example 2:

 Input: s = "axc", t = "ahbgdc"
 Output: false
  

 Constraints:

 0 <= s.length <= 100
 0 <= t.length <= 10^4
 s and t consist only of lowercase English letters
 
 */
class Solution {
    func isSubsequence(_ s: String, _ t: String) -> Bool {
        
        var sPointer = 0 // 문자열
        var tPointer = 0 // 하위 시퀀스 확인
        
        while sPointer < s.count && tPointer < t.count {
            
            if s[s.index(s.startIndex, offsetBy: sPointer)] == t[t.index(t.startIndex, offsetBy: tPointer)] {
                sPointer += 1
            }
            
            tPointer += 1
        }
        // Input: s = "abc", t = "ahbgdc"
        // while loop 1 : s[s.index(a,0)] == t[t.index(a, 0)] -> a 같음 sPointer 증가 sPointer += 1
        // while loop 2 : s[s.index(a,1)] == t[t.index(a, 0)] -> b 랑 a 다름 tPointer 증가 tPointer += 1
        // while loop 2 : s[s.index(a,1)] == t[t.index(a, 1)] -> b 랑 h 다름 tPointer 증가 sPointer += 2
        // while loop 2 : s[s.index(a,1)] == t[t.index(a, 2)] -> b 랑 b 같음 sPointer 증가 sPointer += 2
        // while loop 2 : s[s.index(a,2)] == t[t.index(a, 2)] -> c 랑 b 다름 tPointer 증가 tPointer += 3
        // while loop 2 : s[s.index(a,2)] == t[t.index(a, 3)] -> c 랑 g 다름 tPointer 증가 tPointer += 4
        // while loop 2 : s[s.index(a,2)] == t[t.index(a, 4)] -> c 랑 d 다름 tPointer 증가 sPointer += 5
        // while loop 2 : s[s.index(a,2)] == t[t.index(a, 5)] -> c 랑 c 같음 sPointer 증가 sPointer += 3
        
        return sPointer == s.count
    }
}
