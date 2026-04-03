class Solution {
    public int[] searchRange(int[] nums, int target) {
         int[] ans = new int[2];
         Arrays.fill(ans,-1);
         if(nums.length!=0){
         ans[0] = firstocc(nums,target,0);
         ans[1] =lastocc(nums,target,nums.length-1);
         }
         return ans;
    }
    private static int lastocc(int[] arr, int tar, int idx){
        if(idx==0 && arr[idx]!=tar){
            return -1;
        }
        if(arr[idx]==tar){
            return idx;
        }
        return lastocc(arr,tar,idx-1);
    }
    private static int firstocc(int[] arr, int tar, int idx){
        if(idx==arr.length){
            return -1;
        }
        if(arr[idx]==tar){
            return idx;
        }

        return firstocc(arr,tar,idx+1);
    }
}