package com.hz.arithmetic.lettcode.test75;


/**
 * 删除二叉树搜索树中的节点
 *
 * @author zhenghui
 * @since 2023/10/6
 */
public class Solution450 {

  public TreeNode deleteNode(TreeNode root, int key) {
    TreeNode delRoot = root;
    boolean flag = true;
    while (delRoot != null) {
      if (delRoot.val == key) {
        flag = false;
        break;
      } else if (delRoot.val < key) {
        delRoot = delRoot.right;
      } else {
        delRoot = delRoot.left;
      }
    }
    if (flag) {
      return root;
    }
    if (delRoot.left == null && delRoot.right == null) {
      // 删除这节点，直接删除

      return root;
    } else {
      // 需要把子树合并成一个
      return null;
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
