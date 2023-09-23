package com.hz.arithmetic.lettcode.test75;

/**
 * 比特位计数
 *
 * @author zhenghui
 * @since 2023/9/23
 */
public class Solution338 {

  /**
   * 利用转换为二进制函数
   *
   * @param n
   * @return
   */
  public int[] countBits(int n) {
    int[] ans = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      ans[i] = getSum1(Integer.toBinaryString(i));
    }
    return ans;
  }

  private Integer getSum1(String str) {
    int len = str.length(), sum = 0;
    for (int i = 0; i < len; i++) {
      if (str.charAt(i) == '1') {
        sum++;
      }
    }
    return sum;
  }

  public int[] countBits2(int n) {
    int[] ans = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      ans[i] = Integer.bitCount(i);
    }
    return ans;
  }


}
