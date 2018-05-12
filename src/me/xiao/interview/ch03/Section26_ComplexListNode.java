package me.xiao.interview.ch03;

/**
 * 复杂链表复制
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/12 18:02
 */

public class Section26_ComplexListNode {
    static class ComplexListNode {
        int value;
        ComplexListNode next;
        ComplexListNode random;

        public ComplexListNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            int randomValue = random == null ? -1 : random.value;
            int nextValue = next == null ? -1 : next.value;

            return "ComplexListNode{" +
                    "value=" + value +
                    ", next=" + nextValue +
                    ", random=" + randomValue +
                    '}';
        }

        public void print() {
            System.out.println(this);
            if (this.next != null) {
                this.next.print();
            }
        }
    }

    public static void main(String[] args) {
        ComplexListNode one = new ComplexListNode(1);
        ComplexListNode two = new ComplexListNode(2);
        ComplexListNode three = new ComplexListNode(3);
        ComplexListNode four = new ComplexListNode(4);
        ComplexListNode five = new ComplexListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        one.random = three;
        two.random = five;
        four.random = two;

        ComplexListNode cloned = new Section26_ComplexListNode().clone(one);

        cloned.print();

    }

    private ComplexListNode clone(ComplexListNode head) {
        if (head == null) return null;

        cloneNodes(head);
        connectNodes(head);

        return reconnectNodes(head);

    }

    private ComplexListNode reconnectNodes(ComplexListNode head) {
        if (head == null) return null;
        ComplexListNode copy = head.next;
        ComplexListNode curr = copy;

        head.next = copy.next;
        head = head.next;

        while (head != null) {
            curr.next = head.next;
            curr = curr.next;
            head.next = curr.next;
            head = curr.next;
        }

        return copy;
    }

    private void connectNodes(ComplexListNode head) {
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }

    private void cloneNodes(ComplexListNode head) {
        while (head != null) {
            ComplexListNode tmp = new ComplexListNode(head.value + 100);
            tmp.next = head.next;

            head.next = tmp;

            head = tmp.next;
        }
    }
}
