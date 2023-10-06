package com.hz.arithmetic.lettcode.test75;

/**
 * 二叉搜索树中的搜索
 *
 * @author zhenghui
 * @since 2023/10/6
 */
public class Solution700 {

  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }
    if (root.val > val) {
      return searchBST(root.left, val);
    } else if (root.val == val) {
      return root;
    }
    return searchBST(root.right, val);
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
