package com.lyl.structure.tree;

/**
 * Created by lyl
 * Date 2019/2/18 17:38
 */
public class TreeNode<T> {
    T value;

    TreeNode<T> leftChild;
    TreeNode<T> rightChild;

    public TreeNode() {
    }

    public TreeNode(T value) {
        this.value = value;
    }

    public void addLeft(T value){
        TreeNode<T> node = new TreeNode<>(value);
        this.leftChild = node;
    }

    public void addRight(T value){
        TreeNode<T> node = new TreeNode<>(value);
        this.rightChild = node;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof TreeNode))
            return false;
        return this.value.equals(((TreeNode) obj).value);
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    public String toString() {
        return this.value==null? "" : this.value.toString();
    }

}
