package tree.p144;

import tree.TreeNode;

import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.util.*;

public class Problem144 {

    public static void main(String[] args) {


        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        List<Integer> list = Solution.preorderTraversal(t1);

        for (int item : list) {
            System.out.println(item);
        }




    }

}


class Solution {


    // 前序遍历·递归
    /*public static List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        preOrder(root, result);
        return result;
    }

    public static void preOrder(TreeNode root, ArrayList<Integer> result) {

        // 递归终止条件
        if (root == null) {
            return;
        }
        // 前序遍历指的是根节点位置在前面，所以先把根节点加进去
        result.add(root.val);
        System.out.println(root.val);
        // 再前序遍历左子树
        preOrder(root.left, result);
        // 再前序遍历右子树
        preOrder(root.right, result);
    }*/

    // 迭代
    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        // 定义两个指针，指向当前节点的指针和指向栈顶的指针
        TreeNode cur, top;

        cur = root;

        // 栈中元素都是自己和自己的左孩子都访问过了，而右孩子还没有访问到的节点
        Stack<TreeNode> s = new Stack<>();

        while (cur != null || !s.isEmpty()) {

            while (cur != null) {
                //System.out.println(cur.val);
                result.add(cur.val);
                s.push(cur);
                cur = cur.right;
            }

            top = s.peek();
            s.pop();

            cur = top.left;
        }

        Collections.reverse(result);

        return result;

        /*List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;*/
    }
}
