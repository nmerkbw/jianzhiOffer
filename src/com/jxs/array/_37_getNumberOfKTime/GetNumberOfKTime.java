package com.jxs.array._37_getNumberOfKTime;

import org.junit.Test;

import java.util.Arrays;

public class GetNumberOfKTime {

    public int getNumberOfK(int [] array , int k) {

        int cnt = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                cnt++;
            } else if (array[i] > k) {
                break;
            }
        }
        return cnt;
    }

    public int GetNumberOfK(int [] array , int k) {

        int first = binarySearchFirst(array, k);
        int last = binarySearchLast(array, k);
        int cnt = 0;
        if (first < 0 || last < 0) {
            return cnt;
        } else {
            cnt = last - first + 1;
        }
        return cnt;
    }

    // 二分查找查找多个重复数字的第一个在数组中的位置
    public int binarySearchFirst(int[] array, int k) {

        int search = Arrays.binarySearch(array, k);
        if (search < 0) {
            return search;
        }
        int index = search;
        while (index >= 0) {
            if (array[index] == k) {
                index--;
                continue;
            } else if (array[index] != k) {
                break;
            }
        }
        return index + 1;
    }

    // 二分查找查找多个重复数字的最后一个在数组中的位置
    public int binarySearchLast(int[] array, int k) {

        int search = Arrays.binarySearch(array, k);
        if (search < 0) {
            return search;
        }
        int index = search;
        while (index < array.length) {
            if (array[index] == k) {
                index++;
                continue;
            } else if (array[index] != k) {
                break;
            }
        }
        return index - 1;
    }

    @Test
    public void test() {

        int[] array = {3, 3, 3, 3, 4, 5, 7};
        int k = 3;
        System.out.println(getNumberOfK(array, k));
        System.out.println(GetNumberOfK(array, k));
        System.out.println(binarySearchFirst(array,6));
        System.out.println(binarySearchLast(array, 6));
    }
}
