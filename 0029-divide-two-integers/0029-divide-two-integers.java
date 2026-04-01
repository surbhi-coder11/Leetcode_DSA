class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend== Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
        int res =0;
        Boolean sign = (dividend<0)^(divisor<0);
        long dvd = Math.abs((long)dividend);
        long dvr = Math.abs((long)divisor);
        for(int i=31;i>=0;i--){
           while((dvr<<i)<=dvd){
            dvd-=(dvr<<i);
            res+=(1<<i);
           }
        }
        return sign? -res : res;
    }
}