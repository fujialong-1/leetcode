package tree.p102;

import tree.TreeNode;

import java.util.*;

public class Problem102 {
    public static void main(String[] args) {

    }
}

class Solution {

    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        //checkFun01(root,0);
        checkFun02(root);

        return resList;
    }

    //DFS--递归方式
    public void checkFun01(TreeNode node, Integer deep) {

        // 递归结束条件
        if (node == null) return;

        // 要做的事情
        deep++;

        if (resList.size() < deep) {
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }

        // 在对应的层加上节点
        resList.get(deep-1).add(node.val);

        // 调用自己
        checkFun01(node.left, deep);
        checkFun01(node.right, deep);



        /*if (node == null) return;
        deep++;

        if (resList.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }
        resList.get(deep - 1).add(node.val);

        checkFun01(node.left, deep);
        checkFun01(node.right, deep);*/
    }

    //BFS--迭代方式--借助队列
    public void checkFun02(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();
            int len = que.size();

            for (int i = 0; i < len; i++) {
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);

                if (tmpNode.left != null) que.offer(tmpNode.left);
                if (tmpNode.right != null) que.offer(tmpNode.right);
            }

            /*while (len > 0) {
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);

                if (tmpNode.left != null) que.offer(tmpNode.left);
                if (tmpNode.right != null) que.offer(tmpNode.right);
                len--;
            }*/

            resList.add(itemList);
        }
    }

    // 637. 二叉树的层平均值
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> resList = new ArrayList<Double>();
        if(root == null) return resList;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        while(!que.isEmpty()) {
            int len = que.size();
            double sum = 0.0;
            for(int i = 0; i < len; i++) {
                TreeNode node = que.poll();
                sum += node.val;
                if(node.left != null) que.offer(node.left);
                if(node.right != null) que.offer(node.right);
            }
            resList.add(sum/len);
        }
        return resList;
    }
}
