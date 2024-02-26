package com.liuqi;
/*
给定一个非空字符串S，其被N个‘-’分隔成N+1的子串，给定正整数K，要求除第一个子串外，
其余的子串每K个字符组成新的子串，并用‘-’分隔。对于新组成的每一个子串，如果它含有的小写字母比大写字母多，
则将这个子串的所有大写字母转换为小写字母；反之，如果它含有的大写字母比小写字母多，
则将这个子串的所有小写字母转换为大写字母；大小写字母的数量相等时，不做转换
示例1
输入
3
12abc-abCABc-4aB@
输出
12abc-abc-ABC-4aB-@
*/

public class Text {
    public static void main(String[] args) {
        String s = "12abc-abCABc-4aB@";
        StringBuilder sb = new StringBuilder();
        int k = 3;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                sb.append(' ');
            } else {
                if (count % k == 0) {
                    sb.append(s.charAt(i));
                } else {
                    if (Character.isLowerCase(s.charAt(i))) {
                        sb.append(Character.toUpperCase(s.charAt(i)));
                    } else {
                        sb.append(Character.toLowerCase(s.charAt(i)));
                    }
                }
                count++;
            }
            if (i == s.length() - 1) {
                sb.append('-');
            }
            System.out.print(sb.toString());
            sb.setLength(0);
            count = 0;

        }
    }

}
