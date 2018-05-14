package me.xiao.interview.ch04;

import java.util.Arrays;

/**
 * 找到数组中两个只出现过一次的数字
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/14 11:24
 */

public class Section40_OnceOccur {
    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 6, 3, 2, 5};
        int[] results = new Section40_OnceOccur().onceOccur(nums);
        System.out.println(Arrays.toString(results));
    }

    private int[] onceOccur(int[] nums) {
        int[] results = {0, 0};
        if (nums == null || nums.length < 2) {
            return results;
        }

        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }

        int indexOf1 = findFirstBit1(xor);

        for (int i : nums) {
            if (isBit1(i, indexOf1)) {
                results[0] ^= i;
            } else {
                results[1] ^= i;
            }
        }

        return results;

    }

    private boolean isBit1(int num, int indexBit) {
        num >>>= indexBit;
        return (num & 1) == 1;
    }

    private int findFirstBit1(int num) {
        int index = -1;
        while ((num & 1) == 0 && index < 32) {
            num >>>= 1;
            index++;
        }
        return index;
    }
}
