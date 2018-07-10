package com.jxs.movingCount;

import org.junit.Test;

import java.util.Arrays;

public class MovingCount {

    public int movingCount(int threshold, int rows, int cols) {

        boolean[] hasVisited = new boolean[rows * cols];
        Arrays.fill(hasVisited, false);
        int count = backTracking(threshold, hasVisited, rows, cols, 0, 0);
        return count;
    }

    private int backTracking(int threshold, boolean[] hasVisited, int rows, int cols, int row, int col) {

        int cnt = 0;
        if (check(threshold,rows,cols,row,col,hasVisited)) {
            hasVisited[row * cols + col] = true;
            // 1代表出发点
            cnt = 1 + backTracking(threshold, hasVisited, rows, cols, row, col - 1)
                    + backTracking(threshold, hasVisited, rows, cols, row - 1, col)
                    + backTracking(threshold, hasVisited, rows, cols, row, col + 1)
                    + backTracking(threshold, hasVisited, rows, cols, row + 1, col);
        }
        return cnt;
    }

    private boolean check(int threshold, int rows, int cols,
                          int row, int col, boolean[] hasVisited) {
        if (row >= 0 && row < rows
                && col >= 0 && col < cols
                && getNumBitSum(row, col) <= threshold
                && !hasVisited[row * cols + col]) {
            return true;
        }
        return false;
    }

    /**
     * 数字的位数之和
     */
    private int getNumBitSum(int num1, int num2) {

        int sum1 = 0;
        int sum2 = 0;
        while (num1 != 0) {
            sum1 += num1 % 10;
            num1 = num1 / 10;
        }
        while (num2 != 0) {
            sum2 += num2 % 10;
            num2 = num2 / 10;
        }
        int sum = sum1 + sum2;
        return sum;
    }

    @Test
    public void test() {

        System.out.println(movingCount(2,3,3));
    }
}
