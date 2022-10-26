package com.ethan.course.lettcode.huawei;

/**
 * @Author zhenghui
 * @Description Z字形变换
 * @Date 2022/10/26
 */
public class Solution6 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String convert = convert(s, numRows);
        System.out.println(convert);
    }

    public static String convert(String s, int numRows) {
        // 找规律，可以把字符串每(numRows-1)*2个拼装相同的图形
        // 则行数numRows，设置数组长度为len，则列数为len%((numRows-1)*2)==0?(len/((numRows-1)*2))*(numRows-1):(len/((numRows-1)*2)+1)*(numRows-1)
        // 建立数组，按照以上规律把字符串填充到数组里面，之后输入
        if (numRows < 1) {
            return null;
        } else if (numRows == 1) {
            return s;
        }
        // 计算数组列数
        int len = s.length();
        int n = len % ((numRows - 1) * 2) == 0 ? (len / ((numRows - 1) * 2)) * (numRows - 1)
            : (len / ((numRows - 1) * 2) + 1) * (numRows - 1);
        String[][] results = new String[numRows][n];
        int j = 0;
        for (int index = 0; index < len; ) {
            int i = 0;
            for (; i < numRows - 1 && index < len; i++, index++) {
                results[i][j] = String.valueOf(s.charAt(index));
            }
            for (; i > 0 && j < n && index < len; j++, i--, index++) {
                results[i][j] = String.valueOf(s.charAt(index));
            }
        }
        StringBuilder result = new StringBuilder();
        for (String[] strings : results) {
            for (String string : strings) {
                if (string!=null) {
                    result.append(string);
                }
            }
        }
        return result.toString();
    }
}

