package com.jxs.firstNotRepeatingChar;

import org.junit.Test;

public class FirstNotRepeatingChar {

    public int firstNotRepeatingChar(String str) {

        char[] cnt = new char[1 << 8];
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (cnt[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {

        String str = "abcdbacfasfqe";
        System.out.println(firstNotRepeatingChar(str));
    }
}
