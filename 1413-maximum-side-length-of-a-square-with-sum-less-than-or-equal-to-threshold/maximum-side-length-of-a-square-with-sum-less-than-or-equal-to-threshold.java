class Solution {
    public int maxSideLength(int[][] mat, int threshold) {

        int m = mat.length;
        int n = mat[0].length;


        int[][] pre = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = mat[i - 1][j - 1]
                          + pre[i - 1][j]
                          + pre[i][j - 1]
                          - pre[i - 1][j - 1];
            }
        }


        int max = 0;

        for (int len = 1; len <= Math.min(m, n); len++) {
            boolean found = false;

            for (int i = len; i <= m; i++) {
                for (int j = len; j <= n; j++) {

                    int sum = pre[i][j]
                            - pre[i - len][j]
                            - pre[i][j - len]
                            + pre[i - len][j - len];

                    if (sum <= threshold) {
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }

            if (found) max = len;
            else break; 
        }

        return max;
    }
}
