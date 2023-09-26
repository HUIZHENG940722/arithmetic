package com.hz.arithmetic.lettcode.test75;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 找出两数组的不同
 *
 * @author zhenghui
 * @since 2023/9/26
 */
public class Solution2215 {

  public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();
    for (int i : nums1) {
      set1.add(i);
    }
    for (int i : nums2) {
      set2.add(i);
    }
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> ans1 = new ArrayList<>();
    for (Integer i : set1) {
      if (!set2.contains(i)) {
        ans1.add(i);
      }
    }
    ans.add(ans1);
    List<Integer> ans2 = new ArrayList<>();
    for (Integer i : set2) {
      if (!set1.contains(i)) {
        ans2.add(i);
      }
    }
    ans.add(ans2);
    return ans;
  }
}
