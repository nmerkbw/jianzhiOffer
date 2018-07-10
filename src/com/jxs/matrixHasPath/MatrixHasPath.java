package com.jxs.matrixHasPath;

import org.junit.Test;

import java.util.Arrays;

/**
 * 回溯法：
 * 因为回朔法的递归特性，路径能够被开成一个栈。当在矩阵中定位了路径中前n个字符的位置之后。
 * 在与第n个字符相应的格子的周围都没有找到第n+1个字符。这个时候仅仅要在路径上回到第n-1个字符。
 * 又一次定位第n个字符。
 *
 * 因为路径不能反复进入矩阵的格子。还须要定义和字符矩阵大小一样的布尔值矩阵，
 * 用来标识路径是否已经进入每个格子。
 *
 * 当矩阵中坐标为（row,col）的格子和路径字符串中下标为pathLength的字符一样时。
 * 从4个相邻的格子(row,col-1),(row-1,col),(row,col+1)以及(row+1,col)中去定位路径字符串中
 * 下标为pathLength+1的字符。
 *
 * 假设4个相邻的格子都没有匹配字符串中下标为pathLength+1的字符，
 * 表明当前路径字符串中下标为pathLength的字符在矩阵中的定位不对，我们须要回到前一个字符(pathLength-1)，然后又一次定位。
 * 一直反复这个过程，直到路径字符串上全部字符都在矩阵中找到合适的位置
 * */
public class MatrixHasPath {

    /**
     * @param matrix 输入矩阵
     * @param rows   矩阵行数
     * @param cols   矩阵列数
     * @param str    要搜索的字符串
     * @return 是否找到 true是。false否
     * */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        if (matrix == null || matrix.length != rows * cols || str == null || str.length < 1) {
            return false;
        }

        boolean hasPath = false;
        boolean[] hasVisited = new boolean[rows * cols];
        Arrays.fill(hasVisited, false);
        int pathLength = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                hasPath = backTracking(matrix, rows, cols, hasVisited, r, c, pathLength, str);
                if (hasPath) {
                    return true;
                }
            }
        }
        return hasPath;
    }

    /**
     * 回溯搜索算法
     *
     * @param matrix     输入矩阵
     * @param rows       矩阵行数
     * @param cols       矩阵列数
     * @param str        要搜索的字符串
     * @param hasVisited 访问标记数组
     * @param row        当前处理的行号
     * @param col        当前处理的列号
     * @param pathLength 已经处理的str中字符个数
     * @return 是否找到 true是，false否
     * */
    private boolean backTracking(char[] matrix, int rows, int cols,
                                 boolean[] hasVisited, int row, int col,
                                 int pathLength, char[] str) {

        if (pathLength == str.length) {
            return true;
        }

        boolean hasPath = false;
        if (row >= 0 && row < rows
                && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLength]
                && !hasVisited[row * cols + col]) {
            hasVisited[row * cols + col] = true;
            pathLength++;

            hasPath = backTracking(matrix, rows, cols, hasVisited, row, col - 1, pathLength, str)
                    || backTracking(matrix, rows, cols, hasVisited, row - 1, col, pathLength, str)
                    || backTracking(matrix, rows, cols, hasVisited, row, col + 1, pathLength, str)
                    || backTracking(matrix, rows, cols, hasVisited, row + 1, col, pathLength, str);

            if (!hasPath) {
                pathLength--;
                hasVisited[row * cols + col] = false;
            }
        }
        return hasPath;
    }

    @Test
    public void test() {

        System.out.println(hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(),
                5,8,"SGGFIECVAASABCEHJIGQEM".toCharArray()) + "[true]");
    }
}
