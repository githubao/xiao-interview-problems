package me.xiao.interview.ch02;

import me.xiao.interview.ListNode;

/**
 * 删除一个链表的节点
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/12 13:28
 */

public class Section13_DeleteNode {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        ListNode node3 = new ListNode(3);
        root.next.next = node3;
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        new Section13_DeleteNode().delete(root, node3);

        System.out.println(root);
    }

    private ListNode delete(ListNode head, ListNode node) {
        if (null == head || node == null) {
            return head;
        }

        if (node.next == null) {
            ListNode curr = head;
            while (curr.next != node) {
                curr = curr.next;
            }
            curr.next = null;
        } else {
            node.val = node.next.val;
            node.next = node.next.next;
        }

        return head;
    }
}
