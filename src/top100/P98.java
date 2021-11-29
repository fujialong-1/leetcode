package top100;

import tree.TreeNode;

public class P98 {
    public static void main(String[] args) {

    }
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    // 重要的是这两个参数如何想到min和max
    // min表示root节点应该大于的最小值，max表示root节点应该小于的最大值
    boolean validate(TreeNode node, long min, long max) {
        if(node == null) {
            return true;
        }
        if(node.val <= min || node.val >= max) {
            return false;
        }
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}
