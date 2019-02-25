package com.lyl.structure.tree;

/**
 * Created by lyl
 * Date 2019/2/18 20:14
 */
public class TreeTest {
    public static void main(String[] args) {
        TreeNode<Integer> t = new TreeNode<Integer>(1);
        t.addLeft(2);
        t.addRight(3);
        t.leftChild.addLeft(4);
        t.leftChild.addRight(5);

        System.out.println(TreeTools.getTreeNum(t));
    }
}
