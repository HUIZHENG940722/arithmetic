package com.hz.arithmetic.lettcode.test75;

/**
 * 盛最多水的容器
 *
 * @author zhenghui
 * @since 2023/9/9
 */
public class Solution11 {

  public int maxArea(int[] height) {
    int len = height.length, i = 0, j = len - 1;
    int max = Math.min(height[i], height[j]) * (j - i);
    while (i < j) {
      max = Math.max(max, Math.min(height[i], height[j])* (j-i));
      if (height[i] < height[j]) {
        int left = height[i++];
        while (i < j && height[i] <= left) {
          i++;
        }
      } else if (height[i] == height[j]) {
        i++;
        j--;
      } else {
        int right = height[j];
        while (j>i && height[j] <= right) {
          j--;
        }
      }
    }
    return max;
  }
}
