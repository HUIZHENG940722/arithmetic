package com.hz.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhenghui
 * @since 2023/9/13
 */
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()) {
      // 适合种植树的数量
      int num = Integer.parseInt(sc.nextLine().trim());
      // 适合种植树的坐标点
      List<Integer> kzz = new ArrayList<>();
      String s = sc.nextLine().trim();
      String[] split = s.split("\\s+");
      for (int i = 0; i < num; i++) {
        kzz.add((Integer.parseInt(split[i].trim())));
      }
      // 树数量
      int sms = Integer.parseInt(sc.nextLine().trim());
      // 也就是把数组jj分成num分
      int[] max = new int[1];
      hs(kzz, sms, 0, new int[sms], max);
      System.out.println(max[0]);
    }
  }

  /**
   * @param kzz   种植点
   * @param sms   树苗数
   * @param index 种了多少
   * @param zsz   真实中的点
   * @param max   结果值
   */
  private static void hs(List<Integer> kzz, int sms, int index, int[] zsz, int[] max) {
    if (index >= sms) {
      Arrays.sort(zsz);
      int m = Integer.MAX_VALUE;
      for (int i = 1; i < sms; i++) {
        m = Math.min(m, zsz[i] - zsz[i - 1]);
      }
      max[0] = Math.max(m, max[0]);
      return;
    }
    List<Integer> tmp = new ArrayList<>();
    Collections.copy(kzz, tmp);
    for (Integer i : kzz) {
      zsz[index] = i;
      tmp.remove(i);
      hs(tmp, sms, index + 1, zsz, max);
      tmp.add(i);
    }
  }
}
