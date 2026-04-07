class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;
        int currentMaxProfit = 0;
        
        while (sell<prices.length)
        {
            if(prices[buy]<prices[sell])
            {
                currentMaxProfit = Math.max(currentMaxProfit,prices[sell]-prices[buy]);
            }
            else
            {
                buy = sell;
              
            }
              sell++;
            
        }
        return currentMaxProfit;
        
    }
}