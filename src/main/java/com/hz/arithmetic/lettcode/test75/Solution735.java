package com.hz.arithmetic.lettcode.test75;

import java.util.Stack;

/**
 * 行星碰撞
 *
 * @author zhenghui
 * @since 2023/9/17
 */
public class Solution735 {

  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    for (int asteroid : asteroids) {
      if (asteroid < 0) {
        if (stack.isEmpty()) {
          stack.push(asteroid);
        } else {
          Integer peek = stack.peek();
          if (peek < 0) {
            stack.push(asteroid);
          } else if (peek > 0) {
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid + stack.peek() < 0) {
              stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() > 0 && asteroid + stack.peek() == 0) {
              stack.pop();
            } else if (stack.isEmpty()) {
              stack.push(asteroid);
            } else if (stack.peek() < 0) {
              stack.push(asteroid);
            }
          }
        }
      } else if (asteroid > 0) {
        if (stack.isEmpty()) {
          stack.push(asteroid);
        } else {
          if (stack.peek() > 0) {
            stack.push(asteroid);
          } else if (stack.peek() < 0) {
            stack.push(asteroid);
          }
        }
      }
    }
    return stack.stream().mapToInt(Integer::intValue).toArray();
  }

  /**
   * 对栈结构性能进行优化
   *
   * @param asteroids
   * @return
   */
  public int[] asteroidCollision2(int[] asteroids) {
    int[] tmp = new int[asteroids.length];
    int size = 0;
    for (int asteroid : asteroids) {
      if (asteroid < 0) {
        if (size == 0) {
          tmp[size++] = asteroid;
        } else {
          while (size > 0 && tmp[size - 1] > 0 && tmp[size - 1] + asteroid < 0) {
            size--;
          }
          if (size == 0) {
            tmp[size++] = asteroid;
          } else if (tmp[size - 1] < 0) {
            tmp[size++] = asteroid;
          } else if (tmp[size - 1] + asteroid == 0) {
            size--;
          }
        }
      } else {
        tmp[size++] = asteroid;
      }
    }
    int[] result = new int[size];
    System.arraycopy(tmp, 0, result, 0, size);
    return result;
  }

}
