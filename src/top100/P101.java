package top100;

import tree.TreeNode;

public class P101 {
    public static void main(String[] args) {

    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetricTwo(root.left, root.right);
    }
    boolean isSymmetricTwo(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        } else if(left == null && right != null) {
            return false;
        } else if(left != null && right == null) {
            return false;
        } else {
            return left.val == right.val && isSymmetricTwo(left.left, right.right) && isSymmetricTwo(left.right, right.left);
        }
    }
}
