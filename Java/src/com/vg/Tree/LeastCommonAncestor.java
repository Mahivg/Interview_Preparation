package com.vg.Tree;

import com.sun.source.tree.Tree;
import com.vg.model.TreeNode;

public class LeastCommonAncestor {

    public static void main(String[] args) {
        BinaryTreeImplementation bst = new BinaryTreeImplementation();

        bst.setRoot(new TreeNode<>(7));
        bst.getRoot().setLeft(new TreeNode(4));

        bst.getRoot().getLeft().setLeft(new TreeNode(2));
        bst.getRoot().getLeft().setRight(new TreeNode(6));

        bst.getRoot().setRight(new TreeNode(10));
        bst.getRoot().getRight().setLeft(new TreeNode(8));
        bst.getRoot().getRight().setRight(new TreeNode(11));

        /**
         *      7
         *    / \
         *   4     10
         *  / \   /  \
         * 2   6 8   11
         *
         */

        int nodeValue1 = 8;
        int nodeValue2 = 11;

        TreeNode<Integer> parent = findLeastCommonAncestor(bst.getRoot(), nodeValue1, nodeValue2);

        System.out.println("Least Common Ancestor : " + parent.getData());
    }

    private static TreeNode<Integer> findLeastCommonAncestor(TreeNode<Integer> root, int nodeValue1, int nodeValue2) {

        /**
         *      7
         *    / \
         *   4     10
         *  / \   /  \
         * 2   6 8   11
         *
         */
        TreeNode<Integer> lca = root;

        if(root == null || ( root.getRight() == null && root.getLeft() == null) ) {
            return null;
        }
        if(root.getData() > nodeValue1 && root.getData() > nodeValue2) {
            lca = root.getLeft();
            findLeastCommonAncestor(root.getLeft(), nodeValue1, nodeValue2);
        }
        if(root.getData() < nodeValue1 && root.getData() < nodeValue2) {
            lca = root.getRight();
            findLeastCommonAncestor(root.getRight(), nodeValue1, nodeValue2);
        }
        return lca;

    }
}
