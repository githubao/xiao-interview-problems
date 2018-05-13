package me.xiao.interview.ch04;

/**
 * 统计逆序对的个数
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/13 23:39
 */

public class Section36_InversePairs {
    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        System.out.println(new Section36_InversePairs().inversePairs(nums));
    }

    private int inversePairs(int[] nums) {
        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException("arg err");
        }

        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);

        return doInversePairs(nums, copy, 0, nums.length - 1);
    }

    private int doInversePairs(int[] nums, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = copy[end];
            return 0;
        }

        int len = (end - start) / 2;
        int left = doInversePairs(copy,nums, start, start + len);
        int right = doInversePairs(copy,nums,  start + len + 1, end);

        int i = start + len;
        int j = end;

        int indexCopy = end;
        int count = 0;

        while (i >= start && j >= start + len + 1) {
            if (nums[i] > nums[j]) {
                copy[indexCopy] = nums[i];
                indexCopy--;
                i--;
                count += j - (start + len);
            } else {
                copy[indexCopy] = nums[j];
                indexCopy--;
                j--;
            }
        }

        for (; i >= start; ) {
            copy[indexCopy] = nums[i];
            indexCopy--;
            i--;
        }

        for (; j >= start + len + 1; ) {
            copy[indexCopy] = nums[j];
            indexCopy--;
            j--;
        }

        return count + left + right;
    }
}
