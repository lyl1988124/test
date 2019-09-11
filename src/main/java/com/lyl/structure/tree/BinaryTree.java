package com.lyl.structure.tree;

import java.util.Stack;

/**
 * Created by lyl
 * Date 2019/8/5 20:23
 */
public class BinaryTree {

    /**
     * 前序
     * @param node
     */
    public static void recursivePreOrder(BinaryTreeNode node){
        if(null == node){
            return;
        }
        print(node);
        recursivePreOrder(node.left);
        recursivePreOrder(node.right);
    }

    public static void recursiveInOrder(BinaryTreeNode node){
        if(null == node){
            return;
        }
        recursiveInOrder(node.left);
        print(node);
        recursiveInOrder(node.right);
    }

    private static void print(BinaryTreeNode p) {
        System.out.print(p.data + " ");
    }

    //**********非递归的先序遍历**********
    //手算的思想，先变访问边找，找到最左下方的，然后向上再向访问右边的
    public static void iterativePreOrder(BinaryTreeNode p) {
        if(p == null){
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        while(!stack.empty() || p!=null){
            while(p!=null){
                p=p.left;

            }


        }
    }
}
