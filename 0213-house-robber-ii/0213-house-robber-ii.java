class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robRange(nums, 0, n-2), robRange(nums, 1, n-1));
    }

    public int robRange(int[] nums, int start, int end){
        int t0 = nums[start];
        int t1 = Math.max(nums[start], nums[start+1]);

        for(int i = start+2; i<=end; i++){
            int curr = Math.max(nums[i] + t0, t1);
            t0 = t1;
            t1 = curr;
        }

        return t1;
    }
}