class Solution(object):
    def largestInteger(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        n = len(nums)
        count = [0] * 51  
        
        for i in range(n - k + 1):
            subarray = nums[i:i + k]
            unique_elements = set(subarray)
            for num in unique_elements:
                count[num] += 1
        
        result = -1
        for num in range(50, -1, -1):  
            if count[num] == 1:
                result = num
                break
        
        return result
