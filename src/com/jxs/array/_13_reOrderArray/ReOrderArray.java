package com.jxs.array._13_reOrderArray;

import org.junit.Test;

public class ReOrderArray {

    public void reOrderArray(int [] array) {

        int oddNumCount = 0;
        for (int num : array) {
            if (num % 2 != 0) {
                oddNumCount++;
            }
        }
        int i = 0;
        int j = oddNumCount;
        int[] copyArray = array.clone();
        for (int num : copyArray) {
            if (num % 2 != 0) {
                array[i++] = num;
            } else {
                array[j++] = num;
            }
        }
    }

    @Test
    public void test() {

        int[] array = {1, 2, 3, 4, 5, 6, 7};
        reOrderArray(array);
        for (int num : array) {
            System.out.print(num+" ");
        }
    }
}
