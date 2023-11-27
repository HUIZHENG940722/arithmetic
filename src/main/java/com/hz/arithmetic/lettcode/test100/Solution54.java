package com.hz.arithmetic.lettcode.test100;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * @author zhenghui
 * @since 2023/11/27
 */
public class Solution54 {

  public static void main(String[] args) {
    int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    List<Integer> list = spiralOrder(matrix);
    System.out.println(list);
  }

  public static List<Integer> spiralOrder(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length, total = m * n;
    int left = 0, right = n - 1, up = 0, down = m - 1, index = 0;
    List<Integer> result = new ArrayList<>();
    while (index < total) {
      // 从左到右遍历
      for (int i = left; i <= right && index < total; i++) {
        result.add(matrix[up][i]);
        index++;
      }
      if (index == total) {
        break;
      }
      up++;
      // 从上到下遍历
      for (int i = up; i <= down && index < total; i++) {
        result.add(matrix[i][right]);
        index++;
      }
      if (index == total) {
        break;
      }
      right--;
      // 从右到左遍历
      for (int i = right; i >= left && index < total; i--) {
        result.add(matrix[down][i]);
        index++;
      }
      if (index == total) {
        break;
      }
      down--;
      // 从下到上遍历
      for (int i = down; i >= up && index < total; i--) {
        result.add(matrix[i][left]);
        index++;
      }
      if (index == total) {
        break;
      }
      left++;
    }
    return result;
  }
}
