package me.xiao.interview.ch01;

/**
 * 求斐波那契数列
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/12 12:23
 */

public class Section09_Fibonacci {
    public static void main(String[] args) {
        System.out.println(new Section09_Fibonacci().fibonacci(7));
    }

    private int fibonacci(int num) {
        if (num <= 0) return -1;
        if (num <= 2) return 1;

        int first = 1;
        int second = 1;

        int third = -1;

        for (int i = 2; i < num; i++) {
            third = first + second;

            first = second;
            second = third;
        }

        return third;

    }
}
