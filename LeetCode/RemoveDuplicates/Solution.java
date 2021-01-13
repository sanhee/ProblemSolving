package com.example.LeetCode.RemoveDuplicates;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Solution {

    public static ListNode deleteDuplicates(ListNode head) {
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
    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.append(1);
        listNode.append(1);
        listNode.append(2);
        listNode.append(2);
        listNode.append(3);
        listNode.append(3);
        listNode.retrieve();

        deleteDuplicates(listNode);
        listNode.retrieve();
    }
}

