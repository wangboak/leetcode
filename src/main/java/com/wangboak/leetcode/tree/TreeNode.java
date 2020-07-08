package com.wangboak.leetcode.tree;

/**
 * @program: leetcode->BinaryTree
 * @description: 二叉树
 * @author: wangbo4
 * @create: 2020-07-08 23:50
 **/
public class TreeNode {

    /**
     * 数据
     */
    public Integer data;

    /**
     * 左叶子节点
     */
    public TreeNode left;

    /**
     * 右叶子节点
     */
    public TreeNode right;

    public TreeNode(Integer data) {
        this.data = data;
    }

    public TreeNode(Integer data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

}
