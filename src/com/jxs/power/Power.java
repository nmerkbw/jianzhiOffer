package com.jxs.power;

import org.junit.Test;

public class Power {

    public double power(double base, int exponent) {

        if (exponent == 0) {
            return 1;
        }

        if (exponent == 1) {
            return base;
        }

        boolean isNegative = false;

        if (exponent < 0) {
            isNegative = true;
            exponent = -exponent;
        }

        double pow = power(base * base, exponent / 2);
        if (exponent % 2 != 0) {
            pow = pow * base;
        }
        return isNegative ? 1 / pow : pow;
    }

    @Test
    public void test() {

        System.out.println(power(2,-6));
        System.out.println(Math.pow(0,-6));
    }
}
