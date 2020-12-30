package _09_danh_sach.bai_tap.array_list;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }

    public void display() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(elements[i] + " ");
        }
    }
    public  E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }
    public E remove(int index) {
        E a = (E) elements[index];
        for (int i = index; i < size; i++){
            elements[i] = elements[i + 1];
        }
        elements[size-1] = null;
        size--;
        return a;
    }
 public int size(){
        return this.size;
 }

}