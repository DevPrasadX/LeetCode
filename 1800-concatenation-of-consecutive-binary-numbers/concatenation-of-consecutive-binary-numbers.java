class Solution {
    public int concatenatedBinary(int n) {
        int MOD = 1_000_000_007;
        long result = 0;

        for (int i = 1; i <= n; i++) {
            int length = Integer.toBinaryString(i).length();  
            result = ((result << length) % MOD + i) % MOD;
        }

        return (int) result;
    }
}