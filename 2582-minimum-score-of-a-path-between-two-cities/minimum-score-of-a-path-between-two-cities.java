import java.util.*;

class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] adj = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            int a = road[0], b = road[1], d = road[2];
            adj[a].add(new int[]{b, d});
            adj[b].add(new int[]{a, d});
        }
        
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int ans = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int[] edge : adj[u]) {
                int v = edge[0], d = edge[1];
                ans = Math.min(ans, d);
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
        
        return ans;
    }
}