package me.xiao.interview.ch02;

import me.xiao.interview.TreeNode;

/**
 * 是不是另一颗树的子树
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/12 14:46
 */

public class Section18_SubTree {
    public static void main(String[] args) {
        TreeNode root = TreeNode.defaultBuild();
        TreeNode sub = TreeNode.defaultBuild2();
        System.out.println(new Section18_SubTree().hasSubTree(root, sub));
    }

    private boolean hasSubTree(TreeNode root1, TreeNode root2) {
        if (root1 == root2) return true;
        if (root1 == null) return false;
        if (root2 == null) return true;

        boolean flag = false;
        if (root1.val == root2.val) {
            flag = match(root1, root2);
        }

        if (flag) return true;
        return hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2);
    }

    private boolean match(TreeNode root1, TreeNode root2) {
        if (root1 == root2) return true;
        if (root1 == null) return false;
        if (root2 == null) return true;

        if (root1.val == root2.val) {
            return match(root1.left, root2.left) && match(root1.right, root2.right);
        }

        return false;
    }
}
