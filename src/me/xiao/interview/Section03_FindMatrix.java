package me.xiao.interview;

import java.util.Arrays;

/**
 * 排好序的二维数据的顺序查找
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/11 13:37
 */

public class Section03_FindMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };

        int[] results = new Section03_FindMatrix().find(matrix, 7);

        System.out.println(Arrays.toString(results));
    }

    private int[] find(int[][] matrix, int num) {
        int[] result = {-1, -1};

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int i = 0, j = col - 1;
        while (i >= 0 && i < row && j >= 0 && j < col) {
            if (matrix[i][j] == num) {
                result[0] = i;
                result[1] = j;
                return result;
            } else if (matrix[i][j] > num) {
                j--;
            } else {
                i++;
            }
        }

        return result;
    }
}
