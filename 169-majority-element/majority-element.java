class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer>map = new HashMap<>();
        for(int num : nums)
        {
  
                map.put(num, map.getOrDefault(num, 0) + 1);

        }
      
        int n = nums.length;

        // Find majority element
        for (int key : map.keySet()) {
            if (map.get(key) > n / 2) {
                return key;
            }
        }

        return -1; // not needed if majority always exists
    }
}