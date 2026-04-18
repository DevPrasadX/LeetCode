class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i=0;
        while (i < n) {
        if (nums[i] == val) {
            nums[i] = nums[n - 1]; // swap with last
            n--; // reduce size
        } else {
            i++;
        }
    }
        return n;
        
    }
}