package me.xiao.interview.ch02;

/**
 * 按照圈打印矩阵
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/12 15:04
 */

public class Section20_PrintMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5, 6, 7, 8},
                {22, 23, 24, 25, 26, 27, 28, 9},
                {21, 36, 37, 38, 39, 40, 29, 10},
                {20, 35, 34, 33, 32, 31, 30, 11},
                {19, 18, 17, 16, 15, 14, 13, 12},

        };

        new Section20_PrintMatrix().circlePrint(matrix);

    }

    private void circlePrint(int[][] matrix) {
        if (matrix == null) return;
        int x = 0, y = 0;
        while (x * 2 < matrix.length && y * 2 < matrix[0].length) {
            printOne(matrix, x, y);
            x++;
            y++;
        }
    }

    private void printOne(int[][] matrix, int x, int y) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = y; i <= col - y - 1; i++) {
            System.out.print(matrix[x][i] + " ");
        }

        if (row - x - 1 > x) {
            for (int i = x + 1; i <= row - x - 1; i++) {
                System.out.print(matrix[i][col - y - 1] + " ");

            }
        }

        if (row - x - 1 > x && col - 1 - y > y) {
            for (int i = col - y - 2; i >= y; i--) {
                System.out.print(matrix[row - 1 - x][i] + " ");
            }
        }

        if (row - x - 1 > x + 1 && col - 1 - y > y) {
            for (int i = row - x - 1 - 1; i >= x + 1; i--) {
                System.out.print(matrix[i][y] + " ");
            }
        }

    }
}
