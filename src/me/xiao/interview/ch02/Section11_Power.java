package me.xiao.interview.ch02;

/**
 * 计算求和
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/12 12:54
 */

public class Section11_Power {
    public static void main(String[] args) {
        System.out.println(new Section11_Power().myPow(2, 5));
    }

    private int myPow(int base, int num) {
        if (base == 0 && num == 0) {
            throw new RuntimeException("invalid input");
        }
        if (num == 0) return 1;

        int exp = num > 0 ? num : -num;

        int result = cal(base, exp);

        if (num < 0) return 1 / result;

        return result;


    }

    private int cal(int base, int num) {
        if (num == 0) return 1;
        if (num == 1) return base;

        int result = cal(base, num >> 1);
        result *= result;
        if (num % 2 != 0) {
            result *= base;
        }

        return result;
    }
}
