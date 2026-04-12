/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result = 0;
    void helperFunction(TreeNode node, int currMax, int currMin)
    {
        if(node==null)
        {
            return;
        }
        int possibleResult = Math.max(Math.abs(currMax-node.val), Math.abs(currMin-node.val));
        // 5,-5
        // possible result = 5;
        result = Math.max(possibleResult,result);
        // 8,8,8
        currMax = Math.max(currMax,node.val);
        currMin = Math.min(currMin, node.val);//3
        helperFunction(node.left,currMax,currMin);
        // 3,8,8
        helperFunction(node.right,currMax,currMin);
        return;
    }
    public int maxAncestorDiff(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        result = 0;
        helperFunction(root, root.val, root.val);
        return result;
        
        
    }
}