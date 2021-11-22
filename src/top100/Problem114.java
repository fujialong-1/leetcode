package top100;

import tree.TreeNode;

public class Problem114 {
    public static void main(String[] args) {

    }

    // 做树类的递归问题，不要去想左右子节点如何实现的函数，直接对左右子节点用就行了
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left != null) {
            // 找到最后一个节点
            TreeNode last = left;
            while(last.right != null) {
                last = last.right;
            }
            last.right = right;
            root.left = null;
            root.right = left;
        }
    }
}
