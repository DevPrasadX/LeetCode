class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int i=0;
        int prev = 1;
        int fin = 1;
        for(i=1;i<arr.length;i++)
        {
           int x = Math.min(arr[i],prev+1);
           prev = x;
           fin = Math.max(x,fin);
           System.out.println(fin);
        }
        return fin;
        
    }
}