package com.jxs._46_lastRemaining;

import org.junit.Test;

/**
 * 约瑟夫环的问题
 * */
public class LastRemaining {

    public int lastRemaining_Solution(int n, int m) {

        if (n < 1 && m < 1) {
            return -1;
        }
        int last = 0;
        // f(1) = 0  // 一个人的时候删除的编号为0，即自己
        // f(2) = (f(1)+m)%2 //2为当前两个人
        // f(3) = (f(2)+m)%n
        // ...
        // f(n) = (f(n-1)+m)%n
        // 上诉过程从上至下可以使用循环，从下至上可以使用递归
        for (int i = 2; i <= n; i++) {
            last = (last+m) % i;
        }
        return last;
    }

    @Test
    public void test() {

        int n = 10;
        int m = 3;
        System.out.println(lastRemaining_Solution(n, m));
    }
}
