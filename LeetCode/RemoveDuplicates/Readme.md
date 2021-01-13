## 문제링크

[Remove Duplicates from Sorted List - LeetCode](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)

## 참고자료

- HashSet이란?

- [[Java] 자바 HashSet 사용법 & 예제 총정리](https://coding-factory.tistory.com/554)

## 접근과정

~~LinkedList를 돌면서 각 노드를 특정 공간에 보관한다.
반복하면서 노드를 저장할 떄, 중복된 값이 감지 될 경우, 
해당 노드를 삭제한다.

* 중복된 값을 저장하지 못하는 HashSet 이라는 자료구조를 알게돼 시도해봄.~~

**⇒ 문제가 오름차순, 규칙적으로 지정해주었기 때문에, 해당 과정은 불필요했다.**

## 나의 코드

```java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      
        while(head != null && head.next != null) {
            if(head.val == head.next.val){
                head.next = head.next.next;
            }
            else{
                head = head.next;
            }
        }

        return head;
    }
}
```

```java
Wrong Answer

Input: [1,1,2]
Output: [2]
Expected: [1,2]
```

# 💩 ?!!!!! 실패?!!! 💩💩💩💩💩💩💩💩

  실패하는 이유를 몰라 구글신께 검색을 해본 결과 한 가지 부분 빼고 나랑 비슷한 코드를 발견했다. 

parameter로 받아온 head를 ListNode 새로운 객체를 선언해 할당 해주었는데, 

head 객체의 주소를 전달해준 거라, 그냥 바로 사용해도 무방한게 아닌가??

## 참고코드

[LeetCode 83. Remove Duplicates from Sorted List【Java】 - Programmer Sought](https://programmersought.com/article/52684661418/)

```java

# 정상 동작 코드

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode node = head; // 내 코드와 다른 부분

        while(node != null && node.next != null) {
            if(node.val == node.next.val){
                node.next = node.next.next;
            }
            else{
                node = node.next;
            }
        }
        return head;
    }
}
```

```java
Success

Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
Memory Usage: 38 MB, less than 97.84% of Java online submissions for Remove Duplicates from Sorted List.
```