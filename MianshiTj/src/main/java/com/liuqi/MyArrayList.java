package com.liuqi;

public class MyArrayList {
    private int[] array;
    private int size;

    public MyArrayList() {
        array = new int[10];
        size = 0;
    }


    public void add(int value) {
        if (size == array.length) {
            // 数组已满，需要增加容量
            int[] newArray = new int[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size++] = value;
    }

    public int get(int index) {
        return array[index];
    }

    public int size() {
        return size;
    }

    public void set(int index, int value) {
        if (0 > index || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        for (int i = array.length - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
    }

    public void update(int index, int value) {
        if (0 > index || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        array[index] = value;
    }

    public void remove(int index) {
        if (0 > index || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }
}
