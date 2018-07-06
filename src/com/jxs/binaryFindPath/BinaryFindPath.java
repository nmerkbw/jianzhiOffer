package com.jxs.binaryFindPath;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by jiangxs on 2018/7/6.
 */
public class BinaryFindPath {

    private class TreeNode {

        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {

        ArrayList<Integer> path = new ArrayList<>();
        backTracking(root, target, path);
        return list;
    }

    private void backTracking(TreeNode root, int target, ArrayList<Integer> path) {

        if (root == null) {
            return;
        }
        path.add(root.val);
        target = target - root.val;
        // 路径上的值的和相等，且已经到达叶子
        if (target == 0 && root.left == null && root.right == null) {
            // 将路径添加到集合中
            list.add(new ArrayList<>(path));
        } else {
            backTracking(root.left, target, path);
            backTracking(root.right, target, path);
        }
        // 到达此处说明已经走到节点的终点，将路径中上一次的节点删除，回溯到之前的结点上
        path.remove(path.size() - 1);
    }

    @Test
    public void test() {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);

        System.out.println(findPath(root,22));
    }
}
