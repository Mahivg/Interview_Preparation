package com.vg.DSImplementation;

import java.util.EmptyStackException;

public class MyStack<T> {

    private Integer TOP;
    private Integer INITIAL_CAPACITY = 16;
    private Integer COUNT;
    private T[] stack;

    public MyStack() {
        TOP = -1;
        COUNT = 0;
        stack = (T[]) new Object[INITIAL_CAPACITY];
    }

    public MyStack(int capacity) {
        TOP = -1;
        COUNT = 0;
        stack = (T[]) new Object[capacity];
    }

    public void push(T data) {
        stack[++TOP] = data;
    }

    public T pop() {
        if(TOP <= 0) {
            throw new EmptyStackException();
        }
        T elem = stack[TOP--];
        return elem;
    }
    public T peek() {
        if(TOP <= 0) {
            throw new EmptyStackException();
        }
        T elem = stack[TOP];
        return elem;
    }
    public boolean isEmpty() {
        return (TOP == 0);
    }

    public Integer size() {
        if(TOP < 0) {
            return 0;
        }
        return TOP;
    }
}
