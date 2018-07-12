package com.jxs.uglyNumber;

import org.junit.Test;

public class UglyNumber {

    public int getUglyNumber_Solution(int index) {

        if (index <= 6) {
            return index;
        }
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int[] arr = new int[index];
        arr[0] = 1;
        for (int i = 1; i<index; i++) {
            int next2 = arr[i2] * 2;
            int next3 = arr[i3] * 3;
            int next5 = arr[i5] * 5;
            arr[i] = Math.min(next2, Math.min(next3, next5));

            if (arr[i] == next2) {
                i2++;
            }
            if (arr[i] == next3) {
                i3++;
            }
            if (arr[i] == next5){
                i5++;
            }
        }
        return arr[index - 1];
    }

    public int getUglyNumber_Solution2(int index) {

        int n = index;
        while (true) {
            if (judgeUglyNumber(n)) {
                return n;
            }
            n = n + 1;
        }
    }

    private boolean judgeUglyNumber(int num) {

        if (num == 1) {
            return true;
        }

        while (num != 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else if (num % 3 == 0) {
                num = num / 3;
            } else if (num % 5 == 0) {
                num = num / 5;
            } else {
                return false;
            }
            if (num == 1) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {

        int index = 8;
        System.out.println(getUglyNumber_Solution(index));
        System.out.println(getUglyNumber_Solution2(index));
    }
}
