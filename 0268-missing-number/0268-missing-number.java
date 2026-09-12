class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor =0;
        for(int i=1;i<=n;i++){
           xor^=i;
           //xor^=nums[i];
        }
        for(int num: nums){
            xor^=num;
        }

        return xor;
    }
}