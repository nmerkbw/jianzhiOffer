package com.jxs._59_printBinaryTreeZ;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jiangxs on 2018/7/18.
 */
public class PrintBinaryTreeZ {

    public class TreeNode {

        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (reverse == true) {
                Collections.reverse(list);
            }
            reverse = !reverse;
            if (list.size() != 0) {
                ret.add(list);
            }
        }
        return ret;
    }

    @Test
    public void test() {

        TreeNode pRoot = new TreeNode(5);
        pRoot.left = new TreeNode(4);
        pRoot.right = new TreeNode(6);
        pRoot.left.left = new TreeNode(1);
        pRoot.left.right = new TreeNode(3);

        System.out.println(print(pRoot));
    }
}
