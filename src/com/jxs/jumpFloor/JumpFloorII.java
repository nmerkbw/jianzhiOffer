package com.jxs.jumpFloor;

import org.junit.Test;

public class JumpFloorII {

    public int jumpFloorII(int target) {

        if (target <= 2) {
            return target;
        }

        int sum = 0;
        int s1 = 1;
        int s2 = 2;
        // 第n阶台阶：2*(n1+n2)-n1
        for (int i = 3; i <= target; i++) {
            sum = 2 * s1 + s2;
            s1 = s2;
            s2 = sum;
        }
        return sum;
    }

    @Test
    public void test() {

        System.out.println(jumpFloorII(20));
    }
}
