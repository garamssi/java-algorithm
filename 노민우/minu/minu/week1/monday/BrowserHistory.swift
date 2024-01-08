//
//  BrowserHistory.swift
//  minu
//
//  Created by 노민우 on 1/8/24.
//

import Foundation

//
//  BrowserHistory.swift
//  minu
//
//  Created by 노민우 on 1/8/24.
//

import Foundation

// 노드 클래스 정의: 브라우저의 각 웹 페이지를 나타냄
class ListNode {
    var val: String  // 웹 페이지 URL 저장
    var next: ListNode?  // 다음 노드를 가리키는 포인터
    var prev: ListNode?  // 이전 노드를 가리키는 포인터

    // 노드 초기화
    init(_ val: String, _ next: ListNode? = nil, _ prev: ListNode? = nil) {
        self.val = val
        self.next = next
        self.prev = prev
    }
}

// 브라우저 기록을 관리하는 클래스
class BrowserHistory {
    var head: ListNode  // 리스트의 시작 노드
    var current: ListNode  // 현재 보고 있는 페이지 노드

    // 초기 홈페이지 설정
    init(_ homepage: String) {
        self.head = ListNode(homepage)
        self.current = self.head
    }

    // 새 웹 페이지 방문
    func visit(_ url: String) {
        self.current.next = ListNode(url, nil, self.current)
        self.current = self.current.next!
    }

    // 뒤로 가기 기능
    func back(_ steps: Int) -> String {
        var steps = steps
        while steps > 0 && self.current.prev != nil {
            steps -= 1
            self.current = self.current.prev!
        }
        return self.current.val
    }

    // 앞으로 가기 기능
    func forward(_ steps: Int) -> String {
        var steps = steps
        while steps > 0 && self.current.next != nil {
            steps -= 1
            self.current = self.current.next!
        }
        return self.current.val
    }
}
