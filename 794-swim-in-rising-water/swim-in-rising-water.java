import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        boolean[][] visited = new boolean[n][n];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); 
        // Each element = [elevation, x, y]
        pq.offer(new int[]{grid[0][0], 0, 0});
        
        int time = 0;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int elevation = cur[0], x = cur[1], y = cur[2];
            
            time = Math.max(time, elevation); // water must rise to at least this level
            if (x == n - 1 && y == n - 1) return time; // reached destination
            
            if (visited[x][y]) continue;
            visited[x][y] = true;
            
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    pq.offer(new int[]{grid[nx][ny], nx, ny});
                }
            }
        }
        
        return -1; // should never reach here
    }
}
