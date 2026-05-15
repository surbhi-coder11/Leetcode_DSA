class Solution {
    public int findMin(int[] nums) {
        int st=0;
        int en = nums.length-1;
        int idx=-1;
        if(nums.length==1)
        return nums[0];
        while(st<en){
            int mid =(st+en)/2;
            if((nums[st]<=nums[mid]) && (nums[mid+1]<=nums[en])){
                if(nums[mid]<nums[en]){
                    idx=st;
                }
                else{
                    idx=mid+1;
                }
                break;
            }
            if(nums[st]<nums[mid]){
                st=mid+1;
            }
            else{
                en=mid;
            }
        }
        return nums[idx];
    }
}