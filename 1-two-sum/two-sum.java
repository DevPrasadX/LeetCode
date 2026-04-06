class Solution {
    public int[] twoSum(int[] nums, int target) {
       
       int arraySize = nums.length;

       
       HashMap <Integer,Integer> maps = new HashMap <> ();
       for (int i =0;i<arraySize;i++)
       {
       int  difference = target - nums[i];
        if(maps.containsKey(difference))
        {
            System.out.println(maps.get(difference)+" "+i);
           return new int[] { maps.get(difference), i };
        }
        maps.put(nums[i],i);
       }
       return new int [] {};
    }
}