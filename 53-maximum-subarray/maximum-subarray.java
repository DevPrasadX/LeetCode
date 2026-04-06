class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSubArray = nums[0];
        int arraySize=nums.length;
        for (int i =0;i<arraySize;i++)
        {
            if (currentSum<0)
            {
                currentSum = 0;
            }
            currentSum += nums[i];
            maxSubArray = Math.max(maxSubArray,currentSum);

        }
        return maxSubArray;
    }
}