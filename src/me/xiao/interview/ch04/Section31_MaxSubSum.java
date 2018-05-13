package me.xiao.interview.ch04;

/**
 * 最大连续子数组和
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/13 22:12
 */

public class Section31_MaxSubSum {
    public static void main(String[] args) {
        int[] nums = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(new Section31_MaxSubSum().maxSubSum(nums));
    }

    private int maxSubSum(int[] nums) {
        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException("wrong args");
        }

        int max = Integer.MIN_VALUE;
        int maxHere = 0;

        for (int num : nums) {
            if (maxHere > 0) {
                maxHere += num;
            } else {
                maxHere = num;
            }

            if (maxHere > max) {
                max = maxHere;
            }
        }

        return max;
    }
}
