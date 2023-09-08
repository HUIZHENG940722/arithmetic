package com.hz.arithmetic.lettcode.test75;

/**
 * 压缩字符串
 *
 * @author zhenghui
 * @since 2023/9/8
 */
public class Solution443 {

  public int compress(char[] chars) {
    int len = chars.length, i = 0, j = 0;
    StringBuilder sb = new StringBuilder();
    while (i < len) {
      char c = chars[i];
      int sum = 1;
      while (i + 1 < len && c == chars[i + 1]) {
        i++;
        sum++;
      }
      chars[j++] = c;
      sb.append(c);
      if (sum != 1) {
        sb.append(sum);
        char[] charArray = String.valueOf(sum).toCharArray();
        for (char c1 : charArray) {
          chars[j++] = c1;
        }
      }
      i++;
    }
    while (j<len) {
      chars[j++]='\0';
    }
    return sb.length();
  }
}
