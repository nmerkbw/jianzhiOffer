package com.jxs._64_maxInWindows;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class MaxInWindows {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {

        ArrayList<Integer> ret = new ArrayList<>();
        if (num == null || num.length == 0 || size == 0 || size > num.length) {
            return ret;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            if (!queue.isEmpty()) {
                // 当队列头元素不在窗口中时,就删除头元素
                if (i >= queue.peek() + size) {
                    queue.pop();
                }
                // 当当前数字大于队列尾，则删除队列尾，直到当前数字小于队列尾或队列被删空时
                // 就将当前元素插入
                while (!queue.isEmpty() && num[i] >= num[queue.getLast()]) {
                    queue.removeLast();
                }
            }
            // 入队列
            queue.offer(i);
            // 当i>=2时滑动窗口才能取到最大值，此时滑动窗口的最大值即为队列头元素
            if (i + 1 >= size) {
                ret.add(num[queue.peek()]);
            }
        }
        return ret;
    }

    @Test
    public void test() {

        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(maxInWindows(nums, 3));
    }
}
