package com.jxs._49_strToInt;

import org.junit.Test;

public class StrToInt {

    public int strToInt(String str) {

        if (str == "") {
            return 0;
        }

        char[] strArray = str.toCharArray();
        int bit = strArray.length - 1;
        long num = 0;
        boolean isNegtive = false;
        for (int i = 0; i < strArray.length; i++) {
            if (i == 0 && strArray[i] == '+') {
                isNegtive = false;
                continue;
            } else if (i == 0 && strArray[i] == '-') {
                isNegtive = true;
                continue;
            } else if (strArray[i] >= '0' && strArray[i] <= '9') {
                int bitNum = strArray[i] - '0';
                num += bitNum * Math.pow(10, bit - i);
                continue;
            }
            return 0;
        }
        if (isNegtive == true) {
            return (int) (0 - num);
        }
        return (int) num;
    }

    @Test
    public void test() {

        String str = "-2147483648";
        System.out.println(strToInt(str));
    }
}
