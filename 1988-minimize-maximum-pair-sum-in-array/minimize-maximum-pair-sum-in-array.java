class Solution {
    public int minPairSum(int[] nums) {
        // int[] x = nums;
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        

        int maxSum = 0;
        int n = nums.length;

        for (int i = 0; i < n / 2; i++) {
            maxSum = Math.max(maxSum, nums[i] + nums[n - 1 - i]);
        }

        return maxSum;
        
    }
}