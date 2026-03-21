class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for(int i=0;i<k/2;i++){
            for(int j=0;j<k;j++){
                int ur = i+x;
                int lr = x+k-1-i;
                int currcol = y+j;
                int temp = grid[ur][currcol];
                grid[ur][currcol] = grid[lr][currcol];
                grid[lr][currcol] = temp;
                
            }
        }

        return grid;
    }
}