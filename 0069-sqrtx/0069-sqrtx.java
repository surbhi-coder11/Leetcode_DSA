class Solution {
    public int mySqrt(int x) {
        long en= x;
        long st =0;
        long ans=0;
        while(st<=en){
            long mid =(st+en)/2;
            if(mid*mid<=(long)x){
                ans= mid;
                st= mid+1;

            }
            else{
                en = mid-1;

            }
        }
        return (int)ans;
    }
}