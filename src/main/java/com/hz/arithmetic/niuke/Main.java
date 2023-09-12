package com.hz.arithmetic.niuke;

import java.util.Scanner;

/**
 * 汽水瓶
 *
 * @author zhenghui
 * @since 2023/9/10
 */
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()) {
      int n = sc.nextInt();
      if (n==0) {
        break;
      }
      System.out.println(n/2);
    }
  }
}
