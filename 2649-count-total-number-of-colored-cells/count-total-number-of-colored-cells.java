class Solution {
    public long coloredCells(int n) {
        long num=n;
        long x=n-1;
         return num*num + x*x;
        //       long num = n;  // Convert n to long
        // return 2 * num * (num - 1) + 1;

        
    }
}