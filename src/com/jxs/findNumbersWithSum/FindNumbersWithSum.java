package com.jxs.findNumbersWithSum;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by jiangxs on 2018/7/13.
 */
public class FindNumbersWithSum {

    private ArrayList<Integer> ret = new ArrayList<>();

    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {

        int small = 0;
        int big = array.length - 1;
        while (small < big) {
            if ((array[small] + array[big]) < sum) {
                small++;
            } else if ((array[small] + array[big]) > sum) {
                big--;
            } else if ((array[small] + array[big]) == sum) {
                ret.add(array[small]);
                ret.add(array[big]);
                break;
            }
        }
        return ret;
    }

    @Test
    public void test() {

        int[] array = {2, 3, 5, 6, 7, 8};
        System.out.println(findNumbersWithSum(array, 9));
    }
}
