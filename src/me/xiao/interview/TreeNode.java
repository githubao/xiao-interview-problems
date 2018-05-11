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

            System.out.print(node.val+" ");

            if (node.left != null) queue.offer(node.left);
//            else queue.offer(new TreeNode(-1));

            if (node.right != null) queue.offer(node.right);
//            else queue.offer(new TreeNode(-1));
        }

        System.out.println();
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
