package com.liuqi;

import javax.security.auth.Refreshable;
import java.math.BigDecimal;

public class FeeCalculator {
    //计算费用
    public static BigDecimal calculateFee(BigDecimal amount) {
        // 实现费率计算逻辑
        BigDecimal rate = getRateByAmountRange(amount);
        BigDecimal scale = amount.multiply(rate).setScale(0, BigDecimal.ROUND_HALF_UP);
        return adjustFee(scale);
    }
    // 根据金额范围获取费率
    public static BigDecimal getRateByAmountRange(BigDecimal amount) {
        if(amount.compareTo(new BigDecimal("5000000"))<=0){
            return new BigDecimal("0.008");
        }else if(amount.compareTo(new BigDecimal("25000000"))<=0){
            return new BigDecimal("0.007");   }
        else if( amount.compareTo(new BigDecimal("50000000"))<=0){
            return new BigDecimal("0.006");   }
        else {
            return new BigDecimal("0.005");
        }
     }
     //调整费用
     public static BigDecimal adjustFee(BigDecimal fee) {
        if(fee.compareTo(new BigDecimal("100"))<0){
           return  new BigDecimal("100");
        }else if(fee.compareTo(new BigDecimal("10000"))>0){
           return  new BigDecimal("10000");
        }else{
           return fee;
        }
     }
    private static void testFeeCalculation(BigDecimal amount) {
        BigDecimal fee = calculateFee(amount);
        System.out.println("Amount: " + amount + ", Fee: " + fee);
    }
    /*
    5、	给一个字符串，返回第一个重复的字符的位置，如果字符串为空或没有重复的字符就返回-1；其他返回字符所在的位置，起始位置为0
     */
    public static void main(String[] args) {
        String str = "abbcdeafg";
        Integer index = getInteger(str);
        if (index == null) return;
        System.out.println(index);
        //testFeeCalculation(new BigDecimal("577000"));
    }

    private static Integer getInteger(String str) {
        int index = -1;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    index = j;
                    return index;
                }
            }
        }
        return index;
    }
}
