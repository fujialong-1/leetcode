package tree.p94;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem94 {

    public static void main(String[] args) {


    }

}


class Solution {

    // 中序遍历·递归
    /*public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        inorder(root, result);
        return result;
    }

    void inorder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }*/

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        // 节点自身和它的右子树都没有被访问到的节点地址
        Stack<TreeNode> s = new Stack<>();

        TreeNode cur = root;

        while (cur != null || !s.isEmpty()) {

            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }

            cur = s.peek();
            s.pop();
            result.add(cur.val);

            cur = cur.right;

        }

        return result;


        /*while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;*/
    }
}

