class Solution {
    public int largestAltitude(int[] gain) {
        
        int max = 0;  // Start at 0 (the starting altitude)
        int t = gain[0];
        max = Math.max(t, max); // Check first altitude
        
        for (int i = 1; i < gain.length; i++) {
            t = t + gain[i];
            max = Math.max(t, max);
        }
        
        return max;
    }
}