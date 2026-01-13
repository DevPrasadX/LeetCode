class Solution {
    public double separateSquares(int[][] squares) {
        double left = Double.MAX_VALUE;
        double right = Double.MIN_VALUE;
        
        for (int[] square : squares) {
            int y = square[1];
            int l = square[2];
            left = Math.min(left, y);
            right = Math.max(right, y + l);
        }
        
        double totalArea = 0;
        for (int[] square : squares) {
            int l = square[2];
            totalArea += (long) l * l;
        }
        
        double target = totalArea / 2.0;
        
        for (int i = 0; i < 100; i++) { 
            double mid = (left + right) / 2;
            double areaBelow = calculateAreaBelow(squares, mid);
            
            if (areaBelow < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    private double calculateAreaBelow(int[][] squares, double c) {
        double area = 0.0;
        for (int[] square : squares) {
            int x = square[0];
            int y = square[1];
            int l = square[2];
            
            if (c <= y) {
                area += 0;
            } else if (c >= y + l) {
                area += (long) l * l;
            } else {
                double heightBelow = c - y;
                area += heightBelow * l;
            }
        }
        return area;
    }
}