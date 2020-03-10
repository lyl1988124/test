package com.lyl.leetcode;

/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 二叉树的根是数组中的最大元素。左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * 示例 ：
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *       6
 *    /   \
 *    3     5
 *    \    /
 *     2  0  
 *        \
 *         1
 */
class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int value) { this.value = value; }
}

public class MaxBinaryTree {
    
    public TreeNode buildMaxBinaryTree(int[] param) {
        //检验参数
        if(null == param || param.length == 0) {
            return null;
        }
        return maxBinaryTree(param, 0, param.length - 1);
    }
    
    private TreeNode maxBinaryTree(int[] nums, int start, int maxIdx){
        if(start > maxIdx){
            return null;
        }

        //索取最大索引
        int max = Integer.MIN_VALUE, maxIndex = start;
        for(int i = start; i <= maxIdx; i++){
            if(max < nums[i]){
                max = nums[i];
                maxIndex = i;
            }
        }
        int idx = maxIndex;
        
        TreeNode root = new TreeNode(nums[idx]);
        root.left = maxBinaryTree(nums, start, idx - 1);
        root.right = maxBinaryTree(nums, idx + 1, maxIdx);
        return root;
    }

    
    public static void main(String[] args) {
        MaxBinaryTree mbt = new MaxBinaryTree();
        System.out.println(mbt.buildMaxBinaryTree(new int[] {3,2,1,6,0,5}).value);
        System.out.println(mbt.buildMaxBinaryTree(new int[] {}));
    }
}
