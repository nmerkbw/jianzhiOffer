package com.jxs._53_isNumeric;

import org.junit.Test;

/**
 * Created by jiangxs on 2018/7/16.
 */
public class IsNumeric {

    public boolean isNumeric(char[] str) {

        if (str == null) {
            return false;
        }

        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

    @Test
    public void test() {

        char[] str = {'-','1','E','-','1','6'};
        char[] str2 = {'1', '0', '0'};
        System.out.println(isNumeric(str2));
    }
}
