package com.hz.arithmetic.lettcode.test75;

/**
 * 最大子序列的分数
 *
 * @author zhenghui
 * @since 2023/10/11
 */
public class Solution2542 {

  public long maxScore(int[] nums1, int[] nums2, int k) {
    int[] result = new int[]{Integer.MIN_VALUE};
    maxScore(nums1, nums2, k, 0, new int[nums1.length], new int[k], result);
    return result[0];
  }

  /**
   * 最大子序列的分数
   *
   * @param nums1
   * @param nums2
   * @param k
   * @param index
   * @param result
   * @return
   */
  private void maxScore(int[] nums1, int[] nums2, int k, int index, int[] flag, int[] tmp,
      int[] result) {
    if (index == k) {
      int sum = 0, min = Integer.MAX_VALUE;
      for (int i : tmp) {
        sum += nums1[i];
        min = Math.min(min, nums2[i]);
      }
      result[0] = Math.max(result[0], sum * min);
      return;
    }
    int len = flag.length;
    for (int i = 0; i < len; i++) {
      int data = flag[i];
      if (data == 0) {
        tmp[index] = i;
        flag[i] = -1;
        maxScore(nums1, nums2, k, index + 1, flag, tmp, result);
        tmp[index] = 0;
        flag[i] = 0;
      }
    }
  }
}
