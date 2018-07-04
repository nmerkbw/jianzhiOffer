package com.jxs.rectCover;

import org.junit.Test;

public class RectCover {

    public int rectCover(int target) {

        if (target <= 2) {
            return 1;
        }

        int sum = 0;
        int s1 = 1;
        int s2 = 1;
        for (int i = 3; i <= target; i++) {
            sum = s1 + s2;
            s1 = s2;
            s2 = sum;
        }
        return sum;
    }

    @Test
    public void test() {

        System.out.println(rectCover(8));
    }
}
