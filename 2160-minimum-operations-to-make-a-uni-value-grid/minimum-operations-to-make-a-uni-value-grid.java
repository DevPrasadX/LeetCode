import java.util.*;

class Solution {
    public static List<Integer> convertGridToList(int[][] grid) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : grid) {
            for (int num : row) {
                list.add(num);
            }
        }
        return list;
    }

    public int minOperations(int[][] grid, int x) {
        List<Integer> list = convertGridToList(grid);
        Collections.sort(list);
        
        int median = list.get(list.size() / 2);
        int operations = 0;

        for (int num : list) {
            int diff = Math.abs(num - median);
            if (diff % x != 0) return -1; 
            operations += diff / x;
        }

        return operations;
    }
}
