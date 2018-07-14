package com.jxs.isContinuous;

import org.junit.Test;

import java.util.Arrays;

public class IsContinuous {

    public boolean isContinuous(int [] numbers) {

        int length = numbers.length;
        if (length < 5) {
            return false;
        }
        Arrays.sort(numbers);
        // 计算牌中大小王的数量
        int cnt = 0;
        for (int i = 0; i < length; i++) {
            if (numbers[i] == 0) {
                cnt++;
                continue;
            }
            break;
        }
        for (int i = cnt; i < length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
            cnt = cnt - (numbers[i + 1] - numbers[i] - 1);
        }
        return cnt >= 0;
    }

    @Test
    public void test() {

        int[] nums = {1, 3, 2, 5, 4};
        System.out.println(isContinuous(nums));
    }
}
