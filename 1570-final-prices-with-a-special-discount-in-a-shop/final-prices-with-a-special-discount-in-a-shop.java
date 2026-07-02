class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int [] answer = new int[prices.length];
        for(int i=0;i<prices.length;i++)
        {
            while(!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int idx = stack.pop();
            answer[idx] = prices[idx] - prices[i];
            }
           
            stack.push(i);
        }
         while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices[idx];
        }
        return answer;
        
    }
}