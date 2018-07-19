package com.jxs._63_dataStreamMedium;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * 分成两个堆，一个构造成大顶堆，一个构造成小顶堆，此时两个堆的元素可能相等可能相差1
 * 此时若相等，则中位数就是堆顶元素值的平均，不相等时就为其中一个堆的堆顶元素
 *
 * 中位数要保持两个堆的数目之差不超过1.为了实现平均分配，
 * 可以在数据的总数目是偶数时把新数据插入到大顶堆中，然后将此时的最大值插入到小顶堆中
 * 在数据的总数目是奇数时把新数据插入到小顶堆中，然后将此时的最小值插入到大顶堆中
 * 这样就可以保证两个堆中的元素数量基本相等（最大相差1）
 * */
public class DataStreamMedium {

    // 大顶堆放左边，PriorityQueue默认创建小顶堆
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    // 小顶堆放右边
    private PriorityQueue<Integer> right = new PriorityQueue<>();

    private int N;

    public void insert(Integer num) {

        if (N % 2 == 0) {
            left.add(num);
            right.add(left.poll());
        } else {
            right.add(num);
            left.add(right.poll());
        }
        N++;
    }

    public Double getMedian() {

        double medium = 0;

        if (N % 2 == 0) {
            medium = (left.peek() + right.peek()) / 2.0;
        } else {
            medium = right.peek();
        }
        return medium;
    }

    @Test
    public void test() {

        insert(1);
        insert(2);
        insert(3);
        //insert(4);

        System.out.println(getMedian());
    }
}
