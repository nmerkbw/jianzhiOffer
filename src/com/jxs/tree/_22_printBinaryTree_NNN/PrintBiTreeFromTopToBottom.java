package com.jxs.tree._22_printBinaryTree_NNN;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintBiTreeFromTopToBottom {

    private class TreeNode {

        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                TreeNode t = queue.poll();
                if (t == null) {
                    continue;
                }
                list.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
        }
        return list;
    }

    @Test
    public void test() {

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);

        System.out.println(PrintFromTopToBottom(root));
    }
}
