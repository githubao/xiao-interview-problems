package me.xiao.interview;

/**
 * 构建二叉树
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/11 16:21
 */

public class Section06_ConstructTree {
    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode head = construct(preorder, inorder);
        if (null != head) head.print();
//        if (null != head) System.out.println(head);

    }

    private static TreeNode construct(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length < 1)
            return null;
        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode construct(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe) return null;

        // 前序遍历的第一个节点就是根节点
        int value = preorder[ps];
        int index = is;

        // 中序遍历的节点找到根节点的位置
        while (index < ie && inorder[index] != value) {
            index++;
        }

        if (index > ie) {
            throw new RuntimeException("invalid param");
        }

        TreeNode node = new TreeNode(value);

        /**
         * 中序遍历的前序有(index-is+1)个节点，然后从ps开始的
         */
        node.left = construct(preorder, ps + 1, ps + index - is, inorder, is, index - 1);

        node.right = construct(preorder, ps + index - is + 1, pe, inorder, index + 1, ie);

        return node;

    }
}
