package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

public class NO_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1 != null || l2 != null || temp != 0) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum = v1 + v2 + temp;
            temp = sum / 10;
            
            p.next = new ListNode(sum % 10);
            p = p.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        PrintLinkedList.print(new NO_2().addTwoNumbers(l1, l2));
        
        l1 = new ListNode(0);
        l2 = new ListNode(0);
        PrintLinkedList.print(new NO_2().addTwoNumbers(l1, l2));
        
        l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);
        l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        PrintLinkedList.print(new NO_2().addTwoNumbers(l1, l2));
    }
    
    public static class PrintLinkedList {
        public static void print(ListNode head) {
            while (head != null) {
                System.out.print(head.val + " ");
                head = head.next;
            }
            System.out.println();
        }
    }
}
