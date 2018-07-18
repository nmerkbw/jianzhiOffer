package com.jxs._60_printBinaryTreeByLine;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintBinaryTreeByLine {

    private class TreeNode {

        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
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
            if (list.size() != 0) {
                ret.add(list);
            }
        }
        return ret;
    }

    @Test
    public void test() {

        TreeNode pRoot = new TreeNode(6);
        pRoot.left = new TreeNode(2);
        pRoot.left.left = new TreeNode(1);
        pRoot.left.right = new TreeNode(3);
        pRoot.right = new TreeNode(8);
        System.out.println(Print(pRoot));
    }
}
