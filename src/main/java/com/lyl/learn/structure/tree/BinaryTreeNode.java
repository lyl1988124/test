package com.lyl.learn.structure.tree;

/**
 * Created by lyl
 * Date 2019/8/5 20:12
 */
public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode [data=" + data + ", left=" + left + ", right=" + right
                + "]";
    }
}

