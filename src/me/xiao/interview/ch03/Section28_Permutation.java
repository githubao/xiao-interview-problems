package me.xiao.interview.ch03;

import java.util.Arrays;

/**
 * 输出一个字符的全排列
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/12 19:31
 */

public class Section28_Permutation {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c'};
        new Section28_Permutation().permutation(chars);
    }

    private void permutation(char[] chars) {
        if (chars == null || chars.length == 0) return;

        permutation(chars, 0);
    }

    /**
     * 先交换第一个位置 和 后面的位置，第一个位置就固定了
     * 求后面的全排列
     * 然后再换回来，之后再交换下一个字符
     *
     * @param chars
     * @param cnt
     */
    private void permutation(char[] chars, int cnt) {
        if (cnt == chars.length - 1) {
            System.out.println(Arrays.toString(chars));
        } else {
            for (int i = cnt; i < chars.length; i++) {
                swap(chars, cnt, i);
                permutation(chars, cnt + 1);
                swap(chars, cnt, i);
            }
        }

    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
