package com.liuqi;

public class StringUtil {

    public static String convert(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int maxLength = 10; // 定长格式为10位
        StringBuilder result = new StringBuilder();

        for (String str : strs) {
            result.append(leftAlign(str, maxLength));
        }

        return result.toString();
    }

    // 左靠齐，右边不满10位补空格
    private static String leftAlign(String str, int length) {
        StringBuilder paddedStr = new StringBuilder(str);
        int padding = Math.max(0, length - str.length());
        for (int i = 0; i < padding; i++) {
            paddedStr.append(' '); // 补充空格
        }
        return paddedStr.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"Hello", "World", "Java"};

        String result = convert(strings);
        System.out.println(result);
    }
}
