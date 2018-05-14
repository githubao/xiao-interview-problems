package me.xiao.interview.ch06;

import me.xiao.interview.ListNode;

/**
 * 环的入口节点
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/14 11:54
 */

public class Section56_CircleEntrance {
    public static void main(String[] args) {
        ListNode head = ListNode.defaultBuild2();
        ListNode node = new Section56_CircleEntrance().meetingNode(head);
        System.out.println(node.val);
    }

    private ListNode meetingNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        fast = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
