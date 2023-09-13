package com.hz.arithmetic.lettcode.test75;

/**
 * 第N个泰波那契数
 *
 * @author zhenghui
 * @since 2023/9/12
 */
public class Solution1137 {

  /*public int tribonacci(int n) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else if (n == 2) {
      return 1;
    }
    return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
  }*/

  public int tribonacci(int n) {
    if (n == 0) {
      return 0;
    } else if (n <= 2) {
      return 1;
    } else if (n == 3) {
      return 2;
    }
    return 2 * tribonacci(n - 1) - tribonacci(n - 4);
  }

  public int tribonacci2(int n) {
    if (n < 3) {
      if (n == 0) {
        return 0;
      } else {
        return 1;
      }
    }
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;
    for (int i = 3; i < n + 1; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }
    return dp[n];
  }

  public int tribonacci3(int n) {
    if (n == 0) {
      return 0;
    } else if (n < 3) {
      return 1;
    }
    int p = 0, q = 1, r = 1, tmp = 0;
    for (int i = 3; i < n + 1; i++) {
      tmp = p;
      p = q;
      q = r;
      r = tmp + p + q;
    }
    return r;
  }
}
