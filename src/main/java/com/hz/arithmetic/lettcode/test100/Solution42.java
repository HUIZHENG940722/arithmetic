package com.hz.arithmetic.lettcode.test100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 接雨水
 *
 * @author zhenghui
 * @since 2023/11/19
 */
public class Solution42 {

  /**
   * 动态规划
   *
   * @param height 柱子高度集合
   * @return
   */
  public int trap1(int[] height) {
    int len = height.length;
    if (len == 0) {
      return 0;
    }
    int[] leftMax = new int[len];
    leftMax[0] = height[0];
    for (int i = 1; i < len; i++) {
      leftMax[i] = Math.max(leftMax[i - 1], height[i]);
    }
    int[] rightMax = new int[len];
    rightMax[len - 1] = height[len - 1];
    for (int i = len - 2; i >= 0; i--) {
      rightMax[i] = Math.max(rightMax[i + 1], height[i]);
    }
    int ans = 0;
    for (int i = 0; i < len; i++) {
      ans += Math.min(leftMax[i], rightMax[i]) - height[i];
    }
    return ans;
  }

  /**
   * 单调栈
   *
   * @param height
   * @return
   */
  public int trap2(int[] height) {
    Deque<Integer> st = new ArrayDeque<>();
    int index = 0, ans = 0, len = height.length;
    while (index < len) {
      while (!st.isEmpty() && height[index] > height[st.peek()]) {
        int top = st.pop();
        if (st.isEmpty()) {
          break;
        }
        int distance = index - 1 - st.peek();
        int bounded_height = Math.min(height[index], height[st.peek()]) - height[top];
        ans += distance * bounded_height;
      }
      st.push(index++);
    }
    return ans;
  }

  /**
   * 双指针
   *
   * @param height
   * @return
   */
  public int trap3(int[] height) {
    int left = 0, right =
        height.length - 1, len = height.length, leftMax = 0, rightMax = 0, ans = 0;
    while (left < right) {
      leftMax = Math.max(leftMax, height[left]);
      rightMax = Math.max(rightMax, height[right]);
      if (height[left] < height[right]) {
        ans += leftMax - height[left];
        left++;
      } else {
        ans += rightMax - height[right];
        right--;
      }
    }
    return ans;
  }
}
