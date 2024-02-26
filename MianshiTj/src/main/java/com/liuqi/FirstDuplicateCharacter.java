package com.liuqi;

import java.util.HashMap;

public class FirstDuplicateCharacter {
    public static int firstDuplicatePosition(String s) {
        if (s == null || s.isEmpty()) {
            return -1; // 字符串为空，返回-1
        }

        HashMap<Character, Integer> charIndexMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 如果字符已经在哈希表中存在，则表示找到了第一个重复的字符
            if (charIndexMap.containsKey(c)) {
                return charIndexMap.get(c);
            }

            // 否则，将字符及其位置加入哈希表
            charIndexMap.put(c, i);
        }

        return -1; // 没有重复字符，返回-1
    }

    public static void main(String[] args) {
        String input1 = "abcdefg";
        String input2 = "leettclode";
        String input3 = "hello";
        
        System.out.println(firstDuplicatePosition(input1)); // 输出 -1，无重复字符
        System.out.println(firstDuplicatePosition(input2)); // 输出 1，'e'是第一个重复字符
        System.out.println(firstDuplicatePosition(input3)); // 输出 2，'l'是第一个重复字符
    }
}
