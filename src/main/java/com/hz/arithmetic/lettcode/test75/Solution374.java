package com.hz.arithmetic.lettcode.test75;

/**
 * 猜数字大小
 *
 * @author zhenghui
 * @since 2023/10/7
 */
public class Solution374 {

  private int pick;

  public int guessNumber(int n) {
    int left = 1, right = n;
    while (left < right) {
      int mid = left + (right - left) / 2; // 防止计算时溢出
      if (guess(mid) < 0) {
        right = mid - 1;
      } else if (guess(mid) == 0) {
        return mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  private int guess(int mid) {
    return 0;
  }
}
