package com.hz.arithmetic.lettcode.test75;

/**
 * Dota2参议院
 *
 * @author zhenghui
 * @since 2023/9/19
 */
public class Solution649 {

  public String predictPartyVictory(String senate) {
    int len = senate.length();
    char[] charArray = senate.toCharArray();
    int index = 0, radiantNum = 0, dire = 0;
    while (true) {
      if (!success(charArray).isEmpty()) {
        return success(charArray);
      }
      char c = charArray[index % len];
      if (c == 'R') {
        if (radiantNum < 0) {
          charArray[index % len] = ' ';
          radiantNum++;
        } else {
          dire--;
        }
      } else if (c == 'D') {
        if (dire < 0) {
          charArray[index % len] = ' ';
          dire++;
        } else {
          radiantNum--;
        }
      }
      index++;
    }
  }

  private String success(char[] chars) {
    StringBuilder sb = new StringBuilder();
    for (char aChar : chars) {
      if (aChar != ' ') {
        sb.append(aChar);
      }
    }
    if (!sb.toString().contains("R")) {
      return "Dire";
    } else if (!sb.toString().contains("D")) {
      return "Radiant";
    }
    return "";
  }
}
