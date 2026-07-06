class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
       
        Arrays.sort(intervals, (a,b) -> {
    if(a[0] == b[0]) return b[1] - a[1];
    return a[0] - b[0];
});

int count = 0;
int prevEnd = 0;

for(int[] in : intervals) {
    if(in[1] <= prevEnd) {
        count++; // covered
    } else {
        prevEnd = in[1];
    }
}

return intervals.length - count;
        
    }
}