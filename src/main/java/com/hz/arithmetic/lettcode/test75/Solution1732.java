package com.hz.arithmetic.lettcode.test75;

/**
 * 找到最高海拔
 *
 * @author zhenghui
 * @since 2023/9/16
 */
public class Solution1732 {

  public static void main(String[] args) {
    int[] gain = new int[]{-5, 1, 5, 0, -7};
    int i = largestAltitude(gain);
    System.out.println(i);
  }

  public static int largestAltitude(int[] gain) {
    int max = 0, len = gain.length, length = 0;
    for (int j : gain) {
      // 表示第i+1点的海拔
      length += j;
      max = Math.max(max, length);
    }
    return max;
  }
}
