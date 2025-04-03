class Solution {
public:
    long long maximumTripletValue(vector<int>& nums) {
        int n = nums.size();
        if (n < 3) return 0;
        
        long long maxVal = 0;
        int maxPrefix = nums[0];
        vector<int> suffixMax(n, 0);
        
        suffixMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            suffixMax[i] = max(suffixMax[i + 1], nums[i]);
        }

        for (int j = 1; j < n - 1; ++j) {
            if (maxPrefix > nums[j]) { 
                maxVal = max(maxVal, (long long)(maxPrefix - nums[j]) * suffixMax[j + 1]);
            }
            maxPrefix = max(maxPrefix, nums[j]);
        }

        return maxVal;
    }
};