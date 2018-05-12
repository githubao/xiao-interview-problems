package me.xiao.interview.ch03;

/**
 * 判断一个数组是不是一个二叉搜索树的后序遍历序列
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/12 16:39
 */

public class Section24_VerifyTree {
    public static void main(String[] args) {
//        int[] nums = {4, 8, 6, 12, 16, 14, 10};
        int[] nums = {4, 3, 6, 12, 16, 14, 10};
//        int[] nums = {7, 4, 6, 5};
        System.out.println(new Section24_VerifyTree().verify(nums));
    }

    private boolean verify(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        return verify(nums, 0, nums.length - 1);
    }

    private boolean verify(int[] nums, int start, int end) {
        if (start >= end) return true;

        int index = start;
        while (index < end - 1 && nums[index] < nums[end])
            index++;

        int right = index;

        while (index < end - 1 && nums[index] > nums[end])
            index++;

        if (index != end - 1) {
            return false;
        }

        return verify(nums, start, right - 1) && verify(nums, right, end - 1);
    }

}
