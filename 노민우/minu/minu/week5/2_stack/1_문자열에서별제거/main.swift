//
//  main.swift
//  minu
//
//  Created by 노민우 on 2/6/24.
//

import Foundation
/*
 별 *을 포함하는 문자열 s가 제공됩니다.(ex: "leet**cod*e")
 한 번의 작업으로 다음을 수행할 수 있습니다.

 s에서 별을 선택하세요.
 왼쪽에 가장 가까운 별표가 아닌 문자를 제거하고 별 자체도 제거합니다.
 별표를 모두 제거한 후 문자열을 반환합니다.
 
 1.이해
 문자열을 분해하면서 *앞이 문자와 *를 같이 제거하라는 말 같음. Stack이 적합
 
 메모:
  작업이 항상 가능하도록 입력이 생성됩니다.
  결과 문자열은 항상 고유하다는 것을 알 수 있습니다.
 
 Example 1:

 Input: s = "leet**cod*e"
 Output: "lecoe"
 Explanation: Performing the removals from left to right:
 - The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
 - The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
 - The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
 There are no more stars, so we return "lecoe".
 Example 2:

 Input: s = "erase*****"
 Output: ""
 Explanation: The entire string is removed, so we return an empty string.
  
 Constraints:

O(N)이하
 1 <= s.length <= 10^5
 s consists of lowercase English letters and stars *.
 The operation above can be performed on s.
 s는 영문 소문자와 별표 *로 구성됩니다.
  위 작업은 s에서 수행할 수 있습니다.
 */

// stack 에선 count, isEmpty, push, pop, top 등이있다.
class Solution {
    func removeStars(_ s: String) -> String {
       var stack = [Character]()
        
        // "leet**cod*e"
        for char in s {
            if char == "*" {
                //5. * 이기때문에 마지막 문자 t 삭제
                //6. * 이기때문에 마지막 문자 e 삭제
                //10.* 이기때문에 마지막 문자 d 삭제
                stack.popLast()
            } else {
                stack.append(char)
                //1. l
                //2. e
                //3. e ->6. 삭제
                //4. t ->5. 삭제
                //7. c
                //8. o
                //9. d -> 10. 삭제
                //11.e
                
            }
        }
        //최종 : lecoe
        return String(stack)
    }
}

var sol = Solution()
print(sol.removeStars("leet**cod*e"))
