package com.hz.arithmetic.lettcode.test75;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 拥有最多糖果的孩子
 *
 * @author zhenghui
 * @since 2023/9/5
 */
public class Solution1431 {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    List<Boolean> result = new LinkedList<>();
    int asInt = Arrays.stream(candies).max().getAsInt();
    for (int candy : candies) {
      if (candy+extraCandies>=asInt) {
        result.add(true);
      } else {
        result.add(false);
      }
    }
    return result;
  }
}
