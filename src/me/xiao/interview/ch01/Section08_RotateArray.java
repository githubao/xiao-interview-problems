package me.xiao.interview.ch01;

/**
 * 输出一个排好序的数组的旋转的最小值
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/11 17:59
 */

public class Section08_RotateArray {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(new Section08_RotateArray().findSmallest(nums));
    }

    private int findSmallest(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("Invalid input");
        }

        int lo = 0;
        int hi = nums.length - 1;
        int mi = lo;

        while (nums[lo] >= nums[hi]) {
            if (hi - lo == 1) {
                return nums[hi];
            }
            mi = (lo + hi) / 2;
            if (nums[mi] == nums[lo] && nums[hi] == nums[mi]) {
                return minInorder(nums, lo, hi);
            }

            if (nums[mi] >= nums[lo]) {
                lo = mi;
            } else if (nums[mi] <= nums[hi]) {
                hi = mi;
            }

        }
        return nums[mi];
    }

    private int minInorder(int[] nums, int start, int end) {
        int result = nums[start];
        for (int i = start + 1; i < end; i++) {
            if (result > nums[i]) {
                result = nums[i];
            }
        }
        return result;
    }
}
