package com.hz.arithmetic.lettcode;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author zhenghui
 * @since 2023/11/25
 */
public class Main {

  public static void main(String[] args) {
    int[] arr = new int[]{5, 4, 2, 3, 1};
//    mergeSort(arr);
    merge_sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void mergeSort(int[] arr) {
    int len = arr.length;
    int[] result = new int[len];
    int block, start;
    for (block = 1; block < len; block *= 2) {
      System.arraycopy(arr, 0, result, 0, len);
      for (start = 0; start < len; start += 2 * block) {
        int low = start, mid = Math.min((start + block), len), high =
            Math.min((start + 2 * block), len);
        int start1 = low, end1 = mid, start2 = mid, end2 = high;
        while (start1 < end1 && start2 < end2) {
          arr[low++] = result[start1] < result[start2] ? result[start1++] : result[start2++];
        }
        while (start1 < end1) {
          arr[low++] = result[start1++];
        }
        while (start2 < end2) {
          arr[low++] = result[start2++];
        }
      }
    }
  }

  public static void merge_sort(int[] arr) {
    int len = arr.length;
    int[] result = new int[len];
    merge_sort_recursive(arr, result, 0, len - 1);
  }

  static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
    if (start >= end) {
      return;
    }
    int len = end - start, mid = (len >> 1) + start;
    int start1 = start, end1 = mid;
    int start2 = mid + 1, end2 = end;
    merge_sort_recursive(arr, result, start1, end1);
    merge_sort_recursive(arr, result, start2, end2);
    int k = start;
    System.arraycopy(arr, start, result, start, end - start + 1);
    while (start1 <= end1 && start2 <= end2) {
      arr[k++] = result[start1] < result[start2] ? result[start1++] : result[start2++];
    }
    while (start1 <= end1) {
      arr[k++] = result[start1++];
    }
    while (start2 <= end2) {
      arr[k++] = result[start2++];
    }
  }
}
