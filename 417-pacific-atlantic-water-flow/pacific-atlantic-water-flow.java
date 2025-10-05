
import java.util.*;

class Solution {
    private int m, n;
    private int[][] heights;
    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0) return result;
        
        this.m = heights.length;
        this.n = heights[0].length;
        this.heights = heights;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // Pacific borders (top row & left column)
        for (int c = 0; c < n; c++) {
            dfs(0, c, pacific, heights[0][c]);
            dfs(m-1, c, atlantic, heights[m-1][c]);
        }
        for (int r = 0; r < m; r++) {
            dfs(r, 0, pacific, heights[r][0]);
            dfs(r, n-1, atlantic, heights[r][n-1]);
        }
        
        // Collect cells that can reach both oceans
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int r, int c, boolean[][] visited, int prevHeight) {
        if (r < 0 || r >= m || c < 0 || c >= n) return;
        if (visited[r][c]) return;
        if (heights[r][c] < prevHeight) return;  // can't flow uphill
        
        visited[r][c] = true;
        
        for (int[] dir : directions) {
            dfs(r + dir[0], c + dir[1], visited, heights[r][c]);
        }
    }
}
