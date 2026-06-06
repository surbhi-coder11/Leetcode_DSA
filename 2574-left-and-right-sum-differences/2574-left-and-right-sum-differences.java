class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;

        int[] leftsum = new int[n];
        int[] rightsum = new int[n];

        leftsum[0]=0;
        for(int i=1;i<n;i++){
            leftsum[i] = leftsum[i-1]+nums[i-1];
        }
        rightsum[n-1] = 0;
        for(int i=n-2;i>=0;i--){
            rightsum[i] = rightsum[i+1]+nums[i+1];
        }

        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            ans[i] = leftsum[i] - rightsum[i];
            if(ans[i]<0){
                ans[i]*=-1;
            }
        }
        return ans;
    }
}