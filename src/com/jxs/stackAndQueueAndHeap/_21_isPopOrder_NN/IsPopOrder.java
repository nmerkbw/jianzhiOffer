package com.jxs.stackAndQueueAndHeap._21_isPopOrder_NN;

import org.junit.Test;

import java.util.Stack;

/**
 * 将原序列往栈中压入，如果压入后栈顶元素与弹出序列相同，就将栈顶元素弹出，index自增并记录
 * 否则就继续压入直到原序列遍历完即可，遍历完后判断index有没有达到序列长度，如果没有肯定存在
 * 问题，此时返回false，其他时候返回true
 * */
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
