package com.hz.arithmetic.lettcode.test75;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 统计二叉树中好节点的数目
 *
 * @author zhenghui
 * @since 2023/9/30
 */
public class Solution1448 {

  public int goodNodes(TreeNode root) {
    if (root == null) {
      return 0;
    } else if (root.left == null && root.right == null) {
      return 1;
    }
    int result = 0;
    Queue<TreeNodeP> queue = new ArrayDeque<>();
    queue.add(new TreeNodeP(Integer.MIN_VALUE, root));
    while (!queue.isEmpty()) {
      TreeNodeP poll = queue.poll();
      TreeNode node = poll.node;
      int max = poll.max;
      if (node.val >= poll.max) {
        result++;
        max = node.val;
      }
      if (node.left != null) {
        queue.add(new TreeNodeP(max, node.left));
      }
      if (node.right != null) {
        queue.add(new TreeNodeP(max, node.right));
      }
    }
    return result;
  }

  /**
   * 存储的是树节点与及祖辈节点最大值
   */
  private static class TreeNodeP {

    private int max;

    private TreeNode node;

    public TreeNodeP() {
    }

    public TreeNodeP(int max, TreeNode node) {
      this.max = max;
      this.node = node;
    }

    public int getMax() {
      return max;
    }

    public void setMax(int max) {
      this.max = max;
    }

    public TreeNode getNode() {
      return node;
    }

    public void setNode(TreeNode node) {
      this.node = node;
    }
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
