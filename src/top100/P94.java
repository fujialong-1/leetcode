package top100;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class P94 {
    // 定义一个类的成员变量
    List<Integer> res = new LinkedList<>();
    public static void main(String[] args) {

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return res;
    }
    // 构造一个返回值为空的辅助函数
    void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
}
