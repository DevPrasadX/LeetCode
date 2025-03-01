class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        
        int maxLength = 0;
        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (isPalindrome(sub) && sub.length() > maxLength) {
                    longest = sub;
                    maxLength = sub.length();
                }
            }
        }
        return longest;
    }

    // Function to check if a string is a palindrome
    private boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
