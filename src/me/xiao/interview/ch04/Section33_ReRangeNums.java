package me.xiao.interview.ch04;

import java.util.Comparator;

/**
 * 排列数组，组成一个最小的数
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/13 22:48
 */

public class Section33_ReRangeNums {
    public static void main(String[] args) {
        String[] nums = {"3", "32", "321"};
        System.out.println(new Section33_ReRangeNums().minNumber(nums));
    }

    private String minNumber(String[] nums) {
        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException("arg err");
        }

        MComparator mComparator = new MComparator();
        quickSort(nums, 0, nums.length - 1, mComparator);

        StringBuilder sb = new StringBuilder();
        for (String s : nums) {
            sb.append(s);
        }

        return sb.toString();
    }

    private static class MComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1 == null || o2 == null) {
                throw new IllegalArgumentException("args err");
            }

            String s1 = o1 + o2;
            String s2 = o2 + o1;

            return s1.compareTo(s2);
        }
    }

    private static void quickSort(String[] arr, int start, int end, Comparator<String> comparator) {
        if (start < end) {
            String pivot = arr[start];
            int left = start;
            int right = end;
            while (start < end) {
                while (start < end && comparator.compare(arr[end], pivot) >= 0) {
                    end--;
                }

                arr[start] = arr[end];

                while (start < end && comparator.compare(arr[start], pivot) <= 0) {
                    start++;
                }

                arr[end] = arr[start];
            }

            arr[start] = pivot;

            quickSort(arr, left, start - 1, comparator);
            quickSort(arr, start + 1, right, comparator);

        }

    }
}
