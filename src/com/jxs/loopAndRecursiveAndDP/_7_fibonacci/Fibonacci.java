package com.jxs.loopAndRecursiveAndDP._7_fibonacci;

import org.junit.Test;

public class Fibonacci {

    public int fibonacci(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }

        int sum = 0;
        int s1 = 1;
        int s2 = 1;
        for (int i = 3; i <= n; i++) {
            sum = s1 + s2;
            s1 = s2;
            s2 = sum;
        }
        return sum;
    }

    @Test
    public void test() {

        System.out.println(fibonacci(9));
    }
}
