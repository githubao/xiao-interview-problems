package me.xiao.interview.ch02;

/**
 * 给定n，打印从1到最大n位数的数
 * <p>
 * 比如给定3，从1打印到999
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/12 13:07
 */

public class Section12_PrintNum {
    public static void main(String[] args) {
        new Section12_PrintNum().printNum(3);
    }

    private void printNum(int num) {
        if (num < 1) {
            throw new RuntimeException("num less than 1");
        }

        int[] arr = new int[num];
        print(0, arr);

    }

    private void print(int k, int[] arr) {
        if (k >= arr.length) {
            printArr(arr);
        } else {
            for (int i = 0; i < 10; i++) {
                arr[k] = i;
                print(k + 1, arr);
            }
        }


    }

    private void printArr(int[] arr) {
        int index = 0;
        while (index < arr.length && arr[index] == 0) {
            index++;
        }

        for (int i = index; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        if (index < arr.length) {
            System.out.println();
        }

    }
}
