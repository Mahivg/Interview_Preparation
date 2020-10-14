package com.vg.Tree;

import com.vg.model.TreeNode;

public class BTOperations {

    public static void main(String[] args) {
        BTOperations btOps = new BTOperations();

        TreeNode<Integer> root = new TreeNode<>(15);
        root.setLeft(new TreeNode(10));
        root.setRight(new TreeNode(20));
        root.getLeft().setLeft(new TreeNode(8));
        root.getLeft().getLeft().setLeft(new TreeNode(9));
        root.getLeft().getLeft().getLeft().setLeft(new TreeNode(11));
        root.getLeft().setRight(new TreeNode(12));
        root.getRight().setLeft(new TreeNode(16));
        root.getRight().setRight(new TreeNode(25));

        System.out.println("** Finding Height of Binary Tree ***");
        Integer height = btOps.findHeightOfBT(root);
        System.out.println("Height of Binary tree is " + height);
    }

    public Integer findHeightOfBT(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        return (1 + Math.max(findHeightOfBT(root.getLeft()), findHeightOfBT(root.getRight())));
    }
}

