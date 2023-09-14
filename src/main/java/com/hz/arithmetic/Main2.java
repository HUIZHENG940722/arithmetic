package com.hz.arithmetic;

import java.util.Scanner;

/**
 * 种树苗
 *
 * @author zhenghui
 * @since 2023/9/13
 */
public class Main2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()) {
      // 输入能种树的点
      int sum = Integer.parseInt(sc.nextLine().trim());
      // 输入适合种树的坐标位置
      int[] positions = new int[sum];
      for (int i = 0; i < sum; i++) {
        positions[i] = Integer.parseInt(sc.nextLine().trim());
      }
      // 输入树苗数
      int m = Integer.parseInt(sc.nextLine().trim());

    }
  }

  /**
   * 回溯算法
   *
   * @param positions 能种植的坐标
   * @param sum       能种植的坐标个数
   * @param n         树数量
   * @return 树之间的间距的最小的最大值
   */
  private static int hs(int[] positions, int sum, int n) {
    return 0;
  }
}
