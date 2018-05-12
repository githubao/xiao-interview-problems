package me.xiao.interview.ch02;

import me.xiao.interview.ListNode;

/**
 * 反转链表
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/12 14:05
 */

public class Section16_ReverseNode {
    public static void main(String[] args) {
        ListNode head = ListNode.defaultBuild();

        ListNode reversed = new Section16_ReverseNode().reverse(head);

        System.out.println(reversed);
    }

    private ListNode reverse(ListNode head) {
        if (null == head) {
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        ListNode result = null;

        while (curr != null) {
            result = curr;

            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return result;
    }
}
