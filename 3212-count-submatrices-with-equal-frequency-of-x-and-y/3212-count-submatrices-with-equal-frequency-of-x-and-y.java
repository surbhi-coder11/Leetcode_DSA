class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int prefix[][] = new int[m][2];
        int ans =0;
        for(int i=0;i<n;i++){
            int x =0;
            int y =0;
            for(int j=0;j<m;j++){
                if(grid[i][j] =='X'){
                    x++;
                }if(grid[i][j] == 'Y'){
                    y++;
                }
                prefix[j][0]+=x;
                prefix[j][1]+=y;
                if(prefix[j][0] > 0 && prefix[j][0] == prefix[j][1]){
                    ans++;
                }
            }
        }
        return ans;
    }
}