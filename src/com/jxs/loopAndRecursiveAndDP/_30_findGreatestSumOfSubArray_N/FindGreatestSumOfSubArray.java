package com.jxs.loopAndRecursiveAndDP._30_findGreatestSumOfSubArray_N;

import org.junit.Test;

/**
 * 动态规划的方法
 *
 * 从头开始遍历数组，每次进行叠加，如果发现累加值小于等于当前数组的值，就将当前值作累加值，
 * 否则就使用累加值，即max(dp[i] = getMax(max(dp[i-1])+arr[i],arr[i])
 * */
public class FindGreatestSumOfSubArray {

    public int findGreatestSumOfSubArray(int[] array) {

        int curSum = array[0];
        int maxSum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (curSum+array[i] <= array[i]) {
                curSum = array[i];
            } else {
                curSum += array[i];
            }
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }

    @Test
    public void test() {

        int[] array = {6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(findGreatestSumOfSubArray(array));
    }
}
