package com.hz.arithmetic.lettcode.test75;


/**
 * 删除二叉树搜索树中的节点
 *
 * @author zhenghui
 * @since 2023/10/6
 */
public class Solution450 {

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    if (root.val > key) {
      root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
      root.right = deleteNode(root.right, key);
    } else {
      if (root.left == null && root.right == null) {
        return null;
      } else if (root.right == null) {
        return root.left;
      } else if (root.left == null) {
        return root.right;
      }
      TreeNode successor = root.right;
      while (successor.left != null) {
        successor = successor.left;
      }
      successor.left = root.left;
      return root.right;
    }
    return root;
  }

  /**
   * 迭代
   *
   * @param root
   * @param key
   * @return
   */
  public TreeNode deleteNode2(TreeNode root, int key) {
    TreeNode parent = null, curr = root;
    while (curr != null && curr.val != key) {
      parent = curr;
      if (key > curr.val) {
        curr = curr.right;
      } else {
        curr = curr.left;
      }
    }
    if (curr == null) {
      return root;
    }
    if (curr.left == null && curr.right == null) {
      curr = null;
    } else if (curr.left == null) {
      curr = curr.right;
    } else if (curr.right == null) {
      curr = curr.left;
    } else {
      TreeNode successorP = curr, successor = curr.right;
      while (successor.left != null) {
        successorP = successor;
        successor = successor.left;
      }
      successor.left = curr.left;
      curr = curr.right;
    }
    if (parent == null) {
      return curr;
    } else {
      if (parent.left != null && parent.left.val == key) {
        parent.left = curr;
      } else {
        parent.right = curr;
      }
      return root;
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
