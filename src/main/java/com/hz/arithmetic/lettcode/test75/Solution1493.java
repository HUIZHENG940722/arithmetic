package com.hz.arithmetic.lettcode.test75;

/**
 * 删除一个元素之后全为1的子数组长度
 *
 * @author zhenghui
 * @since 2019/11/28 11:38 AM
 */
class Solution1493 {

  public static void main(String[] args) {
    int[] nums = new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1};
    int i = longestSubarray2(nums);
    System.out.println(i);
  }

  public static int longestSubarray(int[] nums) {
    int len = nums.length, left = 0, right = 0, k = 1, result = 0;
    while (right < len) {
      while (right < len && nums[right] == 1) {
        right++;
      }
      if (right < len) {
        if (k > 0) {
          right++;
          k--;
        } else {
          while (right < len && nums[left] == 0 && nums[right] == 0) {
            left++;
            right++;
          }
          while (right < len && nums[right] == 1) {
            right++;
          }
          result = Math.max(result, right - left);
          while (left < len && nums[left] == 1) {
            left++;
          }
        }
      }
    }
    result = Math.max(result, right - left);
    return result - 1;
  }

  /**
   * 优化
   *
   * @param nums
   * @return
   */
  public static int longestSubarray2(int[] nums) {
    int len = nums.length, left = 0, right = 0, k = 1, result = 0;
    while (right < len) {
      if (nums[right] == 1) {
        right++;
      } else {
        if (k > 0) {
          right++;
          k--;
        } else if (nums[left] == 1) {
          result = Math.max(result, right - left);
          while (left < len && nums[left] == 1) {
            left++;
          }
        } else {
          left++;
          right++;
        }
      }
    }
    result = Math.max(result, right - left);
    return result - 1;
  }
}