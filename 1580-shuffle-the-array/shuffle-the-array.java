class Solution {
    public int[] shuffle(int[] nums, int n) {
        List<Integer> list = new ArrayList<>();
         List<Integer> list2 = new ArrayList<>();
           List<Integer> list3 = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
           list.add(nums[i]);
        }
         for(int i=n;i<nums.length;i++)
        {
           list2.add(nums[i]);
        }
        for(int i=0;i<n;i++)
        {
            list3.add(list.get(i));
            list3.add(list2.get(i));
        }
                   int[] array = new int[list3.size()];
        for(int i=0;i<list3.size();i++)
        {
            array[i]=list3.get(i);
        }

        return array;
    }
}