package problems51to100;

import commonStruct.ListNode;

public class ReverseLinkedListII92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode start = null;
        ListNode end = head;
        int count = 1;
        if(m > 1) {
            while(count < m) {
                if(start == null) {
                    start = head;
                } else {
                    start = start.next;
                }
                count++;
            }
            end = start;
        } else {
            start = null;
        }
        while(count <= n) {
            end = end.next;
            count++;
        }
        ListNode rev = null;
        if(start == null) {
            rev = modReverse(head, n-m, end);
        } else {
            rev = modReverse(start.next, n-m, end);
        }
        if(start == null) {
            return rev;
        } else {
            start.next = rev;
            return head;
        }
    }
    
    private ListNode modReverse(ListNode node, int i, ListNode last) {
        if(node == null || node.next == null || i <=1) {
            return node;
        }
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = node.next;
        int count = 1;
        while(curr != null && count <= i+1) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(curr != null) {
                next = curr.next;
            }
            count++;
            if(count > i) {
                node.next = last;
            }
        }
        return prev;
    }
}