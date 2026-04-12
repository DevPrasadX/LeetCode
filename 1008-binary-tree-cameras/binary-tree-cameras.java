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
    int count = 0;
    public int solve(TreeNode root)
    {
        if(root==null)
        {
            return 1;
        }
        int left= solve(root.left);
        int right = solve(root.right);

        if(right==0 || left==0)
        {
            count++;
            return 2;
        }

        if(right==2 || left==2)
        {
          return 1;
        }
        return 0;
    }
    public int minCameraCover(TreeNode root) {
     if(solve(root)==0)
     {
        count++;
     }
     return count;
    }
}