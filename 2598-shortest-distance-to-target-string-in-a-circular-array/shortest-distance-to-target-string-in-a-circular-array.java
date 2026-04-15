class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {       
        int n = words.length;
        int ans_left = startIndex;
        int ans_right= startIndex;
        
        for(int steps = 0;steps<=n/2;steps++)
        {
            if(words[ans_left].equals(target)||words[ans_right].equals(target))
            {
                return steps;
            }
            ans_left =  (ans_left - 1 + n)%n;
            ans_right = (ans_right+1)%n;
        }
        return -1;

    }
}

