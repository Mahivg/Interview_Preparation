package com.vg.List;

import com.vg.model.Node;

public class SinglyLinkedList {

    Node<String> head;

    public void append(String data) {
        if(head == null) {
            head = new Node(data);
            return;
        }
        tail().next = new Node(data);
    }

    public Node tail() {
        Node tail = head;

        while(tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    public static void printSinglyLinkedList(Node<String> headNode) {
        StringBuffer sb = new StringBuffer();
        Node current = headNode;
        if(current != null) {
            while (current != null) {
                sb.append(current.data.toString()).append("-->");
                current = current.next;
            }
            sb.delete(sb.length()-3, sb.length());
        }
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node current = head;
        if(current != null) {
            while (current != null) {
                sb.append(current.data.toString()).append("-->");
                current = current.next;
            }
            sb.delete(sb.length()-3, sb.length());
        }
        return sb.toString();
    }

    public void reverseSinglyLinkedList() {
        if(head == null || head.next == null) {
            return;
        }
        Node current = head;
        Node previous = null;
        Node forward = null;

        while (current != null) {
            forward = current.next;
            current.next = previous;
            previous = current;
            current = forward;
        }
        head = previous;
    }

    public Node getMiddleNode() {

        Node mid = head;
        Node current = head;
        int count = 0;

        while(current != null) {
            count++;
            if(count % 2 == 0) {
                mid = mid.next;
            }
            current = current.next;
        }
        return mid;
    }

    public Integer getSize() {

        Node current = head;
        int size = 0;

        if(current == null) {
            return 0;
        }

        while (current != null) {
            size++;
            current = current.next;
        }
          return size;
    }
}
