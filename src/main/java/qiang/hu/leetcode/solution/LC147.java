package qiang.hu.leetcode.solution;

import qiang.hu.leetcode.model.ListNode;

public class LC147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tmpHead = new ListNode(-1);
        while (head != null) {
            var current = head;
            head = head.next;
            current.next = null;
            var prev = tmpHead;
            var pointer = tmpHead.next;
            while (pointer != null && pointer.val <= current.val) {
                prev = pointer;
                pointer = pointer.next;
            }
            current.next = pointer;
            prev.next = current;
        }

        return tmpHead.next;
    }
}
