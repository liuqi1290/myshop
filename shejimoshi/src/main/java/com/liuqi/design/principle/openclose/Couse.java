package com.liuqi.design.principle.openclose;

public class Couse {
    private String name;
    private int id;
    private long price;

    public Couse() {
    }

    public Couse(String name, int id, long price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
