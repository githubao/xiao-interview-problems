package me.xiao.interview.ch01;

import java.util.Stack;

/**
 * stack 转换成 queue
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/11 17:31
 */

public class Section07_Stack2Queue<T> {

    public static void main(String[] args) {
        Section07_Stack2Queue<Integer> queue = new Section07_Stack2Queue<>();

        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        queue.deleteHead();

        System.out.println(queue);
    }

    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public void appendTail(T t) {
        stack1.add(t);
    }

    public T deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            throw new RuntimeException("no more element");
        }

        return stack2.pop();
    }

    @Override
    public String toString() {
        return "Section07_Stack2Queue{" +
                "stack1=" + stack1 +
                ", stack2=" + stack2 +
                '}';
    }
}
