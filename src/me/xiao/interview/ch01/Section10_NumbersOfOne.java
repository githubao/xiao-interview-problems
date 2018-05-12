package me.xiao.interview.ch01;

/**
 * 二进制1的个数
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/12 12:33
 */

public class Section10_NumbersOfOne {
    public static void main(String[] args) {
        int num = 0b00001101;
//        int num = Integer.MIN_VALUE;
        System.out.println(new Section10_NumbersOfOne().numOfOne2(num));
    }

    /**
     * 无符号右移 >>>
     * 有符号右移 >>
     *
     * @param num
     * @return
     */
    private int numOfOne(int num) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += num & 1;
            num >>>= 1;
//            num >>= 1;
        }
        return count;
    }

    private int numOfOne2(int num) {
        int count = 0;
        while (num > 0) {
            ++count;
            num = num & (num - 1);
        }
        return count;
    }
}
