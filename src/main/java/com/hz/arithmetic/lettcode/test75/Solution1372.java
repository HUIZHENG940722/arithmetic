package com.hz.arithmetic.lettcode.test75;


/**
 * 二叉树中的最长交错路径
 *
 * @author zhenghui
 * @since 2023/10/1
 */
public class Solution1372 {

  public int longestZigZag(TreeNode root) {
    int max = 0;
    if (root == null) {
      return 0;
    } else if (root.left == null && root.right == null) {
      return 0;
    }
    max = Math.max(max, longestZigZag(root.left));
    max = Math.max(max, longestZigZag(root.right));
    return max;
  }

  private int zigZag(TreeNode node) {
    int flag = 0;
    TreeNode p = node;
    int res1 = 0, res2 = 0;
    while (p != null) {
      res1++;
      if (flag == 0) {
        flag = 1;
        p = p.left;
      } else {
        flag = 0;
        p = p.right;
      }
    }
    p = node;
    flag = 1;
    while (p != null) {
      res2++;
      if (flag == 0) {
        flag = 1;
        p = p.left;
      } else {
        flag = 0;
        p = p.right;
      }
    }
    return Math.max(res1, res2) - 1;
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
