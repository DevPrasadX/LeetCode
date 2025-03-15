import java.util.Arrays;

class Solution {
    public int minCapability(int[] nums, int k) {
        int left = Arrays.stream(nums).min().getAsInt();
        int right = Arrays.stream(nums).max().getAsInt();
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (canRob(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canRob(int[] nums, int k, int maxCapability) {
        int count = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= maxCapability) {
                count++;
                i++;  
            }
            i++;
        }
        return count >= k;
    }
}
