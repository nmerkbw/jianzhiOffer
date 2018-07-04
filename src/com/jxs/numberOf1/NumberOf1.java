package com.jxs.numberOf1;

import org.junit.Test;

public class NumberOf1 {

    public int NumberOf1(int n) {

        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    @Test
    public void test() {

        System.out.println(NumberOf1(-9));
    }
}
