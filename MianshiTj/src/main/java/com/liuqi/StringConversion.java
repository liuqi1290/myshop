package com.liuqi;

import java.util.Scanner;

public class StringConversion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取参数K
        int K = scanner.nextInt();
        scanner.nextLine(); // 消耗掉换行符

        // 读取字符串S
        String S = scanner.nextLine();

        // 关闭Scanner
        scanner.close();

        // 调用转换方法并输出结果
        String result = convertString(S, K);
        System.out.println(result);
    }

    private static String convertString(String s, int k) {
        String[] substrings = s.split("-");
        StringBuilder result = new StringBuilder(substrings[0]);

        for (int i = 1; i < substrings.length; i++) {
            String currentSubstring = substrings[i];
            if(currentSubstring.length() > 0){
                result.append("-");
            }
            StringBuilder newSubstring = new StringBuilder();

            for (int j = 0; j < currentSubstring.length(); j += k) {
                int endIndex = Math.min(j + k, currentSubstring.length());
                String subStringChunk = currentSubstring.substring(j, endIndex);

                // 计算大小写字母数量
                int uppercaseCount = 0;
                int lowercaseCount = 0;
                for (char c : subStringChunk.toCharArray()) {
                    if (Character.isUpperCase(c)) {
                        uppercaseCount++;
                    } else if (Character.isLowerCase(c)) {
                        lowercaseCount++;
                    }
                }

                // 根据条件进行大小写转换
                if (uppercaseCount > lowercaseCount) {
                    newSubstring.append(subStringChunk.toUpperCase());
                } else if (uppercaseCount < lowercaseCount) {
                    newSubstring.append(subStringChunk.toLowerCase());
                } else {
                    newSubstring.append(subStringChunk);
                }

                // 添加分隔符
                if (endIndex < currentSubstring.length()) {
                    newSubstring.append("-");
                }
            }

            // 将新的子串添加到结果中
            result.append(newSubstring);
        }

        return result.toString();
    }
}
