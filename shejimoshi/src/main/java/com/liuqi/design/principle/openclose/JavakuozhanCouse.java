package com.liuqi.design.principle.openclose;

import javafx.util.converter.BigDecimalStringConverter;

import java.math.BigDecimal;

public class JavakuozhanCouse extends JavaCouse {
    public long dazheprice(long price){
        BigDecimal decimal = BigDecimal.valueOf((long) (price * 0.8));
        return decimal.longValue();
    }

    @Override
    public long getCurPrice(Couse couse) {
        return dazheprice(super.getCurPrice(couse));
    }


}
