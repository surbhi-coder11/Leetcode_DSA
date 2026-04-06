class Solution {
    // private static int searchsorted(int[] nums, int tar, int st , int en){
    //     if(st>en){
    //         return -1;
    //     }
    //     if(nums[mid]==tar){
    //         return mid;
    //     }
    //     int mid = (st+en)/2;
    //     if(nums[st]<=nums[mid]){

    //     }else{
    //         if(nums[mid]<=tar && tar<=nums[en]){
    //             st = mid+1;
    //             return 
    //         }else{
    //             en = mid-1;
    //         }
    //     }
    //     return -1;
    // }
    public int search(int[] nums, int target) {
        int st =0;
        int en = nums.length-1;
        while(st<=en){
          int mid = (st+en)/2;
          if(nums[mid]==target){
            return mid;
          }
          if(nums[st]<=nums[mid]){
            if(nums[mid]>=target && nums[st]<=target){
                en=mid-1;
            }else{
                st=mid+1;
            }
          }else{
            if(nums[mid]<=target && nums[en]>=target){
              st = mid+1;
            }else{
                en = mid-1;
            }
          }
        }
        return -1;
    }
}