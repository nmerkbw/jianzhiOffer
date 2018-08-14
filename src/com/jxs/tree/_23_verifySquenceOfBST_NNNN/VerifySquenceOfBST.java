package com.jxs.tree._23_verifySquenceOfBST_NNNN;

import org.junit.Test;

/**
 * Created by jiangxs on 2018/7/6.
 */
public class VerifySquenceOfBST {

    public boolean verifySquenceOfBST(int [] sequence) {

        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int first, int last) {

        // 一个或两个节点构成的树必然是二叉搜索树的遍历结果
        if (last - first <= 1) {
            return true;
        }
        int cur = first;
        int rootVal = sequence[last];
        while (cur < last && sequence[cur] <= rootVal) {
            cur++;
        }
        for (int i = cur; i < last; i++) {
            if (sequence[i] < rootVal) {
                return false;
            }
        }
        return verify(sequence, first, cur - 1) || verify(sequence, cur, last - 1);
    }

    @Test
    public void test() {

        int[] sequence = {4, 7, 5, 10, 15, 19, 8};
        System.out.println(verifySquenceOfBST(sequence));
    }
}
