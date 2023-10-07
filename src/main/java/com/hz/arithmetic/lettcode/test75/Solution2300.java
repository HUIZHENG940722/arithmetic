package com.hz.arithmetic.lettcode.test75;

import java.util.Arrays;

/**
 * 咒语和药水的成功对数
 *
 * @author zhenghui
 * @since 2023/10/7
 */
public class Solution2300 {

  /**
   * 超过了时间复杂度
   *
   * @param spells
   * @param potions
   * @param success
   * @return
   */
  public int[] successfulPairs1(int[] spells, int[] potions, long success) {
    int n = spells.length, m = potions.length;
    int[] result = new int[n];
    int i = 0;
    for (; i < n; i++) {
      int sum = 0;
      int spell = spells[i];
      for (int j = 0; j < m; j++) {
        if ((long) spell * potions[j] >= success) {
          sum++;
        }
      }
      result[i] = sum;
    }
    return result;
  }


  public int[] successfulPairs(int[] spells, int[] potions, long success) {
    int n = spells.length, m = potions.length;
    int[] result = new int[n];
    Arrays.sort(potions);
    int i = 0, j = m - 1;
    for (; i < n; i++) {
      int spell = spells[i];
      int flag = i == 0 ? 1 : spell - spells[i - 1];
      if (flag == 0) {
        result[i] = result[i - 1];
      } else if (flag > 0) {
        if (j == m) {
          j--;
        }
        while (j >= 0 && (long) spell * potions[j] >= success) {
          j--;
        }
        j++;
        result[i] = m - j;
      } else {
        while (j < m && (long) spell * potions[j] < success) {
          j++;
        }
        result[i] = m - j;
      }
    }
    return result;
  }
}
