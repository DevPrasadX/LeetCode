class Solution {
    public long maximumTripletValue(int[] nums) {
int n = nums.length;
        int maxPrefix = nums[0]; // Track maximum nums[i]
        long maxValue = 0;

        for (int j = 1; j < n - 1; j++) {
            for (int k = j + 1; k < n; k++) {
                long value = (long)(maxPrefix - nums[j]) * nums[k];
                maxValue = Math.max(maxValue, value);
            }
            maxPrefix = Math.max(maxPrefix, nums[j]);
        }

        return maxValue;
    }
}