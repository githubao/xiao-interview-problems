package me.xiao.interview.ch03;

import java.util.Stack;

/**
 * 有最小值功能的栈
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/12 15:50
 */

public class Section21_StackWithMin {
    private Stack<Node> stack = new Stack<>();

    public static void main(String[] args) {
        Section21_StackWithMin minStack = new Section21_StackWithMin();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    private int getMin() {
        return stack.peek().min;
    }

    private int top() {
        return stack.peek().value;
    }

    private void pop() {
        stack.pop();
    }

    private void push(int x) {
        Node node;
        if (!stack.isEmpty()) {
            Node top = stack.peek();
            node = new Node(x, Math.min(top.min, x));
        } else {
            node = new Node(x, x);
        }
        stack.push(node);
    }

    class Node {
        int value;
        int min;

        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
}
