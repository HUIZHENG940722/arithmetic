package com.hz.arithmetic.lettcode.test75;

/**
 * 使用最小花费爬楼梯
 *
 * @author zhenghui
 * @since 2023/9/12
 */
public class Solution746 {

  public int minCostClimbingStairs(int[] cost) {
    int len = cost.length;
    return minCostClimbingStairs(len, cost);
  }

  private int minCostClimbingStairs(int n, int[] cost) {
    if (n <= 1) {
      return 0;
    }
    return Math.min(minCostClimbingStairs(n - 2, cost) + cost[n - 2],
        minCostClimbingStairs(n - 1, cost) + cost[n - 1]);
  }

  public int minCostClimbingStairs2(int[] cost) {
    int len = cost.length;
    if (len <= 1) {
      return 0;
    }
    int[] dp = new int[len + 1];
    dp[0] = 0;
    dp[1] = 0;
    for (int i = 2; i < len + 1; i++) {
      dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
    }
    return dp[len];
  }

  public int minCostClimbingStairs3(int[] cost) {
    int len = cost.length;
    if (len <= 1) {
      return 0;
    }
    int p = 0, q = 0, tmp = 0;
    for (int i = 2; i < len + 1; i++) {
      tmp = Math.min(p + cost[i - 2], q + cost[i - 1]);
      p = q;
      q = tmp;
    }
    return q;
  }
}
