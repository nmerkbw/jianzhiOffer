package com.jxs.stackAndQueue._20_stackMin;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by jiangxs on 2018/7/5.
 */
public class StackMin {

    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {

        dataStack.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        }
        int min = minStack.peek();
        if (min < node) {
            minStack.push(min);
        } else {
            minStack.push(node);
        }
    }

    public void pop() {

        dataStack.pop();
        minStack.pop();
    }

    public int top() {

        return dataStack.peek();
    }

    public int min() {

        return minStack.peek();
    }

    @Test
    public void test() {

        push(3);
        push(2);
        push(5);
        push(8);
        push(4);

        System.out.println(min());
    }
}
