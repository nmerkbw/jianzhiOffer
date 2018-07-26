package com.jxs.array._1_arrayFind;

import org.junit.Test;

/**
 * Created by jiangxs on 2018/7/2.
 *
 * 题目：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 *
 * 思路：从矩阵的右上角(0,col-1)开始进行查找，这样在这个位置左边的数都比这个数要小，
 * 在这个位置下面的都比这个数要大，当查找一个数时，如果比这个值大，就向下查找，如果比这个
 * 数小，就向左查找，如果相等就返回true
 */

public class ArrayFind {

    public boolean find(int[][] array, int target) {

        if (array == null || array.length == 0 || array[0].length == 0 || array[0] == null || target < 0) {
            return false;
        }
        int row = array.length;
        int col = array[0].length;
        for(int i = 0; i < row; i++) {
            for(int j = col - 1; j >= 0; j--) {
                if (array[i][j] == target) {
                    return true;
                } else if(array[i][j] < target) {
                    break;
                } else if(array[i][j] > target) {
                    continue;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {

        int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int target = 10;
        System.out.println(find(array, target));
    }
}
