import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        int ans = nums.length+1;
        for(int i = 0;i<nums.length-2;i++)
        {
            for(int j=i+1;j<nums.length-1;j++)
            {
                if(nums[i]!=nums[j])
                {
                    continue;
                }
                for(int k=j+1;k<nums.length;k++)
                {
                    if(nums[j]==nums[k])
                    {
                        ans = Math.min(ans,k-i);
                    }
                }
            }
        }
        if(ans == nums.length+1 )
        {
            return -1;
        }
        return ans*2;
    }
}