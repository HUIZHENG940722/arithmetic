package com.hz.arithmetic.lettcode.test100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * @author zhenghui
 * @since 2023/11/13
 */
public class Solution15 {

  /**
   * 穷举法: 超出时间复杂度
   *
   * @param nums
   * @return
   */
  public List<List<Integer>> threeSum1(int[] nums) {
    int len = nums.length;
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < len - 2; i++) {
      if (i != 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < len - 1; j++) {
        if (j - 1 > i && nums[j] == nums[j - 1]) {
          continue;
        }
        for (int k = j + 1; k < len; k++) {
          if (k - 1 > j && nums[k] == nums[k - 1]) {
            continue;
          }
          if (nums[i] + nums[j] + nums[k] == 0) {
            result.add(Arrays.asList(nums[i], nums[j], nums[k]));
          }
        }
      }
    }
    return result;
  }

  public List<List<Integer>> threeSum(int[] nums) {
    int len = nums.length;
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < len - 2; i++) {
      if (i != 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      twoSum(nums, i + 1, len - 1, -nums[i], result);
    }
    return result;
  }

  public void twoSum(int[] nums, int left, int right, int target, List<List<Integer>> result) {
    int tmp = left - 1;
    while (left < right) {
      if (nums[left] + nums[right] > target) {
        right--;
      } else if (nums[left] + nums[right] < target) {
        left++;
      } else {
        result.add(Arrays.asList(nums[tmp], nums[left], nums[right]));
        left++;
        while (left < right && nums[left] == nums[left - 1]) {
          left++;
        }
        right--;
        while (right > left && nums[right] == nums[right + 1]) {
          right--;
        }
      }
    }
  }
}
