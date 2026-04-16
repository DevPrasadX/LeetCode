class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
      
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }
        
        List<Integer>list = new ArrayList<>();
        for(int q:queries)
        {
            List<Integer>indices = map.get(nums[q]);
         
            if(indices.size()==1)
            {
                list.add(-1);
                continue;
            }
            int position = Collections.binarySearch(indices,q);
            int size = indices.size();

            int prev = indices.get((position-1+size)%size);
            int next = indices.get((position+1)%size);
         
            int distNext= Math.min(Math.abs(next-q),n- Math.abs(next-q));
            int distPrev= Math.min(Math.abs(prev-q),n-Math.abs(q-prev));
            list.add(Math.min(distNext,distPrev));
        }
        
        return list;
        
    }
}