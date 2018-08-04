package com.jxs.array._19_printMatrix_NNN;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by jiangxs on 2018/7/5.
 */
public class PrintMatrix {

    public ArrayList<Integer> printMatrix(int [][] matrix) {

        int rowStart = 0;
        int colStart = 0;
        int rowBound = matrix.length - 1;
        int colBound = matrix[0].length - 1;
        ArrayList<Integer> list = new ArrayList<>();

        while (rowStart <= rowBound && colStart <= colBound) {

            // 打印从左向右方向的
            for (int c = colStart; c <= colBound; c++) {
                list.add(matrix[rowStart][c]);
            }

            // 打印从上向下方向的
            for (int r = rowStart + 1; r <= rowBound; r++) {
                list.add(matrix[r][colBound]);
            }

            // 打印从右向左的，注意因为从右向左是递减的，所以要先判断列开始处有没有和列的边界处重合
            if (rowStart != rowBound) {
                for (int c = colBound - 1; c >= colStart; c--) {
                    list.add(matrix[rowBound][c]);
                }
            }

            // 打印从下向上的，注意因为从下向上是递减的，所以要先判断行开始处有没有和行的边界处重合
            if (colStart != colBound) {
                for (int r = rowBound - 1; r > rowStart; r--) {
                    list.add(matrix[r][colStart]);
                }
            }
            rowStart++;
            colStart++;
            rowBound--;
            colBound--;
        }
        return list;
    }

    @Test
    public void test() {

        int num = 1;
        int[][] matrix = new int[4][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = num++;
            }
        }
        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list);
    }
}
