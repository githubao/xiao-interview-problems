package me.xiao.interview.ch04;

/**
 * 在一个数组中找到k出现的次数
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/14 10:49
 */

public class Section38_FindKCount {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(new Section38_FindKCount().findKCount(nums, 3));
    }

    private int findKCount(int[] nums, int k) {
        int res = 0;
        if (nums != null && nums.length > 0) {
            int first = getFirst(nums, k, 0, nums.length - 1);
            int last = getLast(nums, k, 0, nums.length - 1);

            if (first > -1 && last > -1) {
                res = last - first + 1;
            }
        }

        return res;
    }

    private int getLast(int[] nums, int k, int start, int end) {
        if (nums == null || nums.length == 0 || start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int data = nums[mid];

        if (data == k) {
            if (mid < nums.length-1 && nums[mid + 1] != k || mid == nums.length - 1) {
                return mid;
            } else {
                start = mid + 1;
            }
        } else if (mid > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }

        return getLast(nums, k, start, end);
    }


    private int getFirst(int[] nums, int k, int start, int end) {
        if (nums == null || nums.length == 0 || start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int data = nums[mid];

        if (data == k) {
            if (mid > 0 && nums[mid - 1] != k || mid == 0) {
                return mid;
            } else {
                end = mid - 1;
            }
        } else if (mid > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }

        return getFirst(nums, k, start, end);
    }

}
