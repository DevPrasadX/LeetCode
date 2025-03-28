import java.util.*;

class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;
        int[] result = new int[queries.length];

        int[][] indexedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            indexedQueries[i] = new int[]{queries[i], i};
        }
        Arrays.sort(indexedQueries, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[m][n];

        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;
        int count = 0;  
        for (int[] query : indexedQueries) {
            int queryValue = query[0], queryIndex = query[1];

            while (!minHeap.isEmpty() && minHeap.peek()[0] < queryValue) {
                int[] cell = minHeap.poll();
                int value = cell[0], r = cell[1], c = cell[2];
                count++;

                for (int[] d : directions) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        minHeap.offer(new int[]{grid[nr][nc], nr, nc});
                    }
                }
            }

            result[queryIndex] = count;
        }

        return result;
    }
}