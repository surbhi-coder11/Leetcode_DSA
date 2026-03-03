class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int cs =0;
        int maxsum = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            cs+=nums[i];
            maxsum = Math.max(cs,maxsum);
            if(cs<0){
                cs=0;
            }
        }
        return maxsum;
    }
}