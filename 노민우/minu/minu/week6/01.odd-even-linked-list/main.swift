//
//  main.swift
//  minu
//
//  Created by 노민우 on 2/9/24.
//

import Foundation
/*
 단일 연결 리스트의 헤드가 주어지면 홀수 인덱스를 가진 모든 노드를 그룹화한 다음 짝수 인덱스를 가진 노드를 그룹화하고 재정렬된 리스트를 반환합니다.

 첫 번째 노드는 홀수로 간주되고, 두 번째 노드는 짝수로 간주됩니다.
 (이 부분에서 글이 잘못된거 같음. 첫번째, 두번째 노드가이니라 첫번째 count, 두번째 count 맞는 표현인거 같음.)
 
 짝수 그룹과 홀수 그룹 내부의 상대적 순서는 입력과 동일하게 유지되어야 합니다.
 [1,2,3,4,5]
  1,2,3,4,5
 >1,3,5,2,4
 
 [2,1,3,5,6,4,7]
  1,2,3,4,5,6,7
> 2,3,6,7,1,5,4

 O(1) 추가 공간 복잡도와 O(n) 시간 복잡도로 문제를 해결해야 합니다.
 
 Example 1:


 Input: head = [1,2,3,4,5]
 Output: [1,3,5,2,4]
 Example 2:


 Input: head = [2,1,3,5,6,4,7]
 Output: [2,3,6,7,1,5,4]
 
 Constraints:

 The number of nodes in the linked list is in the range [0, 10^4].
 -10^6 <= Node.val <= 10^6
 */

public class ListNode {
    public var val: Int
    public var next: ListNode?
    public init(val: Int) {
        self.val = val
        self.next = nil
    }
}

// ex) [2,1,3,5,6,4,7]
func oddEvenList(_ head: ListNode?) -> ListNode? {
    if head == nil { return nil }
    var odd = head // 홀수 -> 첫번째 노드값 (2)
    var even = head?.next // 짝수 -> 현재 순회중인 짝수노드를 가르키는 포인트. (1)
    let evenHead = even // 짝수(인덱스)의 첫번째를 가르키도록 하는 노드. (1)
    
    // even?.next 즉, 짝수노드가 nil일대까지 순회.
    // 첫번째 노드의 다음노드가 nil이 아니면
    while even?.next != nil {
        /* ex) [2,1,3,5,6,4,7]
                1 2 3 4 5 6 7
                * -> *
        첫번째 순회
        odd?.next = odd?.next?.next
        odd의 다음인 1을 odd의 다음 다음인 3으로 재배치
        1.-> 2,(3)
        2.-> 2,3,(6)
        3.-> 2,3,6,(7)
             */
        odd?.next = odd?.next?.next // 홀수 노드를 다음 홀수 노드로 이동
            /*
       ex) [2,1,3,5,6,4,7]
            1 2 3 4 5 6 7
        첫번째 순회
        even?.next = even?.next?.next
        even?.next는 2의 다음인 1을 가르킴,
        even?.next?.next는 2의 다음 다음인 5를 가르킴
        재배치
        1. -> 1,(5)
        2. -> 1,5,(4)
        3. -> 1,5,4, (nil) nil이므로 순회 종료.
        */
        even?.next = even?.next?.next
        
        odd = odd?.next // odd 포인터 업데이트
        even = even?.next // even 포인터 업데이트
    }
    // 순회가 끝나면 odd포인터는 마지막 홀수노드인 7을 가르킴.
    // 이 시점의 odd?.next를 evenHead(값 1의 노드)에 연결.
    // 홀수 노드.(2,3,4,5) -> 짝수노드 (1,5,4)
    // 2 -> 3 -> 6 -> 7 -> 1 -> 5 -> 4
    odd?.next = evenHead // 홀수 노드 리스트의 끈과 짝수노드 리스트의 시작.
    return head // 재수성된 list의 헤드 반환.
    
}

// 연결 리스트 [2, 1, 3, 5, 6, 4, 7] 생성
let head = ListNode(val: 2)
head.next = ListNode(val: 1)
head.next?.next = ListNode(val: 3)
head.next?.next?.next = ListNode(val: 5)
head.next?.next?.next?.next = ListNode(val: 6)
head.next?.next?.next?.next?.next = ListNode(val: 4)
head.next?.next?.next?.next?.next?.next = ListNode(val: 7)

// oddEventList힘스 실행
let modifiedHead = oddEvenList(head)

// 결과 출력함수.
func printList(_ head: ListNode?) {
    var current = head
    while current != nil {
        print("\(current!.val)", terminator: current?.next != nil ? " -> " : "")
        current = current?.next
    }
}

// 실행 결과 출력
printList(modifiedHead)
