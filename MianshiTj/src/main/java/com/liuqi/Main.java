package com.liuqi;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    // x offset y 求面积
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别// 注意 while 处理多个 case
        while (in.hasNext()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int e = in.nextInt();
            int x = 0;
            int y = 0;
            int pre=0;
            int maxX = 0;
            int result = 0;
            for (int i = 0; i <= n - 1; i++) {
                int temp = in.nextInt();

                int y1 = in.nextInt();
                if (i == n) {
                    x = e - temp;
                } else {
                    x = temp - pre;
                }
                pre=temp;
                y = y + y1;

                maxX = maxX + temp;
                if (maxX <= e) {
                    result += jiSuanmj(x, y);
                }
            }
            System.out.print(result);

        }

    }
    public static int  jiSuanmj(int x, int y) {
        return x * y;
    }
}


