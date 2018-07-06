package com.jxs.binaryFindPath;

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

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        return list;
    }

    public void backTracking(TreeNode root, int target, ArrayList<Integer> path) {

        if (root == null) {
            return;
        }
        path.add(root.val);
        target = target - root.val;
        if (target == 0 && root.left == null && root.right == null) {
            list.add(new ArrayList<>(path));
        } else {
            backTracking(root.left, target, path);
            backTracking(root.right, target, path);
        }
        path.remove(path.size() - 1);
    }
}
