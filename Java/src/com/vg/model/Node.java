package com.vg.model;

public class Node<T> {
    public Node next;
    public T data;

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
