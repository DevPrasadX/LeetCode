
class Solution {
    public long repairCars(int[] ranks, int cars) {
// we use binary search on time to efficiently determine the minimum time required.
        Arrays.sort(ranks);
        long left = 1, right = (long) ranks[0] * cars * cars;
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canRepairAll(ranks, cars, mid)) {
                right = mid; 
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canRepairAll(int[] ranks, int cars, long time) {
        int repaired = 0;
        for (int rank : ranks) {
            repaired += (int) Math.sqrt(time / rank); 
            if (repaired >= cars) return true;
        }
        return false;
    }
}