package com.jxs.findContinuousSequence;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by jiangxs on 2018/7/13.
 */
public class FindContinuousSequence {

    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {

        int small = 1;
        int big = 2;
        int curSum = 3;
        while (big < sum) {
            if (curSum < sum) {
                big++;
                curSum = curSum + big;
            } else if (curSum > sum) {
                curSum = curSum - small;
                small++;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                ret.add(list);
                curSum = curSum - small;
                small++;
                big++;
                curSum = curSum + big;
            }
        }
        return ret;
    }

    @Test
    public void test() {

        System.out.println(findContinuousSequence(4));
    }
}
