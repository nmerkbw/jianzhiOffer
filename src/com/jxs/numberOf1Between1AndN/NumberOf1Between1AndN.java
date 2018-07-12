package com.jxs.numberOf1Between1AndN;

import org.junit.Test;

public class NumberOf1Between1AndN {

    public int numberOf1Between1AndN_Solution(int n) {

        int count = 0;
        int base = 1;
        int round = n;
        while (round > 0) {
            int weight = round % 10;
            round = round / 10;
            count += round * base;
            if (weight == 1) {
                count += (n % base) + 1;
            }
            if (weight > 1) {
                count += base;
            }
            base = base * 10;
        }
        return count;
    }

    public int numberOf1Between1AndN_Solution2(int n) {

        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += getNumberOf1Count(i);
        }
        return count;
    }

    private int getNumberOf1Count(int num) {

        int count = 0;
        if (num == 1) {
            return 1;
        }
        while (num >= 10) {
            if (num % 10 == 1) {
                count++;
            }
            if (num / 10 == 1) {
                count++;
            }
            num = num / 10;
        }
        return count;
    }

    @Test
    public void test() {

        int n = 13;
        System.out.println(numberOf1Between1AndN_Solution(n));
        System.out.println(numberOf1Between1AndN_Solution2(n));
    }
}
