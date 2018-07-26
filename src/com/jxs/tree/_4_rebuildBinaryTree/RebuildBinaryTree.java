package com.jxs.tree._4_rebuildBinaryTree;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 重建二叉树思路：根据二叉树的前序遍历和中序遍历构建二叉树，
 * 首先根据前序遍历的第一个值可以获取到二叉树的头结点，
 * 然后在中序遍历中根据前序遍历头结点的值拿到这个节点在中序遍历中所处的位置，
 * 然后将这个节点可以将节点左边的划分为这个树的左子树，右边的部分划分为这棵树的右子树，
 * 这样再分别根据左右子树又可以分别拿到左右子树的根节点和左右子树的左右子树，一直递归下去，
 * 直到遍历得只能下一个节点，这样就可以完成二叉树的重建
 *
 * 关于重建二叉树要注意的是参数条件，
 * 一个是左树的大小=查找到根节点的位置-左树的起始位置（中序遍历的第一个节点）
 *
 * 另外一个就是递归的参数条件，根节点的左孩子可以看做是左子树的根节点，
 * 从前序遍历最左边的下一个开始（第一个为头结点），到最左边的+左子树的大小，
 * 中序遍历的左子树为第一个节点开始，到最左边的+左子树的第一个节点+左树的大小，右子树的计算与上类似

 * */
public class RebuildBinaryTree {

    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> inOrderNumsIndexs = new HashMap<>();

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        for (int i = 0; i < in.length; i++) {
            inOrderNumsIndexs.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preLeft, int preRight,
                                           int[] in, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preLeft]);
        int index = inOrderNumsIndexs.get(root.val);
        int leftTreeSize = index - inLeft;
        root.left = reConstructBinaryTree(pre, preLeft + 1, preLeft + leftTreeSize, in, inLeft, inLeft + leftTreeSize - 1);
        root.right = reConstructBinaryTree(pre, preLeft + leftTreeSize + 1, preRight, in, inLeft + leftTreeSize + 1, inRight);
        return root;
    }

    private void printTree(TreeNode root) {
        if(root != null) {
            printTree(root.left);
            System.out.println(root.val + " ");
            printTree(root.right);
        }
    }

    @Test
    public void test() {

        RebuildBinaryTree tree = new RebuildBinaryTree();
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode node = tree.reConstructBinaryTree(pre, in);
        tree.printTree(node);
    }
}
