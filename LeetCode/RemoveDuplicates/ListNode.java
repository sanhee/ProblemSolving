package com.example.LeetCode.RemoveDuplicates;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {
        this.next= null;
    }
    ListNode(int val)
    {
        this.val = val;
    }
    ListNode(int val, ListNode next)
    {
        this.val = val;
        this.next = next;
    }

    void append(int d){
        ListNode node_end = new ListNode(d);
        ListNode node = this;

        while (node.next != null){
            node = node.next;
        }
        node.next = node_end;
    }
    void retrieve(){
        ListNode node = this;

        while (node.next != null){

            System.out.print(node.val+" -> ");
            node = node.next;
        }
        System.out.println(node.val);

    }



}
