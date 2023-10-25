package com.hz.arithmetic.lettcode.test75;


/**
 * 二叉树中的最长交错路径
 *
 * @author zhenghui
 * @since 2023/10/1
 */
public class Solution1372 {

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

  public int longestZigZag(TreeNode root) {
    int[] result = new int[]{0};
    longestZigZag(root, result);
    return result[0];
  }

  /**
   * 先序遍历
   *
   * @param node
   * @param result
   */
  private void longestZigZag(TreeNode node, int[] result) {
    if (node != null) {
      result[0] = Math.max(result[0],
          Math.max(longestZigZag(node, true), longestZigZag(node, false)));
      longestZigZag(node.left, result);
      longestZigZag(node.right, result);
    }
  }

  /**
   * 直接递归遍历
   *
   * @param node
   * @param direction node节点的方向true为left
   * @return
   */
  private int longestZigZag(TreeNode node, boolean direction) {
    if (direction) {
      if (node.left == null) {
        return 0;
      } else {
        return 1 + longestZigZag(node.left, false);
      }
    } else {
      if (node.right == null) {
        return 0;
      } else {
        return 1 + longestZigZag(node.right, true);
      }
    }
  }

  /**
   * 尾递归
   *
   * @param node
   * @param direction 已node节点结尾，且是父节点的left（true）、right（false）：这样子节点可以沿用父子节的值
   * @return
   */
  private void longestZigZagH(TreeNode node, boolean direction, int len, int[] result) {
    if (node != null) {
      result[0] = Math.max(result[0], len);
      if (direction) {
        if (node.left != null) {
          longestZigZagH(node.left, true, 1, result);
        }
        if (node.right != null) {
          longestZigZagH(node.right, false, len + 1, result);
        }
      } else {
        if (node.left != null) {
          longestZigZagH(node.left, true, len + 1, result);
        }
        if (node.right != null) {
          longestZigZagH(node.right, false, 1, result);
        }
      }
    }
  }
}
