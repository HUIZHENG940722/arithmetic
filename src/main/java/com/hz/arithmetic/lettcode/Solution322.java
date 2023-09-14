package com.hz.arithmetic.lettcode;

import java.util.Arrays;

/**
 * 零钱兑换
 *
 * @author zhenghui
 * @since 2023/9/13
 */
public class Solution322 {

  /**
   * 错误
   *
   * @param coins
   * @param amount
   * @return
   */
  public int coinChangeForError(int[] coins, int amount) {
    Arrays.sort(coins);
    int len = coins.length, index = len - 1, result = 0;
    while (index >= 0 && amount > 0) {
      while (index >= 0 && coins[index] > amount) {
        index--;
      }
      if (index >= 0) {
        amount = amount - coins[index];
        result++;
      }
    }
    return amount == 0 ? result : -1;
  }

  /**
   * 回朔算法
   *
   * @param coins
   * @param amount
   * @return
   */
  public int coinChange(int[] coins, int amount) {
    int[] result = new int[]{Integer.MAX_VALUE};
    if (amount == 0) {
      return 0;
    }
    coinChange(coins, amount, 0, 0, 0, result);
    return result[0] == Integer.MAX_VALUE ? -1 : result[0];
  }

  /**
   * @param coins
   * @param amount
   * @param index
   * @param count
   * @param sum
   * @param result
   */
  private void coinChange(int[] coins, int amount, int index, int count, int sum, int[] result) {
    int len = coins.length;
    if (index >= len || sum > amount || count > result[0]) {
      if (sum == amount) {
        result[0] = Math.min(result[0], count);
      }
      return;
    }
    int val = coins[index], n = (amount - sum) / val;
    for (int i = index; i < len; i++) {
      for (int j = 0; j <= n; j++) {
        coinChange(coins, amount, index + 1, count + j, sum + (j * val), result);
      }
    }
  }
}
