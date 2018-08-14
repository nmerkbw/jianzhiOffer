package com.jxs.number._31_numberOf1Between1AndN_newWayIsNNN;

import org.junit.Test;

/**
 * 若weight为0，则1出现次数为round*base
 * 若weight为1，则1出现次数为round*base+former+1
 * 若weight大于1，则1出现次数为round*base+base
 *
 * 比如：
 * 534 = （个位1出现次数）+（十位1出现次数）+（百位1出现次数）=（53*1+1）+（5*10+10）+（0*100+100）= 214
 * 530 = （53*1）+（5*10+10）+（0*100+100） = 213
 * 504 = （50*1+1）+（5*10）+（0*100+100） = 201
 * 514 = （51*1+1）+（5*10+4+1）+（0*100+100） = 207
 * 10 = (1*1)+(0*10+0+1) = 2
 * */
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
            num = num / 10;
        }
        return count;
    }

    @Test
    public void test() {

        int n = 121;
        System.out.println(numberOf1Between1AndN_Solution(n));
        System.out.println(numberOf1Between1AndN_Solution2(n));
    }
}
