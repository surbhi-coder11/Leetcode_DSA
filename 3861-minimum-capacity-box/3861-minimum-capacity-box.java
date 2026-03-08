class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int n = capacity.length;
        int idx = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            if(capacity[i]<min && capacity[i]>=itemSize){
                min = capacity[i];
                idx = i;
            }
        }

        return idx;
    }
}