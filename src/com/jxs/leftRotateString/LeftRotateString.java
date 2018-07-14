package com.jxs.leftRotateString;

import org.junit.Test;

public class LeftRotateString {

    public String leftRotateString(String str,int n) {

        if (str.length() < n) {
            return "";
        }
        StringBuilder s = new StringBuilder(str);
        s.delete(0, n);
        for (int i = 0; i < n; i++) {
            s.append(str.charAt(i));
        }
        return s.toString();
    }

    @Test
    public void test() {

        String str = "abcXYZdef";
        int n = 3;
        System.out.println(leftRotateString(str, n));
    }
}
