package com.hz.arithmetic.lettcode.test100;

/**
 * 最大子数组和
 *
 * @author zhenghui
 * @since 2023/11/22
 */
public class Solution53 {

  public static void main(String[] args) {
    int[] nums = new int[]{5, 4, -1, 7, 8};
    int i = maxSubArray1(nums);
    System.out.println(i);
  }

  /**
   * 穷举，存在时间问题
   *
   * @param nums
   * @return
   */
  public static int maxSubArray1(int[] nums) {
    int len = nums.length, ans = 0;
    int[] sums = new int[len];
    for (int i = 0; i < len; i++) {
      ans += nums[i];
      sums[i] = ans;
    }
    int result = nums[0];
    for (int i = 0; i < len - 1; i++) {
      for (int j = i + 1; j < len; j++) {
        if (sums[j] - sums[i] > result) {
          result = sums[j] - sums[i];
        }
      }
    }
    for (int i = 0; i < len; i++) {
      if (sums[i] > result) {
        result = sums[i];
      }
    }
    return result;
  }

  /**
   * 动态规划
   *
   * @param nums
   * @return
   */
  public int maxSubArray(int[] nums) {
    int len = nums.length, res = nums[0];
    int[] sum = new int[len];
    sum[0] = nums[0];
    for (int i = 1; i < len; i++) {
      if (sum[i - 1] > 0) {
        sum[i] = sum[i - 1] + nums[i];
      } else {
        sum[i] = nums[i];
      }
      if (res < sum[i]) {
        res = sum[i];
      }
    }
    return res;
  }

  /**
   * 动态规划优化
   *
   * @param nums
   * @return
   */
  public int maxSubArray2(int[] nums) {
    int len = nums.length, res = nums[0], pre = 0;
    for (int num : nums) {
      if (pre > 0) {
        pre += num;
      } else {
        pre = num;
      }
      if (res < pre) {
        res = pre;
      }
    }
    return res;
  }
}
