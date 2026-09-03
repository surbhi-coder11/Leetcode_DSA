class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        //Finding Minimumin the Array
        for(int x:nums1){
            if(x%2 != 0){
                 min = Math.min(x,min);
            }
        }
        
        //check min is odd or even
        // boolean check = true;
        // if((min%2)!=0){
        //     check = false;
        // }
       for(int x:nums1){
        if(x%2==0 && min!= Integer.MAX_VALUE && x<min){
            return false;
        }
       }
        return true;
    }
}