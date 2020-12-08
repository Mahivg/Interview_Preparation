package com.vg;

import com.vg.Tree.BinaryTreeImplementation;
import com.vg.inheritance.Circle;
import com.vg.inheritance.Shape;
import com.vg.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here for testing
//        Default file

        System.out.println(10 * 20 + " java");

        Shape shape = new Circle();
        shape.draw();

        List<Integer> myIntegerList = Arrays.asList(1,2,3,4,5,6);
        myIntegerList.stream().forEach(System.out::println);

        BinaryTreeImplementation<String> bts = new BinaryTreeImplementation<>();
        bts.setRoot(new TreeNode<String>("1"));

        bts.getRoot().setLeft(new TreeNode("2"));
        bts.getRoot().getLeft().setLeft(new TreeNode("3"));

        bts.getRoot().getLeft().setRight(new TreeNode("4"));

        bts.getRoot().setRight(new TreeNode("5"));
        bts.getRoot().getRight().setRight(new TreeNode("6"));

/**
 * * input:
 *    1
 *   / \
 *  2   5
 * / \   \
 * 3  4   6
 *
 *
 */

        System.out.println("*** Pre order traversal Node, Left, Right***");
        bts.preOrderTraversal();
//        bts.preOrderWithoutRecursion(bts.getRoot());

        System.out.println("*** In order traversal Left, Node, Right ***");
        bts.inOrderTraversal();
//        bts.inOrderTraversal(bts.getRoot());

        System.out.println("*** Post order traversal Left, Right, Node ***");
        bts.postOrderTraversal();
//        bts.postOrderTraversal(bts.getRoot());

    }
}
