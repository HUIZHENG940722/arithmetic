package com.hz.arithmetic.lettcode.test75;

/**
 * Dota2参议院
 *
 * @author zhenghui
 * @since 2023/9/19
 */
public class Solution649 {

  public String predictPartyVictory1(String senate) {
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

  public String predictPartyVictory(String senate) {
    char[] charArray = senate.toCharArray();
    /**
     * rSum 表示r方存活的人员
     * dSum 表示d方存活人员
     * rForbid 表示后续环节需要干掉d方人员数
     * dForbid 表示后续环节需要干掉r方人员数
     */
    int rSum = 0, dSum = 0, len = charArray.length, index = 0, rForbid = 0, dForbid = 0;
    for (char c : charArray) {
      if (c == 'R') {
        rSum++;
      }
    }
    dSum = len - rSum;
    while (dSum > 0 && rSum > 0) {
      char c = charArray[index % len];
      if (c == 'R') {
        if (dForbid > 0) {
          dForbid--;
          charArray[index % len] = '0';
        } else {
          rForbid++;
          dSum--;
        }
      } else if (c == 'D') {
        if (rForbid > 0) {
          rForbid--;
          charArray[index % len] = '0';
        } else {
          dForbid++;
          rSum--;
        }
      }
      index++;
    }
    if (dSum == 0) {
      return "Radiant";
    }
    return "Dire";
  }
}
