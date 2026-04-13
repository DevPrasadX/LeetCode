import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort intervals based on start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> output = new ArrayList<>();
        output.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            int[] lastInterval = output.get(output.size() - 1);
            int lastEnd = lastInterval[1];

            if (start <= lastEnd) {
                // Merge intervals
                lastInterval[1] = Math.max(lastEnd, end);
            } else {
                // No overlap, add new interval
                output.add(new int[]{start, end});
            }
        }

        // Convert List to Array
        return output.toArray(new int[output.size()][]);
    }
}