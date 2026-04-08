class Pair
{
    int first;
    int second;
    public Pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}
class Solution {
  
private void bfs(int row, int col, int[][] visitedGrid,char[][] grid)
    {
       visitedGrid[row][col] = 1;
       Queue<Pair> q = new LinkedList<Pair>();
       q.add(new Pair(row,col));
       int n = grid.length;
       int m = grid[0].length;

       while(!q.isEmpty())
       {
        int  queue_row = q.peek().first;
        int queue_column = q.peek().second;
        q.remove(); 

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nrow = queue_row + dRow[i];
            int ncol = queue_column + dCol[i];

            if (nrow >= 0 && nrow < n &&
                ncol >= 0 && ncol < m &&
                grid[nrow][ncol] == '1' &&
                visitedGrid[nrow][ncol] == 0) {

                visitedGrid[nrow][ncol] = 1;
                q.add(new Pair(nrow, ncol));
            }
        }
       }
       }
    

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] visitedGrid = new int [n][m];   
        int count = 0;
        for(int row=0; row<n; row++)

        {
            for( int col = 0; col< m; col++)
            {
                if(visitedGrid[row][col] == 0 && grid[row][col]=='1')
                {
                    count++;
                    bfs(row,col,visitedGrid,grid);
                }
            } 
        }
            
        return count;

    }
}