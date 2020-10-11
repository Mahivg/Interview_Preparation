package com.vg.List;

import com.vg.model.Node;

public class LinkedListOperations {

    public static void main(String[] args) {

        LinkedListOperations llOps = new LinkedListOperations();
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.append("A");
        sl.append("B");
        sl.append("C");
        sl.append("D");
        sl.append("E");
        System.out.println("Given Linked List : " + sl.toString());
        sl.reverseSinglyLinkedList();
        System.out.println("Linked List after reversing : " + sl.toString());
        Node midNode = sl.getMiddleNode();
        System.out.println("Mid node of SL is " + midNode.data);

        System.out.println("Size of created SL is  " + sl.getSize());

    }

}
