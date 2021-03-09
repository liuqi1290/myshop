package com.liuqi.design.principle.openclose;

public class JavaCouse implements BaseCouse {

    @Override
    public String getCurName(Couse couse) {
        return couse.getName();
    }

    @Override
    public int getCurId(Couse couse) {
        return couse.getId();
    }

    @Override
    public long getCurPrice(Couse couse) {
        return couse.getPrice();
    }
}
