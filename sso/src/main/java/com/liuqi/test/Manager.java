package com.liuqi.test;

import java.util.Objects;

public class Manager extends Emploee {
    private  int bount;

    public int getBount() {
        return bount;
    }

    public void setBount(int bount) {
        this.bount = bount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return bount == manager.bount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bount);
    }

    public static void main(String[] args) {
     Manager manager  = new Manager();

     Emploee[] ee =new Emploee[3];

     ee[0]=manager;
     //managers[0].setBount(200);
    if(ee[1] instanceof Manager){
        Manager mm=(Manager)ee[1];
     }

    }

}
