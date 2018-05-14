package me.xiao.interview.ch04;

import me.xiao.interview.TreeNode;

/**
 * 计算二叉树的深度
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/14 11:07
 */

public class Section39_TreeDepth {
    public static void main(String[] args) {
        TreeNode root = TreeNode.defaultBuild();
        System.out.println(new Section39_TreeDepth().treeDepth(root));
        System.out.println(new Section39_TreeDepth().isBalanceTree(root));
    }

    private boolean isBalanceTree(TreeNode root) {
        int[] depth = new int[1];
        return isBalancedHelper(root, depth);
    }

    private boolean isBalancedHelper(TreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }

        int[] left = new int[1];
        int[] right = new int[1];

        if (isBalancedHelper(root.left, left) && isBalancedHelper(root.right, right)) {
            int diff = Math.abs(left[0] - right[0]);
            if (diff <= 1) {
                depth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
                return true;
            }
        }

        return false;
    }

    private int treeDepth(TreeNode root) {
        if (root == null) return 0;

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return left > right ? (left + 1) : (right + 1);
    }

}
