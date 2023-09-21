package com.hz.arithmetic.lettcode.test75;

import java.util.ArrayList;
import java.util.List;

/**
 * 股票价格跨度
 *
 * @author zhenghui
 * @since 2023/9/20
 */
public class StockSpanner {


  private final List<Integer> sharePrices;

  private final List<Integer> tmp;

  public StockSpanner() {
    sharePrices = new ArrayList<>();
    tmp = new ArrayList<>();
  }

  public int next(int price) {
    if (sharePrices.isEmpty()) {
      sharePrices.add(price);
      tmp.add(1);
      return 1;
    } else if (price < sharePrices.get(sharePrices.size() - 1)) {
      tmp.add(1);
      sharePrices.add(price);
      return 1;
    } else {
      Integer i = tmp.get(sharePrices.size() - 1);
      int index = sharePrices.size() - 1 - i;
      int sum = i + 1;
      while (index >= 0 && sharePrices.get(index) <= price) {
        sum++;
        index--;
      }
      tmp.add(sum);
      sharePrices.add(price);
      return sum;
    }
  }
}
