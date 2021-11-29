package top100;

import tree.TreeNode;

public class P124 {
    public static void main(String[] args) {

    }
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    //明确函数作用，即返回子树一端的的最大和
    public int dfs(TreeNode root){
        //base case
        if(root == null) return 0;

        //divide
        // 如果子树路径和为负则应当置0，表示最大路径不包含子树
        // dfs(root.left) 根节点 + 左子树的和
        // dfs(root.right) 根节点 + 右子树的和
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        // 判断在该节点包含左右子树的路径和是否大于当前最大路径和
        maxSum = Math.max(maxSum, root.val + left + right);

        // 返回大的那个节点作为一端 + 根节点的值，即路径和大到边
        // 如 [1,2,3] -> 子节点为[2,3]，路径选3
        return Math.max(left, right) + root.val;
    }
}
