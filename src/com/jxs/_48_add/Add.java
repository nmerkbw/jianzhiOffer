package com.jxs._48_add;

import org.junit.Test;

public class Add {

    public int add(int num1,int num2) {

        int sum = 0;
        int carry = 0;

        do {
            // 先计算不进位相加
            sum = num1 ^ num2;
            // 再计算哪一位进位并左移进位
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        while (num2!=0);

        return sum;
    }

    @Test
    public void test() {

        int num1 = 37;
        int num2 = 28;
        System.out.println(add(num1, num2));
    }
}
