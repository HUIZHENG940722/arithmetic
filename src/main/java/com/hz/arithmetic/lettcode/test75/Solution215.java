package com.hz.arithmetic.lettcode.test75;

import java.util.Arrays;

/**
 * 数组中的第K个最大元素
 *
 * @author zhenghui
 * @since 2023/10/10
 */
public class Solution215 {

  public int findKthLargest1(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
  }

  /**
   * 快速排序
   *
   * @param nums
   * @param k
   * @return
   */
  public int findKthLargest2(int[] nums, int k) {
    int i = quickSelect(nums, 0, nums.length - 1, nums.length - k);
    return i;
  }

  /**
   * 快速排序
   *
   * @param nums
   * @param l
   * @param r
   * @return
   */
  private int quickSelect(int[] nums, int l, int r, int k) {
    int i = l, j = r;
    while (i < j) {
      while (i < j && nums[j] > nums[i]) {
        j--;
      }
      if (j > i) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
        i++;
      }
      while (i < j && nums[i] < nums[j]) {
        i++;
      }
      if (j > i) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
        j--;
      }
    }
    if (i == k) {
      return nums[i];
    } else if (k > i) {
      return quickSelect(nums, i + 1, r, k);
    } else {
      return quickSelect(nums, l, i - 1, k);
    }
  }

  public int findKthLargest(int[] nums, int k) {
    int heapSize = nums.length;
    buildMaxHeap(nums, heapSize);
    for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
      swap(nums, 0, i);
      --heapSize;
      maxHeapify(nums, 0, heapSize);
    }
    return nums[0];
  }


  private void buildMaxHeap(int[] a, int heapSize) {
    for (int i = heapSize/2; i>=0;i--) {
      maxHeapify(a, i, heapSize);
    }
  }

  private void maxHeapify(int[] a, int i, int heapSize) {
    int l = 2*i+1, r= 2*i+2, largest = i;
    if (l<heapSize && a[l]>a[largest]) {
      largest = l;
    }
    if (r<heapSize && a[r]>a[largest]) {
      largest = r;
    }
    if (largest!=i) {
      swap(a, i, largest);
      maxHeapify(a, largest, heapSize);
    }
  }

  private void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
