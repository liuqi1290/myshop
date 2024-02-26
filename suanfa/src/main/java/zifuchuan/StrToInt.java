package zifuchuan;

public class StrToInt {
    /*    写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。传入的字符串可能有以下部分组成:
    1.若干空格
    2.（可选）一个符号字符（'+' 或 '-'）
    3. 数字，字母，符号，空格组成的字符串表达式
    4. 若干空格

    转换算法如下:
    1.去掉无用的前导空格
    2.第一个非空字符为+或者-号时，作为该整数的正负号，如果没有符号，默认为正数
    3.判断整数的有效部分：
    3.1 确定符号位之后，与之后面尽可能多的连续数字组合起来成为有效整数数字，如果没有有效的整数部分，那么直接返回0
    3.2 将字符串前面的整数部分取出，后面可能会存在存在多余的字符(字母，符号，空格等)，这些字符可以被忽略，它们对于函数不应该造成影响
    3.3  整数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231的整数应该被调整为 −231 ，大于 231 − 1 的整数应该被调整为 231 − 1
    4.去掉无用的后导空格*/
    public int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int sign = 1;
        int start = 0;
        // 去除前导空格
        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
        }
        // 判断符号位
        if (start < str.length() && str.charAt(start) == '+') {
            start++;
            return 0;
        }
        if (start < str.length() && str.charAt(start) == '-') {
            start++;
            sign = -1;
        }
        // 计算有效整数部分
        int result = 0;
        while (start < str.length() && str.charAt(start)>= '0' && str.charAt(start) <= '9'){
            int digit = str.charAt(start) - '0';
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                // 判断是否越界
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            start++;
        }
        // 返回结果
        return result * sign;

    }

    public static void main(String[] args) {
        char myChar = 'g';
        String myStr = Character.toString(myChar);
        System.out.println("String is: "+myStr);
        myStr = String.valueOf(myChar);
        System.out.println("String is: "+myStr);

    }
}
