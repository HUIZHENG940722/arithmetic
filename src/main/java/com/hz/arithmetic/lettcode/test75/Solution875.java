package com.hz.arithmetic.lettcode.test75;

/**
 * 爱吃香蕉的珂珂
 *
 * @author zhenghui
 * @since 2023/10/8
 */
public class Solution875 {

  public static void main(String[] args) {
    int[] piles = new int[]{312884470};
    int i = minEatingSpeed(piles, 312884469);
    System.out.println(i);
  }

  public static int minEatingSpeed(int[] piles, int h) {
    int left = 1, right = 0;
    for (int pile : piles) {
      if (right < pile) {
        right = pile;
      }
    }
    while (left < right) {
      int mid = left + (right - left) / 2;
      int eatSpeed = isEatSpeed(piles, h, mid);
      if (eatSpeed == 0) {
        right = mid;
      } else if (eatSpeed > 0) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  private static int isEatSpeed(int[] piles, int h, int k) {
    int sum = 0;
    for (int pile : piles) {
      sum += (pile - 1) / k + 1;
    }
    if (sum == h) {
      return 0;
    } else if (sum > h) {
      return 1;
    }
    return -1;
  }
}
