package com.lyl.structure.tree;

import java.util.List;

/**
 * Created by lyl
 * Date 2019/8/5 20:22
 */
public class BinaryMain {
    public static void main(String[] args) {
        BinaryTreeNode a = new BinaryTreeNode(1);
        BinaryTreeNode b = new BinaryTreeNode(2);
        BinaryTreeNode c = new BinaryTreeNode(3);
        BinaryTreeNode d = new BinaryTreeNode(4);
        BinaryTreeNode e = new BinaryTreeNode(5);
        BinaryTreeNode f = new BinaryTreeNode(6);
        BinaryTreeNode g = new BinaryTreeNode(7);
        a.left = b;
        a.right = c;
        b.right = d;
        c.left = e;
        c.right = f;
        f.left = g;

        BinaryTree.recursiveInOrder(a);
    }
}
