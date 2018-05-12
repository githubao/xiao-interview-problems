package me.xiao.interview.ch01;

import me.xiao.interview.ListNode;

/**
 * 反向打印链表
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/11 16:02
 */

public class Section05_ReversePrint {

    public static void main(String[] args) {
        ListNode head = ListNode.defaultBuild();
        new Section05_ReversePrint().print(head);
    }

    /**
     * 递归其实就是压栈操作
     *
     * @param head
     */
    private void print(ListNode head) {
        if (null != head) {
            print(head.next);
            System.out.print(head.val + "->");
        }
    }

}
