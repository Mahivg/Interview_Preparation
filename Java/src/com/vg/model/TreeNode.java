package com.vg.model;

public class TreeNode<T> {

    private T data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(T value) {
        this.data = value;
        left = right = null;
    }

    boolean isLeaf() {
        return (left == null && right == null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
