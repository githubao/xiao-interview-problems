package me.xiao.interview.ch03;

import me.xiao.interview.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 广度优先遍历二叉树
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/12 16:24
 */

public class Section23_PrintTree {
    class LevelNode {
        public LevelNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }

        TreeNode node;
        int level;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.defaultBuild();
        new Section23_PrintTree().print(root);
    }

    private void print(TreeNode root) {

        Queue<LevelNode> queue = new ArrayDeque<>();
        queue.offer(new LevelNode(root, 1));

        int level = 1;

        while (!queue.isEmpty()) {
            LevelNode node = queue.poll();

            if (level < node.level) {
                System.out.println();
                level += 1;
            }

            System.out.print(node.node.val + " ");

            if (node.node.left != null) {
                queue.offer(new LevelNode(node.node.left, node.level+1));
            }else if (level < 4){
                queue.offer(new LevelNode(new TreeNode(-1),node.level+1));
            }

            if (node.node.right != null) {
                queue.offer(new LevelNode(node.node.right, node.level+1));
            }else if (level < 4){
                queue.offer(new LevelNode(new TreeNode(-1),node.level+1));
            }

        }

    }

}
