class Solution {
    public void rotate(int[] nums, int k) {
        int n =nums.length;
        k=k%n;
        int news[] = new int[k];
        int idx=0;
        for(int i=n-k;i<n;i++){
            news[idx] = nums[i];
            idx++;
        }
        for(int i=n-k-1;i>=0;i--){
            nums[i+k]=nums[i];
        }
        for(int i=0;i<k;i++){
            nums[i]=news[i];
        }   
    }
}