package com.hz.arithmetic.lettcode.test100;

/**
 * 转轮数组
 *
 * @author zhenghui
 * @since 2023/11/24
 */
public class Solution189 {

  public void rotate(int[] nums, int k) {
    int len = nums.length;
    k = k % len;
    int[] tmp = new int[len];
    System.arraycopy(nums, 0, tmp, 0, len);
    for (int i = 0; i < len; i++) {
      int index = (i + k) % len;
      nums[index] = tmp[i];
    }
  }

  public void rotate2(int[] nums, int k) {
    int len = nums.length;
    k = k % len;
    int count = gcd(k, len);
    for (int i = 0; i < count; i++) {
      int current = i;
      int prev = nums[i];
      do {
        int next = (current + k) % len;
        int temp = nums[next];
        nums[next] = prev;
        prev = temp;
        current = next;
      } while (i != current);
    }
  }

  /**
   * x y最大公约数
   *
   * @param x
   * @param y
   * @return
   */
  private int gcd(int x, int y) {
    return y > 0 ? gcd(y, x % y) : x;
  }

  /**
   * 数组翻转法
   *
   * @param nums
   * @param k
   */
  public void rotate3(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  private void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start += 1;
      end -= 1;
    }
  }
}
