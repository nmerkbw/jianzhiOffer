package com.jxs.inversePairs;

import org.junit.Test;

public class InversePairs {

    private long cnt = 0;
    private int[] temp;
    public int inversePairs(int [] array) {

        temp = new int[array.length];
        mergeSort(array, 0, array.length - 1);
        return (int) (cnt % 1000000007);
    }

    private void mergeSort(int[] array, int low, int high) {

        if (high - low < 1) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        // 在找完左右半段逆序对以后两段数组有序，然后找两段之间的逆序对。最小的逆序段只有一个元素
        merge(array, low, mid, high);
    }

    private void merge(int[] array, int low, int mid, int high) {

        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid || j <= high) {
            if (i > mid) {
                temp[k] = array[j++];
            } else if (j > high) {
                temp[k] = array[i++];
            } else if (array[i] < array[j]) {
                temp[k] = array[i++];
            } else {
                // array[i]>array[j]，说明array[i...mid]都大于array[j]
                temp[k] = array[j++];
                cnt += mid - i + 1;
            }
            k++;
        }
        // 让已经处理过的部分有序，防止重复处理
        for (k = low; k <= high; k++) {
            array[k] = temp[k];
        }
    }

    @Test
    public void test() {

        int[] nums = {7, 5, 6, 4};
        System.out.println(inversePairs(nums));
    }
}
