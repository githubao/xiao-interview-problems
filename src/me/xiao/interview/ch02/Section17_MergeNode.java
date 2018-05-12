package me.xiao.interview.ch02;

import me.xiao.interview.ListNode;

/**
 * 合并排好序的两个链表节点
 *
 * 把找到的节点“接过去”就可以了
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/12 14:27
 */

public class Section17_MergeNode {
    public static void main(String[] args) {
        ListNode head1 = ListNode.defaultBuild();
        ListNode head2 = new ListNode(0);
        System.out.println(new Section17_MergeNode().merge(head1, head2));
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        ListNode root = new ListNode();
        ListNode curr = root;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }

            curr = curr.next;
        }

        if (head1 != null) curr.next = head1;
        if (head2 != null) curr.next = head2;

        return root.next;
    }
}
