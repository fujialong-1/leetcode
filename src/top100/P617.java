package top100;

import tree.TreeNode;

public class P617 {
    public static void main(String[] args) {

    }
    // 合并二叉树
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return null;
        } else if(root1 != null && root2 == null) {
            return root1;
        } else if(root1 == null && root2 != null) {
            return root2;
        } else {
            TreeNode newNode = new TreeNode(root1.val + root2.val);
            TreeNode newLeft = mergeTrees(root1.left, root2.left);
            TreeNode newRight = mergeTrees(root1.right, root2.right);
            newNode.left = newLeft;
            newNode.right = newRight;
            return newNode;
        }
    }
}
