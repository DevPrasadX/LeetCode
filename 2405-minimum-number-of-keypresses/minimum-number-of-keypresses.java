class Solution {
// approach will be to first calculate freq of each character appearing in this string.
// after checking them, we will sort the array in ascending order.
// based on position, 0-8 freq will be multiplied by 1 , 9-17 by 2, 18-25 by 3
// then sum of these will be returned as the output 
    public int minimumKeypresses(String s) {
    int [] frequency = new int [26];
    for (char c : s.toCharArray())
    {
        frequency[c-'a']++;
    }
    
          Arrays.sort(frequency);
        

        int res = 0;
        int count = 0;
        for (int i = 25; i >= 0; i--) {
            res += frequency[i] * (count/9 + 1);
            count++;
        }
        return res;
        
    }
}