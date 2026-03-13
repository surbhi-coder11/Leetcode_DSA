class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];
        int actsum =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                actsum+=grid[i][j];
                int gd = grid[i][j];
                // if(map.containskey(gd)){
                //     ans[0] = gd;
                // }
                if(map.containsKey(gd)){
                    ans[0] = gd;
                }
                map.put(gd,i);
            }
        }
        int n = grid.length;
        int exp =( n*n *(n*n+1)) /2;
        ans[1]  = exp+ans[0] - actsum;

        return ans;
         

    }
}