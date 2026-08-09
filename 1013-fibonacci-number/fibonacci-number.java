class Solution {
    
    public int fib(int n) {
        int [] dp = new int[n+1];
        if(dp.length<=1)
        {
            return 0;
        }
        dp[0] = 0;
        dp[1] = 1;

        if(n<=1)
        {
            return dp[n];
        }
        for(int i =2;i<=n;i++)
        {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}