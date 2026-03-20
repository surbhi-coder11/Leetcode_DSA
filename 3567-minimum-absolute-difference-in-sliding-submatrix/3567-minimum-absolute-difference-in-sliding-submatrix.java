class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] ans = new int[n-k+1][m-k+1];
         for(int i=0;i<=n-k;i++){
            for(int j= 0;j<=m-k;j++){
                List<Integer> sp = new ArrayList<>();
                for(int row=i;row<i+k;row++){
                   for(int col =j ;col<j+k;col++){
                     sp.add(grid[row][col]);
                   }
                }
                Collections.sort(sp);
                int mindiff =Integer.MAX_VALUE;
                for(int l =0;l<sp.size()-1;l++){
                    if(!sp.get(l).equals(sp.get(l+1))){
                        int diff = Math.abs(sp.get(l)-sp.get(l+1));
                        if(diff<mindiff){
                            mindiff = diff;
                        }
                    }
                }
                if(k==1){
                    ans[i][j] = 0;
                }else if(mindiff == Integer.MAX_VALUE){
                    ans[i][j] = 0;
                }
                else{
                    ans[i][j] = mindiff;
                }
            }

        }
        return ans;
    }
}