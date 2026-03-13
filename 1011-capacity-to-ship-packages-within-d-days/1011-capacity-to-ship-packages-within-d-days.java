class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = 0;
        int max =0;
        for(int i=0;i<weights.length;i++){
            if(min<weights[i]){
                min = weights[i];
            }
            max+=weights[i];
        }
        while(min<max){
            int mid = (min+max)/2;
            int day = 0;
            // for(int wt :weights){
            //     day+=(wt+mid-1)/mid;
            // }
            if(checkcapacity(weights,days,mid)){
                max = mid;
            }
            else{
                min = mid+1;
            }

        }
        return min;
    }
    private boolean checkcapacity(int[] weights,int days, int capacity){
        int load =0;
        int day =1;
        for(int wt :weights){
            if(load+wt> capacity){
                day++;
                load =0;
            }
            load+=wt;
        }
        return day<=days;
    }
}