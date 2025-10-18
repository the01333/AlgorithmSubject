package com.puxinxiaolin.algorithmsubject.leetcode.hot100;

public class NO_617 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }

    public static void main(String[] args) {
        NO_617 test = new NO_617();
        TreeNode n1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode n2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));
        TreeNode result = test.mergeTrees(n1, n2);
        TreeNode expected = new TreeNode(3, new TreeNode(4, new TreeNode(5), new TreeNode(4)), new TreeNode(5, null, new TreeNode(7)));
        System.out.println(isSameTree(result, expected));
        
        n1 = new TreeNode(1);
        n2 = new TreeNode(1, new TreeNode(2), null);
        result = test.mergeTrees(n1, n2);
        expected = new TreeNode(2, new TreeNode(2), null);
        System.out.println(isSameTree(result, expected));
    }

    private static boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }

}
