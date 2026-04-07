class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int arraySize = nums.length;
        int sum = 0;
        int size = Integer.MAX_VALUE;
        int left = 0;

        for ( int right =0;right<arraySize;right++)
        {
            sum +=nums[right];
        
            while(sum >= target)
            {
                
                size = Math.min(right-left+1,size);
                sum = sum -nums[left];
                left++;
                

            }
            
        }
        return size == Integer.MAX_VALUE ? 0 : size;
        
    }
}