package me.xiao.interview.ch03;

import java.util.Stack;

/**
 * 判断是个序列是不是栈的一个弹出序列
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/12 15:56
 */

public class Section22_StackSequence {
    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
//        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop1 = {4, 3, 5, 1, 2};
        System.out.println(new Section22_StackSequence().isPopOrder(push, pop1));
    }

    private boolean isPopOrder(int[] push, int[] pop) {
        if (push == null || pop == null || push.length == 0 || pop.length == 0 || push.length != pop.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;

        while (popIndex < pop.length) {
            while (pushIndex < push.length && (stack.isEmpty() || stack.peek() != pop[popIndex])) {
                stack.push(push[pushIndex]);
                pushIndex++;
            }

            if (stack.peek() == pop[popIndex]) {
                stack.pop();
                popIndex++;
            } else {
                return false;
            }
        }

        return true;

    }
}
