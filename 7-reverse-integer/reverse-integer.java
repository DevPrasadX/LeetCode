class Solution {
    public int reverse(int num) {
        int reversed = 0;

        while (num != 0) {
            int digit = num % 10;
            
            // Check for overflow before updating reversed
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            
            reversed = reversed * 10 + digit;
            num /= 10;
        }

        return reversed;
    }
}
