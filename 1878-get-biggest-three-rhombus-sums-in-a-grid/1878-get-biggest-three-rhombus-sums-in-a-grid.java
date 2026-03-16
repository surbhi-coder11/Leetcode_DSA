class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        TreeSet<Integer> sums = new TreeSet<>(Collections.reverseOrder());
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sums.add(grid[i][j]);

                for(int L = 1 ; i+2*L<m && j-L >=0 && j+L<n ; L++){
                    int cur = calculatesum(grid,i,j,L);
                    sums.add(cur);
                }
            }
        }
        return sums.stream().limit(3).mapToInt(Integer:: intValue).toArray();
    }
    private int calculatesum(int[][] grid, int r , int c , int L){
        int sum =0;
        for(int i=0; i<L ;i++){
          sum+=grid[r+i][c+i];
        }
        for(int i=0; i<L ;i++){
            sum+= grid[r+L+i][c+L-i];
        }
        for(int i=0; i<L ;i++){
            sum+=grid[r+2*L-i][c-i];
        }
        for(int i=0; i<L ;i++){
          sum+= grid[r+L-i][c-L+i];  
        }
        return sum;
    }
}