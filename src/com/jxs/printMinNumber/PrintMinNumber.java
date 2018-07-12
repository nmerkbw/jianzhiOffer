package com.jxs.printMinNumber;

import org.junit.Test;

import java.util.Arrays;

public class PrintMinNumber {

    public String printMinNumber(int [] numbers) {

        int length = numbers.length;
        String[] nums = new String[length];
        for (int i = 0; i < length; i++) {
            nums[i] = numbers[i] + "";
        }
        Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder s = new StringBuilder();
        for (String num : nums) {
            s.append(num);
        }
        return s.toString();
    }

    @Test
    public void test() {

        int[] numbers = {3, 32, 321};
        System.out.println(printMinNumber(numbers));
    }
}
