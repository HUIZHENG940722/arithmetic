package com.ethan.course.lettcode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhenghui
 * @Description 可被三整除的偶数的平均值
 * @Date 2022/10/31
 */
public class Solution2455 {
    public int averageValue(int[] nums) {
        List<Integer> results = new ArrayList<>();
        for (int num : nums) {
            if (num % 3 == 0 && num % 2 == 0) {
                results.add(num);
            }
        }
        if (results.size() == 0) {
            return 0;
        }
        int sum = 0;
        for (Integer result : results) {
            sum += result;
        }
        return sum / results.size();
    }
}
