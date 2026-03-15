class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l =0;
        int high = n-1;
        int mid =0;
        while(mid<=high){
            if(nums[mid] == 0){
                //swap(nums[mid], nums[l]);
                int temp = nums[l] ;
                nums[l]= nums[mid];
                nums[mid] = temp;
                l++;
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                //swap(nums[high],nums[mid]);
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
        
    }
    // private void swap(int a, int b){
    //     int temp = a;
    //     a=b;
    //     b=temp;
    // }
}