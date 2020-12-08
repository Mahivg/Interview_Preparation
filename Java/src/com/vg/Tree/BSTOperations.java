package com.vg.Tree;

import com.vg.model.TreeNode;

public class BSTOperations {
    public static void main(String[] args) {
        System.out.println("*** Binary Search Tree Operations ***");

        BSTOperations bstOps = new BSTOperations();

        TreeNode<Integer> bst1 = new TreeNode(15);
        bst1.setLeft(new TreeNode(10));
        bst1.setRight(new TreeNode(20));
        bst1.getLeft().setLeft(new TreeNode(8));
        bst1.getLeft().setRight(new TreeNode(12));
        bst1.getRight().setLeft(new TreeNode(16));
        bst1.getRight().setRight(new TreeNode(25));

        /**
         *      15
         *    / \
         *   10     20
         *  / \   /  \
         * 8   12 16   25
         *
         */

        System.out.println("*** Check Binary Tree is Binary Search Tree ***");
        boolean isBST = bstOps.checkBTisBST(bst1);
        System.out.println("Given BST is " + (isBST ? "Valid BST": "Not valid BST"));

        TreeNode<Integer> bst2 = new TreeNode(15);
        bst2.setLeft(new TreeNode(10));
        bst2.setRight(new TreeNode(20));
        bst2.getLeft().setLeft(new TreeNode(8));
        bst2.getLeft().setRight(new TreeNode(12));
        bst2.getRight().setLeft(new TreeNode(16));
        bst2.getRight().setRight(new TreeNode(25));


        boolean isIdentical = bstOps.checkBSTIsIdentical(bst1, bst2);
        System.out.println("BST is " + ( isIdentical ? "Identical" : "Not Identical" ));

    }

    private boolean checkBTisBST(TreeNode<Integer> bst) {
//        return isBSTorNot(bst,Integer.MIN_VALUE, Integer.MAX_VALUE);
        return isBSTorNot(bst,Integer.MIN_VALUE);
    }

    private boolean isBSTorNot(TreeNode<Integer> bst, int minValue) {
        if(bst == null) {
            return true;
        }
        boolean left = isBSTorNot(bst.getLeft(), minValue);
        if(bst.getData() <= minValue) {
            return false;
        }
        minValue = bst.getData();

        return left && isBSTorNot(bst.getRight(),minValue);
    }

    private boolean isBSTorNot(TreeNode<Integer> bst, int minValue, int maxValue) {
        if(bst == null) {
            return true;
        }
        if(bst.getData()< minValue || bst.getData() > maxValue) {
            return false;
        }
        return (isBSTorNot(bst.getLeft(),minValue, bst.getData()) &&
                isBSTorNot(bst.getRight(), bst.getData(), maxValue));
    }

    private boolean checkBSTIsIdentical(TreeNode<Integer> bst1, TreeNode<Integer> bst2) {

        if (bst1 == null && bst2 == null) {
            return true;
        }
        return ((bst1 != null && bst2 != null)
                && bst1.getData().equals(bst2.getData())
                && checkBSTIsIdentical(bst1.getLeft(),bst2.getLeft())
                && checkBSTIsIdentical(bst1.getRight(),bst2.getRight()));
    }
}
