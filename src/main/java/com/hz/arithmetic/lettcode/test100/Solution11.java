package com.hz.arithmetic.lettcode.test100;

/**
 * 盛最多水的容器
 *
 * @author zhenghui
 * @since 2023/11/13
 */
public class Solution11 {

  public int maxArea(int[] height) {
    int len = height.length, left = 0, right = len - 1, result = 0;
    while (left < right) {
      int area = (right - left) * Math.min(height[left], height[right]);
      result = Math.max(result, area);
      if (height[left] >= height[right]) {
        right--;
      } else {
        left++;
      }
    }
    return result;
  }
}
