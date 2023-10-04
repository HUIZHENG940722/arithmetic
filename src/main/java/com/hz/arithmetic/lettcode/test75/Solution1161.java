package com.hz.arithmetic.lettcode.test75;


import java.util.HashMap;
import java.util.Map;

/**
 * 最大层内元素和
 *
 * @author zhenghui
 * @since 2023/10/4
 */
public class Solution1161 {

  public int maxLevelSum(TreeNode root) {
    Map<Integer, Integer> map = new HashMap<>();
    xianxu(root, 1, map);
    final int[] result = {Integer.MIN_VALUE, 1};
    map.forEach((key, val) -> {
      if (result[0] < val) {
        result[1] = key;
        result[0] = val;
      }
    });
    return result[1];
  }

  private void xianxu(TreeNode root, int level, Map<Integer, Integer> map) {
    if (root == null) {
      return;
    }
    map.put(level, root.val + map.getOrDefault(level, 0));
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
