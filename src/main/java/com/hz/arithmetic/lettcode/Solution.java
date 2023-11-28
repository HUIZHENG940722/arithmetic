package com.hz.arithmetic.lettcode;

import java.util.Comparator;
import java.util.List;

/**
 * URL编码
 *
 * @author zhenghui
 * @since 2023/11/28
 */
public class Solution {

  /**
   * @param baseUrl:         the string of base_url
   * @param queryParamsList: sequence of two-element tuples by query_params
   * @return: return a url query string
   */
  public String urlencode(String baseUrl, List<List<String>> queryParamsList) {
    // write your code.
    // 先排序
    queryParamsList.sort(new Comparator<List<String>>(){
      @Override
      public int compare(List<String> o1, List<String> o2) {
        return o1.get(0).compareTo(o2.get(0));
      }
    });
    StringBuilder result = new StringBuilder(baseUrl);
    result.append("?");
    for (List<String> list : queryParamsList) {
      result.append(list.get(0)).append("=").append(list.get(1)).append("&");
    }
    result.deleteCharAt(result.length()-1);
    return result.toString();
  }
}
