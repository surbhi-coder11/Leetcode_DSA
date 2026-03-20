class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid =nums[nums.length/2];
        int tm = 0;
        for(int i : nums){
            tm+=Math.abs(i-mid);
        }
        return tm;
    }
}