package me.xiao.interview.ch02;

import java.util.Arrays;

/**
 * 把奇数移动到偶数的前面
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/12 13:40
 */

public class Section14_ChangeOrder {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        new Section14_ChangeOrder().reorder(nums);
        System.out.println(Arrays.toString(nums));
    }

    private void reorder(int[] nums) {
        if (nums == null || nums.length < 2) return;

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            while (start < end && nums[start] % 2 != 0) {
                start++;
            }
            while (start < end && nums[end] % 2 == 0) {
                end--;
            }

            swap(nums, start, end);
        }

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
