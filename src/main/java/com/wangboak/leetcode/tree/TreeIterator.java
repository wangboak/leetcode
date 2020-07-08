package com.wangboak.leetcode.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description: 树的遍历
 * @author: wangbo4
 * @create: 2020-07-08 23:52
 **/
public class TreeIterator {

    public static TreeNode root;

    @Before
    public void init() {
        Integer[] arr = {7, 3, 11, 1, 5, 9, 13, 0, 2, 4, 6, 8, 10, 12, 14};
        root = toBinaryTree(arr);
    }

    public TreeNode toBinaryTree(Integer[] arrs) {
        if (arrs == null || arrs.length == 0) {
            return new TreeNode(0);
        }

        //数据数组 先换为 节点数组。方便后面通过角标来直接获取节点。
        List<TreeNode> nodeArray = new ArrayList<>(arrs.length);
        for (Integer obj : arrs) {
            nodeArray.add(new TreeNode(obj));
        }

        /**
         * 有几个特点：
         * 1、满二叉树上，最后一层的节点数 等于 前面所有节点数+1 。
         * 2、非叶子节点的每个节点的角标x，左叶子角标为2X+1，右叶子节点角标为2X+2。
         */
        for (int i = 0; i < (arrs.length / 2); i++) {
            TreeNode node = nodeArray.get(i);
            node.left = nodeArray.get(i * 2 + 1);
            node.right = nodeArray.get(i * 2 + 2);
        }
        return nodeArray.get(0);
    }


    /**
     *  遍历
     *
     */
    @Test
    public void test_order() {
        ArrayList<Integer> result = new ArrayList<>();
        pre(root);
        System.out.println();
        middle(root, result);
        System.out.println();
        after(root);
        System.out.println();
    }

    /**
     *  校验是否 BST 。
     *
     */
    @Test
    public void test_isBST() {
        System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(isBST_V2());
    }

    /**
     * 递归方式 前序遍历。
     * 7, 3, 1, 0, 2, 5, 4, 6, 11, 9, 8, 10, 13, 12, 14
     * @param node
     */
    public void pre(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + ", ");
        pre(node.left);
        pre(node.right);
    }

    /**
     * 递归方式 中序遍历。
     * 结果：0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14
     * @param node
     */
    public void middle(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        middle(node.left, result);
        result.add(node.data);
        middle(node.right, result);
    }

    /**
     * 递归方式 后序遍历。
     * 0, 2, 1, 4, 6, 5, 3, 8, 10, 9, 12, 14, 13, 11, 7
     * @param node
     */
    public void after(TreeNode node) {
        if (node == null) {
            return;
        }
        after(node.left);
        after(node.right);
        System.out.print(node.data + ", ");
    }

    /**
     * 验证是否 BST，二叉搜索树。
     * 不太理解~~~~
     * @param root
     * @return
     */
    boolean isBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min) {
            return false;
        }
        if (max != null && root.data >= max) {
            return false;
        }
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

    /**
     *  校验是否 BST 。
     * 思路：中序遍历，然后判断是否递增。
     */
    public boolean isBST_V2() {
        ArrayList<Integer> result = new ArrayList<>();
        middle(root, result);
        boolean isBST = true;
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i) < result.get(i - 1)) {
                isBST = false;
                break;
            }
        }
        return isBST;
    }

}
