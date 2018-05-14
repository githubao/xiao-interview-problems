package me.xiao.interview.ch05;

/**
 * 计算加法
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/14 11:39
 */

public class Section47_AddNumber {
    public static void main(String[] args) {
        System.out.println(new Section47_AddNumber().add(3, 6));
    }

    private int add(int x, int y) {
        int sum;
        int carry;

        do {
            // 相加不进位
            sum = x ^ y;
            // 只计算进位
            carry = (x & y) << 1;

            // 两个加起来
            x = sum;
            y = carry;

        } while (y > 0);

        return sum;
    }
}
