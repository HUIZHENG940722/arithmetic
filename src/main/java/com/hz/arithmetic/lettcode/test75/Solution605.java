package com.hz.arithmetic.lettcode.test75;

/**
 * 种花问题
 *
 * @author zhenghui
 * @since 2023/9/5
 */
public class Solution605 {

    public static void main(String[] args) {
        int[] flowerbed = new int[] {1, 0, 0, 0, 1};
        boolean b = canPlaceFlowers(flowerbed, 1);
        System.out.println("b = " + b);
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size = flowerbed.length, index = 0;
        while (index < size) {
            // 表示零的个数
            int sum = 0;
            if (index == 0) {
                sum = 1;
            }
            while (index < size && flowerbed[index] == 0) {
                sum++;
                index++;
                if (sum == 3) {
                    break;
                }
            }
            if (sum == 3) {
                n--;
                index = index - 2;
                flowerbed[index] = 1;
            }
            if (index == size && sum == 2) {
                n--;
                index--;
                flowerbed[index] = 1;
            }
            sum = 0;
            index++;
        }
        return n <= 0;
    }
}
