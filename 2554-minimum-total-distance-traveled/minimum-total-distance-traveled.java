class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {

        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        int n = robot.size();
        int m = factory.length;

        long[][] dp = new long[n + 1][m + 1];

        // Initialize DP
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }

        // Base case: 0 robots → 0 distance
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        // DP computation
        for (int j = 1; j <= m; j++) {
            int pos = factory[j - 1][0];
            int limit = factory[j - 1][1];

            for (int i = 1; i <= n; i++) {

                // Option 1: skip this factory
                dp[i][j] = dp[i][j - 1];

                long cost = 0;

                // Option 2: assign k robots to this factory
                for (int k = 1; k <= Math.min(i, limit); k++) {
                    cost += Math.abs(robot.get(i - k) - pos);

                    if (dp[i - k][j - 1] != Long.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j],
                                dp[i - k][j - 1] + cost);
                    }
                }
            }
        }

        return dp[n][m];
    }
}