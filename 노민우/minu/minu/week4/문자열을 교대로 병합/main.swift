//
//  main.swift
//  minu
//
//  Created by 노민우 on 1/23/24.
//

import Foundation
/*
 1768. Merge Strings Alternately
 
 두 개의 문자열 word1과 word2가 제공됩니다.
 word1부터 시작하여 교대로 문자를 추가하여 문자열을 병합합니다.
 문자열이 다른 문자열보다 길면 병합된 문자열 끝에 추가 문자를 추가합니다.

 병합된 문자열을 반환합니다.
 
 Example 1:

 Input: word1 = "abc", word2 = "pqr"
 Output: "apbqcr"
 Explanation: The merged string will be merged as so[설명: 병합된 문자열은 다음과 같이 병합됩니다.]:
 word1:  a   b   c
 word2:    p   q   r
 merged: a p b q c r
 
 Example 2:

 Input: word1 = "ab", word2 = "pqrs"
 Output: "apbqrs"
 Explanation: Notice that as word2 is longer, "rs" is appended to the end.[word2가 길수록 "rs"가 끝에 추가됩니다.]
 word1:  a   b
 word2:    p   q   r   s
 merged: a p b q   r   s
 Example 3:

 Input: word1 = "abcd", word2 = "pq"
 Output: "apbqcd"
 Explanation: Notice that as word1 is longer, "cd" is appended to the end.[word1이 길수록 "cd"가 끝에 추가됩니다.]
 word1:  a   b   c   d
 word2:    p   q
 merged: a p b q c   d
 
 Constraints: O(1)

 1 <= word1.length, word2.length <= 100
 word1 and word2 consist of lowercase English letters.[word1과 word2는 영문 소문자로 구성됩니다.]
 
 1)word1, 2를 순회하면서 문자를 합치고 더 긴 문자열이있으면 남은 문자들을 합친 문자열 뒤에 추가한다.
 2)두 문자를 동시에 순회하면서 w1 하나 w2 하나 를 번갈아가면서 추가. 한 문자열이 끝나면 다른 문자열의 남은 문자들을 결과에 추가한다.
 3)- for문을 사용해 문자 순회.
   - 문자열 길이가 서로 다를 수 있으므로, 더 긴 길이의 문자열 만큼 반복한다.
   - 루프가 완료되면 결과 문자열 반환.
 
 
 */
class Solution {
    func mergeAlternately(_ word1: String, _ word2: String) -> String {
        var result = ""
        let maxLength = max(word1.count, word2.count)
        // 문자열 배열로 형변환
        let char1 = Array(word1)
        let char2 = Array(word2)
        
        for i in 0..<maxLength {
            if i < char1.count {
                result += String(char1[i])
            }
            
            if i < char2.count {
                result += String(char2[i])
            }
        }
        
        return result
    }
}

let sol = Solution()
sol.mergeAlternately("abcd", "pq")
