package com.hz.arithmetic.lettcode.test75;


import java.util.LinkedList;
import java.util.List;

/**
 * 叶子相似的树
 *
 * @author zhenghui
 * @since 2023/10/1
 */
public class Solution872 {

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> list1 = new LinkedList<>();
    preorderTraversal(root1, list1);
    List<Integer> list2 = new LinkedList<>();
    preorderTraversal(root2, list2);
    return list2.equals(list1);
  }

  private void preorderTraversal(TreeNode root, List<Integer> result) {
    if (root != null) {
      if (root.left == null && root.right == null) {
        result.add(root.val);
      }
      preorderTraversal(root.left, result);
      preorderTraversal(root.right, result);
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
