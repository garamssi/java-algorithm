//
//  main.swift
//  minu
//
//  Created by 노민우 on 1/3/24.
//

import Foundation

/*
 문제 설명
 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

 제한사항
 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다. 10^5 O(n)이하
 completion의 길이는 participant의 길이보다 1 작습니다.
 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 참가자 중에는 동명이인이 있을 수 있습니다.
 
                    participant(참가자)                             completion(완료)                return (완주못함)
 ["leo", "kiki", "eden"]                                       ["eden", "kiki"]                   "leo"
 ["marina", "josipa", "nikola", "vinko", "filipa"]    ["josipa", "filipa", "marina", "nikola"]    "vinko"
 ["mislav", "stanko", "mislav", "ana"]                     ["stanko", "ana", "mislav"]            "mislav"
 */

import Foundation

class Solution {
    func solution(participant: [String], completion: [String]) -> String{
        var completionDict = [String: Int]()

        // 참가 선수 이름을 기록하면서 동명이인 경우 카운트 증가
        for p in participant {
            completionDict[p, default: 0] += 1
        }

        // 완주한 선수 이름을 제거
        for c in completion {
            if let left = completionDict[c], left > 1 {
                completionDict[c] = left - 1
            } else {
                completionDict.removeValue(forKey: c)
            }
        }

        // 남아 있는 미완주 선수의 이름을 반환
        return completionDict.first!.key
    }
}

let sol = Solution()
sol.solution(participant:  ["marina", "josipa", "nikola", "vinko", "filipa"], completion: ["josipa", "filipa", "marina", "nikola"])

