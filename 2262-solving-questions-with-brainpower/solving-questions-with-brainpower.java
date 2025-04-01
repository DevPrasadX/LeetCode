import java.util.*;

class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        LinkedList<Long> dp = new LinkedList<>();
        long[] memo = new long[n];
        Arrays.fill(memo, -1);
        
        return solve(questions, 0, memo);
    }
    
    private long solve(int[][] questions, int index, long[] memo) {
        if (index >= questions.length) return 0;
        if (memo[index] != -1) return memo[index];
        

        long solve = questions[index][0] + solve(questions, index + questions[index][1] + 1, memo);
        
 
        long skip = solve(questions, index + 1, memo);
        
        memo[index] = Math.max(solve, skip);
        return memo[index];
    }
}