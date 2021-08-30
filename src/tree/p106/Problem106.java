package tree.p106;

import tree.TreeNode;

public class Problem106 {
    public static void main(String[] args) {


        int[] a1 = {2, 1};
        int[] a2 = {2, 1};
        TreeNode node = buildTree(a1, a2);

    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        // 通过后序遍历的结果，可以找到根节点，就是最后一个节点的值
        TreeNode root = newBuildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        return root;
    }

    public static TreeNode newBuildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if(inStart == inEnd) return new TreeNode(inorder[inStart]);
        if(inStart > inEnd) return null;
        // 1、通过后序遍历的结果找到根节点
        TreeNode root = new TreeNode(postorder[postEnd]);
        // 在inorder中找到根节点的位置，即下标
        int index = inStart;
        while(inorder[index] != root.val) {
            index++;
        }
        TreeNode left = newBuildTree(inorder, inStart, index-1, postorder, postStart, postStart + index - inStart - 1);
        TreeNode right = newBuildTree(inorder, index+1, inEnd, postorder, postStart + index - inStart + 1, postEnd-1);
        root.left = left;
        root.right = right;
        return root;
    }
}
