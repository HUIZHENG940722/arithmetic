package com.hz.arithmetic.niuke.huawei;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 明明的随机数
 *
 * @author zhenghui
 * @since 2023/9/7
 */
public class HJ3 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()) {
      int n = sc.nextInt();
      Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
          return o1 - o2;
        }
      });

      for (int i = 0; i < n; i++) {
        set.add(sc.nextInt());
      }
      for (Integer i : set) {
        System.out.println(i);
      }
    }
  }
}
