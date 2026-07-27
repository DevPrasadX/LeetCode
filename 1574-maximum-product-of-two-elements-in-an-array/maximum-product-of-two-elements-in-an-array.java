class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
       
            int last = nums[nums.length-1];
            int secLast = nums[nums.length-2];
            int x = (last-1)*(secLast-1);
            return x;
        
        
    }
}