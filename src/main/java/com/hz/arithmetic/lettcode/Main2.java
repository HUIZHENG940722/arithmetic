package com.hz.arithmetic.lettcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * VLAN资源池
 *
 * @author zhenghui
 * @since 2023/9/13
 */
public class Main2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()) {
      // 输入资源池
      String[] split = sc.nextLine().trim().split(",");
      List<QJ> qjs = new ArrayList<>();
      for (String s : split) {
        if (s.contains("-")) {
          String[] split1 = s.trim().split("-");
          qjs.add(new QJ(Integer.parseInt(split1[0].trim()), Integer.parseInt(split1[1].trim())));
        } else {
          qjs.add(new QJ(Integer.parseInt(s.trim()), Integer.parseInt(s.trim())));
        }
      }
      // 申请资源池
      int zy = Integer.parseInt(sc.nextLine().trim());
      // 排序
      qjs.sort(new Comparator<QJ>() {
        @Override
        public int compare(QJ o1, QJ o2) {
          int val = o1.left - o2.left;
          if (val == 0) {
            return o1.right - o2.right;
          }
          return val;
        }
      });
      List<QJ> tmp = new LinkedList<>();
      // 整理区间
      int size = qjs.size(), index = 0;
      while (index < size) {
        int left = qjs.get(index).getLeft(), right = qjs.get(index).getRight();
        while (index + 1 < size && right > qjs.get(index + 1).getLeft()) {
          right = Math.max(right, qjs.get(index + 1).getRight());
          index++;
        }
        tmp.add(new QJ(left, right));
        index++;
      }
      // 删除申请的资源同时输出结果
      StringBuilder result = new StringBuilder();
      for (QJ qj : tmp) {
        if (zy >= qj.getLeft() && zy <= qj.getRight()) {
          QJ qj1 = new QJ(qj.left, zy - 1);
          QJ qj2 = new QJ(zy + 1, qj.right);
          if (qj1.left < qj1.right) {
            result.append(qj1.left).append("-").append(qj1.right).append(",");
          } else if (qj1.left == qj1.right) {
            result.append(qj1.left).append(",");
          }
          if (qj2.left < qj2.right) {
            result.append(qj2.left).append("-").append(qj2.right).append(",");
          } else if (qj2.left == qj2.right) {
            result.append(qj2.left).append(",");
          }
        } else {
          if (qj.getLeft() == qj.getRight()) {
            result.append(qj.getLeft()).append(",");
          } else {
            result.append(qj.getLeft()).append("-").append(qj.getRight()).append(",");
          }
        }
      }
      System.out.println(result.substring(0, result.length() - 1));
    }
  }

  private static class QJ {

    private int left;
    private int right;

    public QJ(int left, int right) {
      this.left = left;
      this.right = right;
    }

    public int getLeft() {
      return left;
    }

    public void setLeft(int left) {
      this.left = left;
    }

    public int getRight() {
      return right;
    }

    public void setRight(int right) {
      this.right = right;
    }
  }
}
