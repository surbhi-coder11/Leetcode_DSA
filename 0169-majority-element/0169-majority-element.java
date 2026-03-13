class Solution {
    public int majorityElement(int[] nums) {
       int n = nums.length;
       for(int num : nums){
          int freq =0;
          for(int i=0;i<n;i++){
            if(nums[i] == num){
                freq++;
            }
          }
          if(freq>(n/2)){
            return num;
          }

       }
       return 0;

    }
}