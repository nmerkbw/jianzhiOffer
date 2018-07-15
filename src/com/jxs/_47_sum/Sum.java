package com.jxs._47_sum;

import org.junit.Test;

public class Sum {

    public int sum_Solution(int n) {

        int sum = n;
        boolean b = (n > 0) && ((sum += sum_Solution(n-1))>0);
        return sum;
    }

    @Test
    public void test() {

        System.out.println(sum_Solution(100));
    }
}
