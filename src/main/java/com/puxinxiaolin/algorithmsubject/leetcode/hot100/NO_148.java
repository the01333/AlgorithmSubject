package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

public class NO_148 {
    static class ListNode {
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

    /**
     * 归并排序
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head, preMid = null;
        // 1. 找分割点（中点前一个）
        while (fast != null && fast.next != null) {
            preMid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 从分割点断开链表（让分割点指向空）
        preMid.next = null;

        // 3. 递归两边
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        // 4. 合并
        return merge(left, right);
    }

    /**
     * 合并链表
     *
     * @param left
     * @param right
     * @return
     */
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }

            p = p.next;
        }

        // 考虑剩下的直接拼接尾部
        p.next = left != null ? left : right;
        return dummy.next;
    }

    public static void main(String[] args) {
        NO_148 test = new NO_148();
        ListNode input = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode expected = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(isEqual(test.sortList(input), expected));

        input = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        expected = new ListNode(-1, new ListNode(0, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(isEqual(test.sortList(input), expected));

        input = new ListNode();
        expected = new ListNode();
        System.out.println(isEqual(test.sortList(input), expected));
    }

    private static boolean isEqual(ListNode a, ListNode b) {
        while (a != null && b != null) {
            if (a.val != b.val) return false;
            a = a.next;
            b = b.next;
        }
        return a == null && b == null;
    }
}
