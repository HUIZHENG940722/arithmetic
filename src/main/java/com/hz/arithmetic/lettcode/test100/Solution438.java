package com.hz.arithmetic.lettcode.test100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 *
 * @author zhenghui
 * @since 2023/11/14
 */
public class Solution438 {

  public static void main(String[] args) {
    String s = "abab", p = "ab";
    List<Integer> anagrams = findAnagrams(s, p);
    System.out.println(anagrams);
  }

  public static List<Integer> findAnagrams(String s, String p) {
    int lenP = p.length(), lenS = s.length(), left = 0, right = lenP;
    List<Integer> result = new ArrayList<>();
    while (right <= lenS) {
      if (isAnagrams(s.substring(left, right), p)) {
        result.add(left);
      }
      left++;
      right++;
    }
    return result;
  }

  private static boolean isAnagrams(String s, String p) {
    int lenS = s.length(), lenP = p.length();
    if (lenS != lenP) {
      return false;
    }
    char[] charArray = s.toCharArray();
    char[] charArray1 = p.toCharArray();
    Arrays.sort(charArray1);
    Arrays.sort(charArray);
    for (int i = 0; i < lenS; i++) {
      if (charArray[i] != charArray1[i]) {
        return false;
      }
    }
    return true;
  }

  public List<Integer> findAnagrams2(String s, String p) {
    int lenS = s.length(), lenP = p.length();
    if (lenS<lenP) {
      return new ArrayList<>();
    }
    List<Integer> result = new ArrayList<>();
    int[] sCount = new int[26], pCount = new int[26];
    for (int i = 0; i < lenP; i++) {
      ++sCount[s.charAt(i)-'a'];
      ++pCount[p.charAt(i)-'a'];
    }
    if (Arrays.equals(sCount, pCount)) {
      result.add(0);
    }
    for (int i = 0; i < lenS - lenP; i++) {
      --sCount[s.charAt(i)-'a'];
      ++sCount[s.charAt(i+lenP)-'a'];
      if (Arrays.equals(sCount, pCount)) {
        result.add(i+1);
      }
    }
    return result;
  }
}
