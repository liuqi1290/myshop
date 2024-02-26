package iptonum;

import java.util.Scanner;

public class Main {
    // 如果输入的是整数则转换为ip,否则将IPv4地址 ipAddress 转换为整数
/* 示例：
输入：
10.0.3.193
167969729
输出：
167773121
10.3.3.193*/
    public static void main(String[] args) {
        System.out.println("请输入一个IP地址");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String ipAddress = scanner.nextLine();
            if (ipAddress.contains(".")) {
                System.out.println(ipToLong(ipAddress));
            } else {
                System.out.println(longToIP(ipAddress));
            }
        }
    }

    /*
      将整数形式的IP地址转换为点分十进制形式
     */
    private static String longToIP(String ipAddress) {
        if (ipAddress.contains(".")) {
            return ipAddress;
        }
        // 将整数形式转换为点分十进制形式
        long aLong = Long.parseLong(ipAddress);
        StringBuilder sb = new StringBuilder();
        sb.append(aLong >>> 24).append(".");
        sb.append((aLong & 0xFFFFFF) >>> 16).append(".");
        sb.append((aLong & 0xFFFF) >>> 8).append(".");
        sb.append(aLong & 0xFF);
        return sb.toString();
    }

    /*
      将点分十进制形式的IP地址转换为整数形式
     */
    private static String ipToLong(String ipAddress) {
        if (!ipAddress.contains(".")) {
            return ipAddress;
        }
        // 将点分十进制形式转换为整数形式
        String[] parts = ipAddress.split("\\.");
        long result = 0;
        for (int i = 0; i < parts.length; i++) {
            result |= (Long.parseLong(parts[i]) << (24 - (i * 8)));

        }
        return String.valueOf(result);
    }
}
