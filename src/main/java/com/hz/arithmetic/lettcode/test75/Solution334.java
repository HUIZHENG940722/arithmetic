package com.hz.arithmetic.lettcode.test75;

/**
 * 递增的三元子序列
 *
 * @author zhenghui
 * @since 2023/9/7
 */
public class Solution334 {

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 1, 3};
    boolean b = increasingTriplet(nums);
    System.out.println(b);
  }

  public boolean increasingTriplet1(int[] nums) {
    int len = nums.length;
    for (int i = 0; i < len - 2; i++) {
      int j = i + 1;
      for (; j < len - 1; j++) {
        int k = j + 1;
        if (nums[j] <= nums[i]) {
          continue;
        }
        for (; k < len; k++) {
          if (nums[k] > nums[j]) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public static boolean increasingTriplet(int[] nums) {
    int len = nums.length, min = nums[0], med = Integer.MAX_VALUE, i = 0;
    while (i < len - 1) {
      if (nums[i] > min) {
        if (nums[i] < med) {
          med = nums[i];
          int k = i + 1;
          for (; k < len; k++) {
            if (nums[k] > med) {
              return true;
            }
          }
        } else {
          while (i < len - 1 && nums[i] >= med) {
            i++;
          }
        }
      } else if (nums[i] == min) {
        while (i < len - 1 && nums[i] == min) {
          i++;
        }
      } else {
        min = nums[i];
        i++;
      }
    }
    return false;
  }
}
