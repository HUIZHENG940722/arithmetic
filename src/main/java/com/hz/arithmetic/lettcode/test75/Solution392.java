package com.hz.arithmetic.lettcode.test75;

/**
 * 判断子序列
 *
 * @author zhenghui
 * @since 2023/9/9
 */
public class Solution392 {

  public static void main(String[] args) {
    String s = "aaaaaa", t = "bbaaaa";
    boolean subsequence = isSubsequence(s, t);
    System.out.println(subsequence);
  }
  public static boolean isSubsequence(String s, String t) {
    int i = 0, j = 0, lenI = s.length(), lenJ = t.length();
    if (lenI == 0) {
      return true;
    }
    while (j < lenJ) {
      char c = s.charAt(i);
      while (j < lenJ && t.charAt(j) != c) {
        j++;
      }
      if (j < lenJ) {
        i++;
        j++;
      }
      if (i == lenI) {
        break;
      }
    }
    return i >= lenI;
  }
}
