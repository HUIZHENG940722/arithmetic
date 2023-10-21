package com.hz.arithmetic.lettcode.test75;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/**
 * 字符串解码
 *
 * @author zhenghui
 * @since 2023/9/19
 */
public class Solution394 {

  public String decodeString1(String s) {
    int len = s.length(), index = 0;
    Deque<String> deque = new ArrayDeque<>();
    Queue<String> result = new ArrayDeque<>();
    Queue<Character> strQueue = new ArrayDeque<>();
    Queue<Character> numQueue = new ArrayDeque<>();
    while (index < len) {
      char c = s.charAt(index);
      if (c >= '0' && c <= '9') {
        numQueue.offer(c);
      } else if (c == '[') {
        if (!strQueue.isEmpty()) {
          StringBuilder tmp = new StringBuilder();
          while (!strQueue.isEmpty()) {
            tmp.append(strQueue.poll());
          }
          deque.push(tmp.toString());
        }
        if (!numQueue.isEmpty()) {
          StringBuilder tmp = new StringBuilder();
          while (!numQueue.isEmpty()) {
            tmp.append(numQueue.poll());
          }
          deque.push(tmp.toString());
        } else {
          deque.push("1");
        }
      } else if (c == ']') {
        if (!strQueue.isEmpty()) {
          StringBuilder tmp = new StringBuilder();
          while (!strQueue.isEmpty()) {
            tmp.append(strQueue.poll());
          }
          deque.push(tmp.toString());
        }
        List<String> list = new ArrayList<>();
        while (!deque.isEmpty() && deque.peek().matches("[a-zA-Z]+")) {
          String poll = deque.poll();
          list.add(0, poll);
        }
        StringBuilder sb = new StringBuilder();
        for (String string : list) {
          sb.append(string);
        }
        String str = sb.toString();
        int num = 1;
        if (!deque.isEmpty()) {
          num = Integer.parseInt(deque.poll());
        }
        sb.append(str.repeat(Math.max(0, num - 1)));
        if (deque.isEmpty()) {
          result.offer(sb.toString());
        } else {
          deque.push(sb.toString());
        }
      } else {
        strQueue.offer(c);
      }
      index++;
    }
    if (!strQueue.isEmpty()) {
      StringBuilder tmp = new StringBuilder();
      while (!strQueue.isEmpty()) {
        tmp.append(strQueue.poll());
      }
      deque.push(tmp.toString());
    }
    List<String> list = new ArrayList<>();
    while (!deque.isEmpty()) {
      String poll = deque.poll();
      list.add(0, poll);
    }
    StringBuilder res = new StringBuilder();
    for (String string : result) {
      res.append(string);
    }
    for (String string : list) {
      res.append(string);
    }
    return res.toString();
  }

  public String decodeString(String s) {
    int len = s.length(), index = 0;
    Deque<String> deque = new ArrayDeque<>();
    while (index < len) {
      char c = s.charAt(index);
      if (c == ']') {
        List<String> tmp = new ArrayList<>();
        while (!"[".equals(deque.peek())) {
          tmp.add(0, deque.poll());
        }
        deque.poll();
        StringBuilder sb = new StringBuilder();
        for (String string : tmp) {
          sb.append(string);
        }
        String str = sb.toString();
        int count = 1;
        if (!deque.isEmpty() && deque.peek().matches("\\d+")) {
          count = Integer.parseInt(deque.poll());
        }
        for (int i = 0; i < count - 1; i++) {
          sb.append(str);
        }
        deque.push(sb.toString());
      } else if (c >= '0' && c <= '9') {
        StringBuilder tmp = new StringBuilder();
        while (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
          tmp.append(s.charAt(index));
          index++;
        }
        index--;
        deque.push(tmp.toString());
      } else if (c == '[') {
        deque.push("[");
      } else {
        deque.push(String.valueOf(c));
      }
      index++;
    }
    StringBuilder result = new StringBuilder();
    while (!deque.isEmpty()) {
      result.append(deque.removeLast());
    }
    return result.toString();
  }
}
