class Solution {
    public long coloredCells(int n) {
        long num=n; //we need to take LONG instead if int because at testcase 52 , result of the calculation exceeded the maximum value of an int
        long x=n-1; // this will store previous number of input
        return num*num + x*x; //this is ,y derived mathematical formula
 
        
    }
}