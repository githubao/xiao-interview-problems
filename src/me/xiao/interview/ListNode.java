package me.xiao.interview;

/**
 * 链表
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/11 16:01
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
