class Solution(object):
    def minimumIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        total_count = Counter(nums)
        dominant = max(total_count, key=lambda x: total_count[x])
    
    
        left_count, right_count = 0, total_count[dominant]
        n = len(nums)
    
        for i in range(n - 1):
            if nums[i] == dominant:
                left_count += 1
                right_count -= 1
            
            if left_count * 2 > (i + 1) and right_count * 2 > (n - i - 1):
                return i
    
        return -1
