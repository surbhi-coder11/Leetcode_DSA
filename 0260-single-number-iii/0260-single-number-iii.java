class Solution {
    public int[] singleNumber(int[] nums) {
        int xor =0;
        for(int i=0;i<nums.length;i++){
             xor^=nums[i];
        }

        int mask = xor &(-xor);
        int g1 =0;
        int g2=0;
        for(int i=0;i<nums.length;i++){
            if((mask &nums[i])==0){
                g1^=nums[i];
            }else{
                g2^=nums[i];
            }

        }
        int[] n = new int[2];
        n[0] = g1;
        n[1]= g2;

        return n;
    }
}