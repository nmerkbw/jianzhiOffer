package com.jxs.moreThanHalfNum;

import org.junit.Test;

public class MoreThanHalfNum {

    public int moreThanHalfNum_Solution(int [] array) {

        int num = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == num) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                num = array[i];
                count = 1;
            }
        }

        // 检查
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                count++;
            }
        }
        if (count * 2 > array.length) {
            return num;
        }
        return 0;
    }

    @Test
    public void test() {

        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(moreThanHalfNum_Solution(array));
    }
}
