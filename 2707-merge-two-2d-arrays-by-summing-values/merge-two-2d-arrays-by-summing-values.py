from collections import defaultdict
class Solution(object):
    def mergeArrays(self,nums1, nums2):
        merged = defaultdict(int)
        for id, val in nums1:
            merged[id] += val
        
        for id, val in nums2:
            merged[id] += val
        
        return sorted(merged.items())
        