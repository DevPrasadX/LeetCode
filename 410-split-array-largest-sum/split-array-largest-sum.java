class Solution {
    public int splitArray(int[] nums, int k) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();
        
        while(left<right)
        {
            int mid = (left+right)/2;
            if (canSplit(nums,mid,k))
            {
                right = mid;
            }
            else
            {
                left = mid+1;
            }
        }
        return left;


        
    }

    public boolean canSplit(int[] nums, int mid,int k)
    {
        int count = 1;
        int currentSum = 0;

        for(int num: nums)
        {
            if(currentSum + num > mid)
            {
                count = count+1;
                currentSum = num;
            }
            else
            {
                currentSum += num;
            }
            if(count>k)
            {
                return false;
            }

        }
        return true;
    }
}