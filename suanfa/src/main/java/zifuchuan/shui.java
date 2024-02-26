package zifuchuan;

import java.util.Scanner;

public class shui {
    /*某商店规定：三个空汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶（但是必须要归还）。
    小张手上有n个空汽水瓶，她想知道自己最多可以喝到多少瓶汽水。*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int n = scanner.nextInt();
            if(n<=1)return;
            int sum = 0;
            while (n >= 3) {
                if (n == 1) {
                    return;
                }
                sum += n / 3;
                n = n / 3 + n % 3;
                if (n == 2) {
                    n = n + 1;
                }
            }
            System.out.println(sum);
        }
    }
}
