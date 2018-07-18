package com.jxs._54_firstAppearingOnce;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jiangxs on 2018/7/16.
 */
public class FirstAppearingOnce {

    private Queue<Character> queue = new LinkedList<>();
    char[] cnt = new char[256];

    //Insert one char from stringstream
    public void insert(char ch) {

        cnt[ch]++;
        queue.add(ch);
        while (queue != null && queue.size() != 0 && cnt[queue.peek()] > 1) {
            queue.poll();
        }
    }

    //return the first appearence once char in current stringstream
    public char getFirstAppearingOnce() {

        if (queue.peek() != null) {
            return queue.peek();
        }
        return '#';
    }

    @Test
    public void test() {

        String str = "google";
        char[] chars = str.toCharArray();
        for (char c : chars) {
            insert(c);
        }
        System.out.println(getFirstAppearingOnce());
    }
}
