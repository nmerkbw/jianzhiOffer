package com.jxs.jumpFloor;

import org.junit.Test;

public class JumpFloor {

    public int JumpFloor(int target) {

        if (target <= 2) {
            return target;
        }

        int sum = 0;
        int s1 = 1;
        int s2 = 2;
        for (int i = 3; i <= target; i++) {
            sum = s1 + s2;
            s1 = s2;
            s2 = sum;
        }
        return sum;
    }

    @Test
    public void test() {

        System.out.println(JumpFloor(2));
    }
}
