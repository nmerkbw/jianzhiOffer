package com.jxs.array._2_minNumberInRotateArray;

import org.junit.Test;

import java.util.ArrayList;

public class MinNumberInRotateArray {

    public int minNumberInRotateArray(int [] array) {

        ArrayList<Integer> list = new ArrayList<>();
        if (array.length == 0) {
            return 0;
        }

        if (array.length == 1) {
            return array[0];
        }

        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= array[i - 1]) {
                continue;
            }
            index = i;
            break;
        }
        return array[index];
    }

    @Test
    public void test() {

        int[] array = {1,0,1,1,1};
        int min = minNumberInRotateArray(array);
        System.out.println(min);
    }
}
