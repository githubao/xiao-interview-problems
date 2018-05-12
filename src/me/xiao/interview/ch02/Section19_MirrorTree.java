package me.xiao.interview.ch02;

import me.xiao.interview.TreeNode;

/**
 * 输出一个二叉树的镜像
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/12 14:57
 */

public class Section19_MirrorTree {
    public static void main(String[] args) {
        TreeNode root = TreeNode.defaultBuild();
        TreeNode mirror = new Section19_MirrorTree().mirror(root);
        System.out.println(mirror);
    }

    private TreeNode mirror(TreeNode root) {
        if (null != root) {
            swap(root);
            mirror(root.left);
            mirror(root.right);
        }

        return root;
    }

    private void swap(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
}
