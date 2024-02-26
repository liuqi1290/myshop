package yanzhengmima;

import java.util.Scanner;

public class Main {
    /*描述密码要求:
    1.长度超过8位
    2.包括大小写字母.数字.其它符号,以上四种至少三种
    3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行） 数据范围：输入的字符串长度满足
    1≤n≤100
    如果符合要求输出：OK，否则输出NG
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            //长度超过8位
            if (s.length() < 9) {
                System.out.println("NG");
                continue;
            }
            //  注：字符串中特殊符号不含空格或换行
            if (s.contains(" ") || s.contains("\n")){
                System.out.println("NG");
                continue;
            }
            //包括大小写字母.数字.其它符号,以上四种至少三种
            boolean[] flag = new boolean[4];
            for (char c : s.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    flag[0] = true;
                }
                if (Character.isLowerCase(c)) {
                    flag[1] = true;
                }
                if (Character.isDigit(c)) {
                    flag[2] = true;
                }
                if (!Character.isLetterOrDigit(c)) {
                    flag[3] = true;
                }
            }
            int count = 0;
            for (boolean b : flag) {
                if (b) {
                    count++;
                }
            }
            if (count < 3) {
                System.out.println("NG");
                continue;
            }

            //  不能有长度大于2的包含公共元素的子串重复
            for (int i = 0; i < s.length() - 3; i++) {
                if (s.substring(i+3).contains(s.substring(i, i+3))){
                    System.out.println("NG");
                }
            }
            System.out.println("OK");

        }
    }
}

