package com.hz.arithmetic.niuke.huawei;

import java.util.Scanner;

/**
 * 求int型整数在内存中存储1的个数
 *
 * @author zhenghui
 * @since 2023/9/7
 */
public class HJ15 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()) {
      int num = sc.nextInt();
      String binaryString = Integer.toBinaryString(num);
      int size = binaryString.length(), count = 0;
      for (int i = 0; i < size; i++) {
        if (binaryString.charAt(i) == '1') {
          count++;
        }
      }
      System.out.println(count);
    }
  }
}
