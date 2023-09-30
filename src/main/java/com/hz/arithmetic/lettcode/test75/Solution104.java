package com.hz.arithmetic.lettcode.test75;

/**
 * 二叉树的最大深度
 *
 * @author zhenghui
 * @since 2023/9/30
 */
public class Solution104 {

  public int maxDepth(TreeNode root) {
    if (root != null && root.left == null && root.right == null) {
      return 1;
    } else if (root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }

  private static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
      this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
