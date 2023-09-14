package com.hz.arithmetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhenghui
 * @since 2023/9/13
 */
public class Main3 {

  public static void main(String[] args) {
    List<People> ages = new ArrayList<>();
    ages.add(new People(3));
    ages.add(new People(5));
    ages.add(new People(4));
    ages.sort(new Comparator<People>(

    ) {
      @Override
      public int compare(People o1, People o2) {
        return 0;
      }

      @Override
      public boolean equals(Object obj) {
        return false;
      }
    });
    System.out.println(ages);
  }

  private static class People implements Comparable<People> {
    int age;

    public People(int age) {
      this.age = age;
    }

    @Override
    public int compareTo(People o) {
      return this.age- o.age;
    }
  }
}
