package me.xiao.interview.ch02;

import me.xiao.interview.ListNode;

/**
 * 找到倒数第k个节点
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/12 13:51
 */

public class Section15_FindNode {
    public static void main(String[] args) {
        ListNode root = ListNode.defaultBuild();

        System.out.println(new Section15_FindNode().findKthToTail(root, 2));
    }

    private ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k < 1) return null;

        ListNode first = head;
        ListNode second = head;

        for (int i = 1; i < k; i++) {
            if (first.next != null) {
                first = first.next;
            } else {
                return null;
            }
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        return second;
    }
}
