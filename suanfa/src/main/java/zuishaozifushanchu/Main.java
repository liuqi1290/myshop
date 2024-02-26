package zuishaozifushanchu;

import java.util.Scanner;

/**
 * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 *
 * 数据范围：输入的字符串长度满足  1≤n≤20  ，保证输入的字符串中仅出现小写字母
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();

            int min = 100;
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }

            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0 && count[i] < min) {
                    min = count[i];
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (count[str.charAt(i) - 'a'] == min) {
                    result.append(' ');
                } else {
                    result.append(str.charAt(i));
                }
            }

            System.out.println(result.toString().replaceAll("\\s+", ""));
        }
    }
}
