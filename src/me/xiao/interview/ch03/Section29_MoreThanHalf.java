package me.xiao.interview.ch03;

/**
 * 找到数组中超过一半的数
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/12 19:52
 */

public class Section29_MoreThanHalf {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 5, 2, 2, 2, 2};
        int[] nums = {9, 4, 2, 1, 6, 5, 3, 8, 7};
        System.out.println(new Section29_MoreThanHalf().moreThanHalf(nums));
    }

    private int moreThanHalf(int[] nums) {
        if (nums == null || nums.length <= 0) return -1;
        int len = nums.length;
        int mid = len >> 1;
        int start = 0;
        int end = len - 1;
        int index = partition(nums, len, start, end);
        while (index != mid) {
            if (index > mid) {
                index = partition(nums, len, start, index - 1);
            } else {
                index = partition(nums, len, index + 1, end);
            }
        }
        return nums[mid];
    }

    private int partition(int[] nums, int len, int start, int end) {
        int pivot = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= pivot) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= pivot) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = pivot;
        return start;
    }
}
