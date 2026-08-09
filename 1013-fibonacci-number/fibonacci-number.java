class Solution {
    public int f(int n, int [] dp)
    {
        if(n<=1)
        {
            return n;
        }
        
        return dp[n]= f(n-1,dp)+f(n-2,dp);
    }
    public int fib(int n) {
        int [] dp = new int [n+1];
        Arrays.fill(dp, -1);
        int x = f(n,dp);
        return x;        
    }
}