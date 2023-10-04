package com.hz.arithmetic.lettcode.test75;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 二叉树的右视图
 *
 * @author zhenghui
 * @since 2023/10/3
 */
public class Solution199 {

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    xianxu(root, 1, map);
    map.forEach((key, val) -> {
      result.add(val);
    });
    return result;
  }

  private void xianxu(TreeNode root, int level, Map<Integer, Integer> map) {
    if (root == null) {
      return;
    }
    map.put(level, root.val);
    xianxu(root.left, level + 1, map);
    xianxu(root.right, level + 1, map);
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
