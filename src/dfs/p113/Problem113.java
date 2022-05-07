package dfs.p113;

import tree.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Problem113 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("1");
        set.remove("1");
        System.out.println(set.size());

    }

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    void dfs(TreeNode root, int target) {
        if(root == null) return;
        path.add(root.val);
        // 终止条件
        if(root.left == null && root.right == null) {
            if(root.val == target) {
                res.add(new LinkedList<>(path));
                return;
            }
        }
        if(root.left != null) {
            dfs(root.left, target - root.val);
            path.removeLast();
        }
        if(root.right != null) {
            dfs(root.right, target - root.val);
            path.removeLast();
        }
    }
}
