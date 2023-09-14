package com.hz.arithmetic.lettcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 两球之间的磁力
 *
 * @author zhenghui
 * @since 2023/9/13
 */
public class Solution1552 {

  public static void main(String[] args) {
    int[] position = new int[]{4784, 9049, 3151, 7537, 2734, 1287, 2875, 6770, 9565, 6254, 6898,
        2509, 6583};
    int m = 13;
    int i = maxDistance(position, m);
    System.out.println(i);
  }

  public static int maxDistance(int[] position, int m) {
    List<Integer> positionList = new ArrayList<>();
    for (int i : position) {
      positionList.add(i);
    }
    int[] result = new int[1];
    Arrays.fill(result, Integer.MIN_VALUE);
    maxDistance(positionList, m, 0, new int[m], result);
    return result[0];
  }

  /**
   * 准备把第index+1个球放在那个坐标点上呢？
   *
   * @param positionList 可以放的坐标点
   * @param m            球的个数
   * @param index        前面已经放了index个球
   * @param list         放球的坐标集合
   * @param minMax       存放历史上的最小间距的最大值
   */
  private static void maxDistance(List<Integer> positionList, int m, int index, int[] list,
      int[] minMax) {
    if (index == m) {
      // 则计算最小间距的值
      Arrays.sort(list);
      int min = Integer.MAX_VALUE;
      for (int i = 1; i < m; i++) {
        min = Math.min(min, list[i] - list[i - 1]);
      }
      minMax[0] = Math.max(min, minMax[0]);
      return;
    } else if (index > m) {
      return;
    }
    for (int i = 0; i < positionList.size(); i++) {
      Integer i1 = positionList.get(i);
      positionList.remove(i1);
      list[index] = i1;
      maxDistance(positionList, m, index + 1, list, minMax);
      positionList.add(i1);
      Collections.sort(positionList);
    }
  }

  /**
   * 第二种方法
   *
   * @param position
   * @param m
   * @return
   */
  public int maxDistance2(int[] position, int m) {
    Arrays.sort(position);
    int[] result = new int[1];
    Arrays.fill(result, Integer.MIN_VALUE);
    maxDistance(position, m, 0, new int[m], 0, result);
    return result[0];
  }

  /**
   * 表示前index个球放在蓝子上的坐标点，第index+1放在哪里
   *
   * @param position                篮子的坐标点集合
   * @param m                       球的个数
   * @param index                   已经确定了index球的位置
   * @param plantingCoordinatePoint 保存有前index个球放在蓝色块上的坐标点（前面的篮球的坐标点一定小，优化效率）
   * @param pointIndex              第index+1球可以存放的后续索引
   * @param result                  存放的是所有摆放位置的最小间距的最大值
   */
  private void maxDistance(int[] position, int m, int index, int[] plantingCoordinatePoint,
      int pointIndex, int[] result) {
    if (index == m) {
      int min = Integer.MAX_VALUE;
      for (int i = 1; i < m; i++) {
        min = Math.min(min, plantingCoordinatePoint[i] - plantingCoordinatePoint[i - 1]);
      }
      result[0] = Math.max(min, result[0]);
      return;
    } else if (index > m) {
      return;
    }
    int pLen = position.length;
    for (int i = pointIndex; i < pLen; i++) {
      while (i < pLen && position[i] == 0) {
        i++;
      }
      if (i>=pLen) {
        return;
      }
      int p = position[i];
      position[i] = 0;
      plantingCoordinatePoint[index] = p;
      // index+2位置的球怎么放
      maxDistance(position, m, index + 1, plantingCoordinatePoint, i + 1, result);
      position[i] = p;
      plantingCoordinatePoint[index] = 0;
    }
  }


}
