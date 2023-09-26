package com.hz.arithmetic.lettcode.test75;

/**
 * 多米诺和拖米诺平铺
 *
 * @author zhenghui
 * @since 2023/9/24
 */
public class Solution790 {

  public static void main(String[] args) {

  }

  static final int MOD = 1000000007;

  public int numTilings(int n) {
    //return f(n);
    return (int) (f1(n) % MOD);
  }

  private int f(int n) {
    if (n == 1) {
      return 1;
    } else if (n == 2) {
      return 2;
    } else if (n == 3) {
      return 5;
    }
    return f(n - 1) + f(n - 2) + 2 * s(n - 1);
  }

  private int s(int n) {
    if (n == 1) {
      return 0;
    } else if (n == 2) {
      return 1;
    } else if (n == 3) {
      return 2;
    }
    return f(n - 2) + s(n - 1);
  }

  private long f1(long n) {
    if (n == 1) {
      return 1;
    } else if (n == 2) {
      return 2;
    } else if (n == 3) {
      return 5;
    }
    return f1(n - 1) + f1(n - 2) + 2 * s1(n - 1);
  }

  private long s1(long n) {
    if (n == 1) {
      return 0;
    } else if (n == 2) {
      return 1;
    } else if (n == 3) {
      return 2;
    } else if (n == 4) {
      return 4;
    }
    return 2 * s1(n - 1) + s1(n - 3);
  }

  public int numTilings1(int n) {
    if (n == 1) {
      return 1;
    } else if (n == 2) {
      return 2;
    } else if (n == 3) {
      return 5;
    }
    int s1 = 1, s2 = 2, s = 0, f1 = 1, f2;
    for (int i = 4; i <= n; i++) {
      s = (s2 + s1 + 2 * f1) % MOD;
      f2 = (s1 + f1) % MOD;
      s1 = s2;
      s2 = s;
      f1 = f2;
    }
    return s;
  }
}
