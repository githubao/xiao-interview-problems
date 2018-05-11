package me.xiao.interview;

/**
 * 反向打印链表
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/11 16:02
 */

public class Section05_ReversePrint {

    public static void main(String[] args) {
        ListNode head = build();
        new Section05_ReversePrint().print(head);
    }

    /**
     * 递归其实就是压栈操作
     * @param head
     */
    private void print(ListNode head) {
        if (null != head) {
            print(head.next);
            System.out.print(head.val + "->");
        }
    }

    private static ListNode build() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        return root;
    }

}
