package com.lyl.structure.tree;

/**
 * Created by lyl
 * Date 2019/2/18 20:03
 */
public class TreeTools {

    public void visitNode(TreeNode node){
        System.out.println(node.value+"\t");
    }

    public static <T> int getTreeNum(TreeNode root){
        if(root == null){
            return 0;
        }
        return getTreeNum(root.leftChild)+getTreeNum(root.rightChild)+1;
    }


}
