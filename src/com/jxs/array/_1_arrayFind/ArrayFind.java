package com.jxs.array._1_arrayFind;

import org.junit.Test;

/**
 * Created by jiangxs on 2018/7/2.
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
