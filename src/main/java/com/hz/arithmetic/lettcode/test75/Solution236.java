package com.hz.arithmetic.lettcode.test75;

/**
 * 二叉树的最近公共祖先
 *
 * @author zhenghui
 * @since 2023/10/2
 */
public class Solution236 {

  private TreeNode ans;

  public Solution236() {
    this.ans = null;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    this.dfs(root, p, q);
    return this.ans;
  }

  private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return false;
    }
    boolean l = dfs(root.left, p, q);
    boolean r = dfs(root.right, p, q);
    if ((l && r) || (root.val == p.val || root.val == q.val) && (l || r)) {
      ans = root;
    }
    return l || r || (root.val == p.val || root.val == q.val);
  }

  private static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
      this.val = val;
    }
  }

  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    isIncludePAndQ(root, p, q);
    return this.ans;
  }



  /**
   * 后续遍历
   *
   * @param root
   * @param p
   * @param q
   * @return
   */
  private boolean isIncludePAndQ(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return false;
    }
    boolean left = isIncludePAndQ(root.left, p, q);
    boolean right = isIncludePAndQ(root.right, p, q);
    if ((left && right) || ((root.val == p.val || root.val == q.val) && (left || right))) {
      this.ans = root;
    }
    if (root.val == p.val) {
      return true;
    } else if (root.val == q.val) {
      return true;
    }
    return left || right;
  }
}
