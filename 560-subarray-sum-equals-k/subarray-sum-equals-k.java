class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int currentSum = 0;
        Map<Integer,Integer>prefixSum = new HashMap<>();
        prefixSum.put(0,1);
        int difference = 0;
        System.out.println(prefixSum);
        for(int n : nums)
        {
            currentSum = currentSum + n;
            difference = currentSum-k;
            result = result +prefixSum.getOrDefault(difference,0);
            prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);

        }
        
        return result;

        // int p1 = 0;
        // int p2 = 0;
        // int sum = 0;
        // int x = 0;
        // for(int i = 0;i<nums.length;i++)
        // {
        //     if(p1!=p2)
        //     {
        //         while(sum<k)
        //         {
        //             sum = nums[p1]+nums[p2];
        //         }
        //         if(sum==k)
        //         {
        //             x++;
        //         }
        //         p1++;
        //     }
        //     p2++;
           
        // }

        // return x;
    }
}