package com.hz.arithmetic.lettcode.test100;

/**
 * 搜索二维矩阵
 *
 * @author zhenghui
 * @since 2023/11/29
 */
public class Solution240 {

  /**
   * 直接查找的优化版本
   *
   * @param matrix
   * @param target
   * @return
   */
  public static boolean searchMatrix1(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length;
    for (int i = 0; i < m; i++) {
      int j = 0;
      while (j < n && matrix[i][j] < target) {
        j++;
      }
      if (j < n && matrix[i][j] == target) {
        return true;
      }
    }
    return false;
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    for (int[] ints : matrix) {
      int index = search(ints, target);
      if (index >= 0) {
        return true;
      }
    }
    return false;
  }

  /**
   * 二分查找
   *
   * @param nums
   * @param target
   * @return
   */
  private int search(int[] nums, int target) {
    int len = nums.length, low = 0, height = len - 1;
    while (low <= height) {
      int mid = (height - low) / 2 + low;
      int num = nums[mid];
      if (num == target) {
        return mid;
      } else if (num > target) {
        height = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }
}
