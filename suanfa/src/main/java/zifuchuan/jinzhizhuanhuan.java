package zifuchuan;

public class jinzhizhuanhuan {
/*
    写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
*/
    public static void main(String[] args) {
        String hexString = "0xAA";
        int decimal = Integer.parseInt(hexString.substring(2), 16);
        System.out.println("十进制表示：" + decimal);


    }
}

