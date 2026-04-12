/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private boolean pFound = false;
    private boolean qFound = false;

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root == p) pFound = true;
        if (root == q) qFound = true;

        TreeNode left  = dfs(root.left,  p, q);
        TreeNode right = dfs(root.right, p, q);

        // Return self AFTER searching subtrees (catches q inside p's subtree)
        if (root == p || root == q) return root;

        if (left != null && right != null) return root;

        return left != null ? left : right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pFound = false;
        qFound = false;

        TreeNode result = dfs(root, p, q);

        if (!pFound || !qFound) return null;

        return result;
    }
}