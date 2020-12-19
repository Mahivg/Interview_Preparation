package com.vg.DSImplementation;

import java.util.Arrays;

public class MyArrayList<T> {

    private Integer size = 0;
    private final Integer INITIAL_CAPACITY = 10;

    private Object[] elements;

    public MyArrayList() {
        this.elements = new Object[INITIAL_CAPACITY];
    }

    public MyArrayList(Integer initialCapacity) {
        this.elements = new Object[initialCapacity];
    }

    public T get(Integer index) {

        if(index < 0 || index > elements.length) {
            throw new IndexOutOfBoundsException("Invalid Index : " + index);
        }
        return (T) elements[index];
    }

    public void add(T elem) {
        ensureCapacity(size + 1);
        elements[size++] = elem;
    }

    private void ensureCapacity(Integer sizeToCheck) {
        int oldCapacity = elements.length;
        if(sizeToCheck >= oldCapacity) {
            Integer newCapacity = (oldCapacity * 3) / 2 + 1;
            if(newCapacity < oldCapacity) {
                newCapacity = oldCapacity;
            }
            this.elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    public T remove(Integer index) {
        if(index < 0 || index > elements.length) {
            throw new IndexOutOfBoundsException("Invalid Index : " + index);
        }
        Object obj = elements[index];
        if(obj != null) {
            if(elements.length - 1 > index) {
                System.arraycopy(elements, index+1, elements, index,elements.length - 1 - index);
            }
            elements[elements.length - 1] = null;
            size--;
            return (T) obj;
        }
        return null;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T set(Integer index, T elem) {
        if(index < 0 || index > elements.length) {
            throw new IndexOutOfBoundsException("Invalid Index : " + index);
        }
        Object oldValue = this.elements[index];
        this.elements[index] = elem;
        return (T) oldValue;
    }

    public Integer size() {
        return this.elements.length;
    }

}
