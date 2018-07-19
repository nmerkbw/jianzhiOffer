package com.jxs._61_serializeBinaryTree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {

    private class TreeNode {

        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public String serialize(TreeNode root) {

        if (root == null) {
            return "#,";
        }
        StringBuilder sb = new StringBuilder(root.val + ",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    public TreeNode deserialize(String str) {

        String[] strs = str.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String s : strs) {
            queue.add(s);
        }
        return preOrder(queue);
    }

    private TreeNode preOrder(Queue<String> queue) {

        String val = queue.poll();
        if (val.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = preOrder(queue);
        node.right = preOrder(queue);
        return node;
    }

    @Test
    public void test() {

        TreeNode pRoot = new TreeNode(6);
        pRoot.left = new TreeNode(2);
        pRoot.left.left = new TreeNode(1);
        pRoot.left.right = new TreeNode(3);
        pRoot.right = new TreeNode(8);

        String serialize = serialize(pRoot);
        System.out.println(serialize);
        TreeNode node = deserialize(serialize);
    }
}
