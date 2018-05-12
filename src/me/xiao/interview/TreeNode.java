package me.xiao.interview;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 树节点
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/11 16:10
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }

    public void print() {
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(this);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            System.out.print(node.val + " ");

            if (node.left != null) queue.offer(node.left);
//            else queue.offer(new TreeNode(-1));

            if (node.right != null) queue.offer(node.right);
//            else queue.offer(new TreeNode(-1));
        }

        System.out.println();
    }

    public static TreeNode defaultBuild() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }

    public static TreeNode defaultBuild2() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        return root;
    }

    public static TreeNode bstBuild() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        return root;
    }

    @Override
    public String toString() {
        int leftVal = left == null ? -1 : left.val;
        int rightVal = right == null ? -1 : right.val;

        return "TreeNode{" +
                "val=" + val +
                ", left=" + leftVal +
                ", right=" + rightVal +
                '}';
    }

    public void circlePrint() {
        System.out.println(this);
        if (this.right != null){
            this.right.circlePrint();
        }

    }
}
