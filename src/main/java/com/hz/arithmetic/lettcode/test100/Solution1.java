package com.hz.arithmetic.lettcode.test100;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author zhenghui
 * @since 2023/11/11
 */
public class Solution1 {

  public int[] twoSum(int[] nums, int target) {
    int len = nums.length;
    for (int i = 0; i < len - 1; i++) {
      for (int j = i + 1; j < len; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return new int[]{-1, -1};
  }

  /**
   * 哈希法
   *
   * @param nums
   * @param target
   * @return
   */
  public int[] twoSum2(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        return new int[]{map.get(target - nums[i]), i};
      }
      map.put(nums[i], i);
    }
    return new int[]{-1, -1};
  }
}
