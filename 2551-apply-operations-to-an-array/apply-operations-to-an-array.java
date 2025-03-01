class Solution {
    public int[] applyOperations(int[] nums) {
       int index = 0;
       
    //    this part of code handles the checking of consecutive numbers along with multiplication and 0 alloting according to rules
       for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i + 1]) 
            {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        
        // this ensures that once generated, all zero will be shifted to extreme right of the array
        for (int i = 0; i <  nums.length; i++) {
            if (nums[i] != 0) 
            {
                nums[index++] = nums[i];
            }
        } 
        
        // just to fill remaining spaces in array with 0
        while (index <  nums.length) 
        {
            nums[index++] = 0;
        }
        return nums;


        
    }
}