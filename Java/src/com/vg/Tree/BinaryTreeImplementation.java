package com.vg.Tree;

import com.vg.model.TreeNode;

import java.util.Stack;

public class BinaryTreeImplementation<T> {

    TreeNode<T> root;

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    public void preOrderTraversal() {
        preOrder(root);
    }

    public void preOrderTraversal(TreeNode node) {
        preOrder(node);
    }

    /**
     * Node, Left Node and then Right Node (NLR)
     * @param node
     */
    private void preOrder(TreeNode node) {

        if(node == null) {
            return;
        }
        System.out.println("Node : " + node.getData());
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    public void preOrderWithoutRecursion() {
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);

        while(!nodes.isEmpty()) {
            TreeNode current = nodes.pop();

            System.out.println("Node : " + current.getData());
//            Since it is a stack pushing right first, then left. while popping left will come out first
            if(current.getRight() != null) {
                nodes.push(current.getRight());
            }
            if(current.getLeft() != null) {
                nodes.push(current.getLeft());
            }
        }
    }

    public void preOrderWithoutRecursion(TreeNode<T> node) {
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(node);

        while(!nodes.isEmpty()) {
            TreeNode current = nodes.pop();

            System.out.println("Node : " + current.getData());
//            Since it is a stack pushing right first, then left. while popping left will come out first
            if(current.getRight() != null) {
                nodes.push(current.getRight());
            }
            if(current.getLeft() != null) {
                nodes.push(current.getLeft());
            }
        }
    }

    public void inOrderTraversal() {
        inOrder(root);
    }

    public void inOrderTraversal(TreeNode<T> node) {
        inOrder(node);
    }

    private void inOrder(TreeNode<T> node) {
        if(node == null) {
            return;
        }
        inOrder(node.getLeft());
        System.out.println("Node : " + node.getData());
        inOrder(node.getRight());
    }

    public void postOrderTraversal(){
        postOrder(root);
    }

    public void postOrderTraversal(TreeNode<T> root){
        postOrder(root);
    }

    private void postOrder(TreeNode<T> node) {
        if(node == null) {
            return;
        }
        inOrder(node.getLeft());
        inOrder(node.getRight());
        System.out.println("Node : " + node.getData());
    }

}
