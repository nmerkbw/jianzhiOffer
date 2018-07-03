package com.jxs.minNumberInRotateArray;

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
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1 && array[i] <= array[i + 1]) {
                index = i + 1;
                continue;
            }
            break;
        }
        return array[index + 1];
    }

    @Test
    public void test() {

        int[] array = {1,0,1,1,1};
        int min = minNumberInRotateArray(array);
        System.out.println(min);
    }
}
