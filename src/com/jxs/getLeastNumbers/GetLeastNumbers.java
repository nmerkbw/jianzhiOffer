package com.jxs.getLeastNumbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GetLeastNumbers {

    /**
     * 方法1：使用切分的方式实现
     *
     * 复杂度：O(N) + O(1)
     * 场景：只有当允许修改数组元素时才可以使用
     *
     *
     * 快速排序的 partition() 方法，会返回一个整数 j 使得 a[l..j-1] 小于等于 a[j]，
     * 且 a[j+1..h] 大于等于 a[j]，此时 a[j] 就是数组的第 j 大元素。
     * 可以利用这个特性找出数组的第 K 个元素，这种找第 K 个元素的算法称为快速选择算法
     * */
    public ArrayList<Integer> GetLeastNumbers_SolutionPartition(int [] input, int k) {

        ArrayList ret = new ArrayList();
        if (k > input.length || k < 0) {
            return ret;
        }
        findKthSmallest(input, k);
        for (int num = 0; num < k; num++) {
            ret.add(input[num]);
        }
        return ret;
    }

    private void findKthSmallest(int[] nums, int k) {

        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int j = partition(nums, low, high);
            if (j == k) {
                break;
            }
            if (j > k) {
                high = j - 1;
            }
            if (j < k) {
                low = j + 1;
            }
        }
    }

    private int partition(int[] nums, int low, int high) {

        int val = nums[low];
        int i = low;
        int j = high + 1;
        while (low < high) {
            while (nums[++i] <= val && i < high);
            while (nums[--j] >= val && j > low) ;
            if (i < j) {
                swap(nums, i, j);
            } else {
                break;
            }
        }
        swap(nums, low, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * 使用大顶堆的方式实现
     *
     * 复杂度：O(NlogK) + O(K)
     * 场景：特别适合处理海量数据
     *
     * 应该使用大顶堆来维护最小堆，而不能直接创建一个小顶堆并设置一个大小，
     * 企图让小顶堆中的元素都是最小元素。
     *
     * 维护一个大小为 K 的最小堆过程如下：在添加一个元素之后，如果大顶堆的大小大于 K，
     * 那么需要将大顶堆的堆顶元素去除。
     * */
    public ArrayList<Integer> GetLeastNumbers_SolutionHeap(int [] input, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int num : input) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }

    @Test
    public void test() {

        int[] input1 = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] input2 = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;

        System.out.println(GetLeastNumbers_SolutionPartition(input1, 8));
        System.out.println(GetLeastNumbers_SolutionHeap(input2, 4));
    }
}
