import java.util.Arrays;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        int[] oneDArray = new int[size];

        // we will first convert 2D array to 1D array
        int index = 0;
        for (int[] row : grid) {
            for (int num : row) {
                oneDArray[index++] = num;
            }
        }

        // thenw we will sort the 1D array in ascending order
        Arrays.sort(oneDArray);

        // to find repeated and missing numbers we will set var
        int repeated = -1, missing = -1;

        for (int i = 1; i < size; i++) {
            if (oneDArray[i] == oneDArray[i - 1]) {
               repeated = oneDArray[i];  // if we Found the repeated number, we will set the number to var repeated
            } else if (oneDArray[i] > oneDArray[i - 1] + 1) {
                missing = oneDArray[i - 1] + 1; // if we Found the missing number, we will set the number to var msising
            }
        }

        // If missing number is not found, it must be the last number (n*n)
        if (missing == -1) {
            missing = (oneDArray[size - 1] == size) ? oneDArray[0] - 1 : size;
        }

        return new int[]{repeated, missing};
    }
}