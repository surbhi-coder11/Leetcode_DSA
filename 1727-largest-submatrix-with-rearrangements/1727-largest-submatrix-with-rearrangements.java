class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] height = new int[m][n];
        for (int j = 0; j < n; j++) {
            height[0][j] = matrix[0][j];
            for (int i = 1; i < m; i++) {
                if (matrix[i][j] == 1) {
                    height[i][j] = height[i - 1][j] + 1;
                } else {
                    height[i][j] = 0;
                }
            }
        }
        int maxArea =0;
           for (int i = 0; i < m; i++) {
            int[] row = height[i].clone();
            Arrays.sort(row);
            
            for (int j = n - 1; j >= 0; j--) {
                int width = n - j;
                int area = row[j] * width;
                maxArea = Math.max(maxArea, area);
            }
        }
        
        return maxArea;
    }
}