class Solution {
    public long coloredCells(int n) {
       long num = n;  // Convert n to long
        return 2 * num * (num - 1) + 1;

        
    }
}