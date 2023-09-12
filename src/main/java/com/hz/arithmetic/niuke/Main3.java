package com.hz.arithmetic.niuke;

import java.util.Scanner;

/**
 * 进制转换
 *
 * @author zhenghui
 * @since 2023/9/10
 */
public class Main3 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      String str = sc.nextLine().trim();
      int i = Integer.parseInt(str.substring(2), 16);
      System.out.println(i);
    }
  }
}
