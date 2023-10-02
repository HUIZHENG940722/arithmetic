package com.hz.arithmetic.lettcode.test75;

/**
 * 路径总和III
 *
 * @author zhenghui
 * @since 2023/10/1
 */
public class Solution437 {

  public int pathSum1(TreeNode root, int targetSum) {
    long[] res = new long[1];
    allNodePathSum(root, targetSum, res);
    return (int) res[0];
  }

  private void allNodePathSum(TreeNode root, int targetSum, long[] res) {
    if (root == null) {
      return;
    } else {
      long[] result = new long[1];
      nodePathSum(root, targetSum, root.val, result);
      res[0] += result[0];
    }
    allNodePathSum(root.left, targetSum, res);
    allNodePathSum(root.right, targetSum, res);
  }

  private void nodePathSum(TreeNode root, int targetSum, int val, long[] result) {
    if (root == null) {
      return;
    }
    if (val == targetSum) {
      result[0]++;
    }
    nodePathSum(root.left, targetSum, val + (root.left == null ? 0 : root.left.val), result);
    nodePathSum(root.right, targetSum, val + (root.right == null ? 0 : root.right.val), result);
  }

  /**
   * 方法二
   *
   * @param root
   * @param targetSum
   * @return
   */
  public int pathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return 0;
    }
    int ret = rootSum(root, targetSum);
    ret += pathSum(root.left, targetSum);
    ret += pathSum(root.right, targetSum);
    return ret;
  }

  private int rootSum(TreeNode root, int targetSum) {
    int ret = 0;
    if (root == null) {
      return 0;
    }
    if (targetSum == root.val) {
      ret++;
    }
    ret += rootSum(root.left, targetSum - root.val);
    ret += rootSum(root.right, targetSum - root.val);
    return ret;
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
