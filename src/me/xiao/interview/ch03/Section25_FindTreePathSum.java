package me.xiao.interview.ch03;

import me.xiao.interview.TreeNode;

import java.util.ArrayList;

/**
 * 找树的路径和为target值
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/12 16:54
 */

public class Section25_FindTreePathSum {
    public static void main(String[] args) {
        TreeNode root = TreeNode.defaultBuild();
        new Section25_FindTreePathSum().findPath(root, 10);
    }

    private void findPath(TreeNode root, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root != null) {
            findPath(root, 0, target, list);
        }
    }

    private void findPath(TreeNode root, int sum, int target, ArrayList<Integer> result) {
        if (root != null) {
            sum += root.val;
            result.add(root.val);
            if (sum < target) {
                findPath(root.left, sum, target, result);
                findPath(root.right, sum, target, result);
            } else if (sum == target) {
                if (root.left == null && root.right == null) {
                    System.out.println(result);
                }
            }

            // 前序遍历，栈往回找的时候
            result.remove(result.size() - 1);
        }
    }
}
