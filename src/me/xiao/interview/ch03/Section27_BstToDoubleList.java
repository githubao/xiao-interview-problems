package me.xiao.interview.ch03;

import me.xiao.interview.TreeNode;

/**
 * 二叉搜索树 转化成 双向排序链表
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/12 19:04
 */

public class Section27_BstToDoubleList {
    public static void main(String[] args) {
        TreeNode root = TreeNode.bstBuild();
        TreeNode doubleList = new Section27_BstToDoubleList().convert(root);
        doubleList.circlePrint();
    }

    private TreeNode convert(TreeNode root) {
        TreeNode[] lastNode = new TreeNode[1];
        convertNode(root, lastNode);

        TreeNode head = lastNode[0];
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    private void convertNode(TreeNode root, TreeNode[] lastNode) {
        if (root != null) {
            if (root.left != null) {
                convertNode(root.left, lastNode);
            }

            // 当前节点的前驱是左子树
            root.left = lastNode[0];

            // 如果有左子树的话，左子树的右驱 是当前节点
            if (lastNode[0] != null) {
                lastNode[0].right = root;
            }

            // 现在链表最后一个节点变成了当前节点
            lastNode[0] = root;

            // 遍历右边的
            if (root.right != null) {
                convertNode(root.right, lastNode);
            }
        }
    }
}
