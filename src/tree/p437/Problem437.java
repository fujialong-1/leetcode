package tree.p437;

import tree.TreeNode;

public class Problem437 {

    static int res = 0;

    public static int pathSum(TreeNode root, int targetSum) {
        return res;
    }

    public static void helper(TreeNode root, int targetSum) {
        if(root == null) return;
        if(root.val == targetSum) res++;
        helper(root.left, targetSum);
        helper(root.right, targetSum);
        helper(root.left, targetSum-root.val);
        helper(root.right, targetSum-root.val);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        System.out.println(pathSum(node, 10));
    }
}
