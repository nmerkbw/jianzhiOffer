package com.jxs.isPopOrder;

import org.junit.Test;

import java.util.Stack;

public class IsPopOrder {

    public boolean isPopOrder(int[] pushA, int[] popA) {

        int pushLength = pushA.length;
        int popLength = popA.length;
        int index = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < pushLength; i++) {
            stack.push(pushA[i]);
            while (index < popLength && stack.peek() == popA[index]) {
                stack.pop();
                index++;
            }
        }
        if (index != popLength) {
            return false;
        }
        return true;
    }

    @Test
    public void test() {

        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};
        System.out.println(isPopOrder(pushA, popA));
    }
}
