class Solution {
    public int majorityElement(int[] nums) {
       int n = nums.length;
       //brute force
    //    for(int num : nums){
    //       int freq =0;
    //       for(int i=0;i<n;i++){
    //         if(nums[i] == num){
    //             freq++;
    //         }
    //       }
    //       if(freq>(n/2)){
    //         return num;
    //       }

    //    }
    //    return 0;

    // optimized 

    Arrays.sort(nums);
    int  ans = nums[0];
    int freq = 1;
    for(int i=1;i<n;i++){
        if(nums[i] == nums[i-1]){
            freq++;
        }
        else{
            freq=1;
            ans=nums[i];
        }

        if(freq>(n/2)){
            return ans;
        }
    }

       return 0;
    

    }
}