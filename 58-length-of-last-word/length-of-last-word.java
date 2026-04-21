class Solution {
    public int lengthOfLastWord(String s) {
        int p2 = s.length() - 1;
        int counter = 0;

        // Step 1: skip trailing spaces
        while (p2 >= 0 && s.charAt(p2) == ' ') {
            p2--;
        }

        // Step 2: count last word
        while (p2 >= 0 && s.charAt(p2) != ' ') {
            counter++;
            p2--;
        }

        return counter;
    }
}