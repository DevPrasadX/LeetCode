class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
         int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        // FIRST WE WILL GENERATE THE LOWEST COMMON SUBSEQ
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // WE WILL NOW BACKTRACK TO BUILD THE SHORTEST COMMON SUPERSEQUENCE
        int i = m, j = n;
        StringBuilder sb = new StringBuilder();
        
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(str1.charAt(i - 1));
                i--;
            } else {
                sb.append(str2.charAt(j - 1));
                j--;
            }
        }
        
        // NOW LETS APPEND REMAINING CHAR FROM STRING1 
        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }
        
           // NOW LETS APPEND REMAINING CHAR FROM STRING2 
        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }
        
        //TO GET CORRECT ORDER, WE WILL REVERSE AND CONVERT TO STRING
        return sb.reverse().toString();
    }
    }

