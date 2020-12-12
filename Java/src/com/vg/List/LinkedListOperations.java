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
//        System.out.println("Given Linked List : " + sl.toString());
//        sl.reverseSinglyLinkedList();
//        System.out.println("Linked List after reversing : " + sl.toString());
//        Node midNode = sl.getMiddleNode();
//        System.out.println("Mid node of SL is " + midNode.data);
//        System.out.println("Size of created SL is  " + sl.getSize());

        SinglyLinkedList vcList = new SinglyLinkedList();
//        mixed input
//        vcList.append("l");
//        vcList.append("a");
//        vcList.append("b");
//        vcList.append("c");
//        vcList.append("e");
//        vcList.append("m");
//        vcList.append("u");
//        Already Ordered Input
//        vcList.append("a");
//        vcList.append("e");
//        vcList.append("i");
//        vcList.append("o");
//        vcList.append("u");
//        vcList.append("t");

        vcList.append("a");
        vcList.append("e");
        vcList.append("i");
        vcList.append("t");
        vcList.append("m");
        vcList.append("u");
        llOps.arrangeVowelsFirstThenConsonants(vcList.head);

    }

    private boolean isVowel(String str) {
        return (str.equalsIgnoreCase("a") || str.equalsIgnoreCase("e") ||
            str.equalsIgnoreCase("i") || str.equalsIgnoreCase("o") ||
            str.equalsIgnoreCase("u"));
    }

    private void arrangeVowelsFirstThenConsonants(Node<String> head) {

        if(head == null) {
            System.out.println("Not Able to re-arrange as list is empty");
        }

        Node newHead = head;

        Node vowels = new Node("");

        Node curr = head;

        System.out.println("** List before re-arrange **");
        SinglyLinkedList.printSinglyLinkedList(newHead);

        if(isVowel(head.data)) {
            //If head element in Vowel
            vowels = head;
        }
        else {
//            We need to find first vowel element
            while (curr.next != null && !isVowel(String.valueOf(curr.next.data))) {
                curr = curr.next;
            }
//            Not able to find next vowel means wil be null as it reached the end
            if(curr.next == null) {
//                System.out.println("List already arranged");
                SinglyLinkedList.printSinglyLinkedList(head);
            }
//            SinglyLinkedList.printSinglyLinkedList(newHead);
            vowels = newHead = curr.next;
//            SinglyLinkedList.printSinglyLinkedList(vowels);
            curr.next = curr.next.next;
            vowels.next = head;
//            SinglyLinkedList.printSinglyLinkedList(vowels);
            System.out.println(curr.data);
        }

//        Once we find the First vowel in the list then need to link the remaining one
        while (curr != null && curr.next != null) {
            if(!isVowel(String.valueOf(curr.next.data))) {
                curr = curr.next;
            }else {
                if(curr == vowels) {
//                    System.out.println("Next element is Vowel..");
//                    SinglyLinkedList.printSinglyLinkedList(vowels);
//                    SinglyLinkedList.printSinglyLinkedList(curr);
                    vowels = curr = curr.next;
                }
                else {
                    Node temp = vowels.next;
                    vowels.next = curr.next;
                    curr.next = curr.next.next;
                    vowels = vowels.next;
                    vowels.next = temp;

//                    System.out.println("** List after one change ***");
//                    SinglyLinkedList.printSinglyLinkedList(vowels);
//                    SinglyLinkedList.printSinglyLinkedList(newHead);
                }
            }
        }
        System.out.println("** List after re-arrange **");
        SinglyLinkedList.printSinglyLinkedList(newHead);
    }

}
