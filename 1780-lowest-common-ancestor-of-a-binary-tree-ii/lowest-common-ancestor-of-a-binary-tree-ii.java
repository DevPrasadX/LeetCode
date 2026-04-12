class Solution {

    private TreeNode exists(TreeNode root, TreeNode target) {
        if (root == null) return null;
        if (root == target) return root;
        TreeNode left = exists(root.left, target);
        return left != null ? left : exists(root.right, target);
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left  = dfs(root.left,  p, q);
        TreeNode right = dfs(root.right, p, q);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (exists(root, p) == null || exists(root, q) == null) return null;
        return dfs(root, p, q);
    }
}