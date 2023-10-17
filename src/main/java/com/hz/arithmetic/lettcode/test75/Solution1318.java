package com.hz.arithmetic.lettcode.test75;

/**
 * 或运算的最小翻转次数
 *
 * @author zhenghui
 * @since 2023/9/24
 */
public class Solution1318 {

  public static void main(String[] args) {
    int a = 2, b = 6, c = 5;
    int i = minFlips(a, b, c);
    System.out.println(i);
  }

  public static int minFlips(int a, int b, int c) {
    String aS = new StringBuilder(Integer.toBinaryString(a)).reverse()
        .toString(), bS = new StringBuilder(Integer.toBinaryString(
        b)).reverse().toString(), cS = new StringBuilder(Integer.toBinaryString(c)).reverse()
        .toString();
    int result = 0, len = Math.max(Math.max(aS.length(), bS.length()), cS.length());
    for (int i = 0; i < len; i++) {
      int indexA = i < aS.length() ? aS.charAt(i) - '0' : 0, indexB =
          i < bS.length() ? bS.charAt(i) - '0' : 0, indexC =
          i < cS.length() ? cS.charAt(i) - '0' : 0;
      if ((indexA | indexB) != indexC) {
        if (indexA != indexB) {
          result++;
        } else if (indexA == 1) {
          result += 2;
        } else {
          result++;
        }
      }
    }
    return result;
  }

  public static int minFlips2(int a, int b, int c) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
      int bitA = (a >> i) & 1, bitB = (b >> i) & 1, bitC = (c >> i) & 1;
      if ((bitA | bitB) != bitC) {
        if (bitA != bitB) {
          result++;
        } else if (bitA == 1) {
          result += 2;
        } else {
          result++;
        }
      }
    }
    return result;
  }
}
