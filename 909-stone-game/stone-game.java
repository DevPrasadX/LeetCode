class Solution {
    public boolean stoneGame(int[] piles) {
        Integer dp[][] = new Integer[piles.length][piles.length];

        // return solve(piles, 0, piles.length-1,dp) >0;
        return true;
    }

    public int solve(int[] nums, int left,int right, Integer[][] dp){

        if(left==right){
            return nums[left];
        }

        if(dp[left][right]!=null){
            return dp[left][right];
        }

        int leftAns = nums[left] - solve(nums, left+1,right, dp );
        int rightAns = nums[right] - solve(nums, left, right-1, dp);

        dp[left][right] = Math.max(leftAns, rightAns);

        return dp[left][right];

    }

}