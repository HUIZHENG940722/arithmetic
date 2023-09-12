package com.hz.arithmetic.niuke;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 明明的随机数
 *
 * @author zhenghui
 * @since 2023/9/10
 */
public class Main2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1 - o2;
      }
    });
    while (sc.hasNextInt()) {
      int n = sc.nextInt();
      for (int i = 0; i < n; i++) {
        set.add(sc.nextInt());
      }
      for (Integer i : set) {
        System.out.println(i);
      }
    }
  }
}
