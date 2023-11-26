package com.hz.arithmetic.lettcode.test100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 缺失的第一个正数
 *
 * @author zhenghui
 * @since 2023/11/26
 */
public class Solution41 {

  public int firstMissingPositive(int[] nums) {
    int result = 1, len = nums.length;
    Arrays.sort(nums);
    for (int i = 0; i < len; i++) {
      if (nums[i] > result) {
        return result;
      } else if (nums[i] == result) {
        result++;
      }
    }
    return result;
  }

  /**
   * 哈希表
   *
   * @param nums
   * @return
   */
  public int firstMissingPositive2(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, 1);
    }
    int result = 1;
    while (true) {
      if (map.containsKey(result)) {
        result++;
      } else {
        break;
      }
    }
    return result;
  }

  /**
   * 数的对应索引位法
   *
   * @param nums
   * @return
   */
  public int firstMissingPositive3(int[] nums) {
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      if (nums[i] <= 0) {
        nums[i] = len + 1;
      }
    }
    for (int i = 0; i < len; i++) {
      int num = Math.abs(nums[i]);
      if (num <= len) {
        nums[num - 1] = -Math.abs(nums[num - 1]);
      }
    }
    for (int i = 0; i < len; i++) {
      if (nums[i] > 0) {
        return i + 1;
      }
    }
    return len + 1;
  }
}
